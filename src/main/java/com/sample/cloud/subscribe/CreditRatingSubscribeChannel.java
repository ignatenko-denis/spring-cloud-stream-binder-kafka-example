package com.sample.cloud.subscribe;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.SubscribableChannel;

public interface CreditRatingSubscribeChannel {
    @Input(CreditRatingSubscribeListener.CREDIT_RATING)
    SubscribableChannel creditRating();
}
