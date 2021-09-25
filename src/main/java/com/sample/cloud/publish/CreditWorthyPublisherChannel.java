package com.sample.cloud.publish;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

public interface CreditWorthyPublisherChannel {
    @Output(CreditWorthyPublisher.CREDIT_WORTHY_PUBLISH)
    MessageChannel creditWorthy();
}
