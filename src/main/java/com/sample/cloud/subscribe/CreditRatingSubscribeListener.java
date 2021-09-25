package com.sample.cloud.subscribe;

import com.sample.dto.ClientRq;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.context.annotation.Configuration;

@Slf4j
@Configuration
@RequiredArgsConstructor
public class CreditRatingSubscribeListener {
    private final CreditRatingSubscribeListenerService listenerService;

    public static final String CREDIT_RATING = "creditRatingSubscribe";

    @StreamListener(CREDIT_RATING)
    void creditRating(ClientRq rq) {
        try {
            log.info("receive: {}", rq);
            listenerService.creditRating(rq);
        } catch (Exception e) {
            log.error("Error in class CreditRatingSubscribeListener", e);
        }
    }
}
