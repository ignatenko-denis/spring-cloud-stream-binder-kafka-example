package com.sample.cloud.publish;

import com.sample.dto.ClientRs;
import org.springframework.integration.annotation.Gateway;
import org.springframework.integration.annotation.MessagingGateway;

@MessagingGateway
public interface CreditWorthyPublisher {
    String CREDIT_WORTHY_PUBLISH = "creditWorthyPublish";

    @Gateway(requestChannel = CREDIT_WORTHY_PUBLISH)
    void creditWorthy(ClientRs msg);
}
