package com.sample.cloud.publish;

import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableBinding(CreditWorthyPublisherChannel.class)
public class CreditWorthyPublisherChannelBinding {
}
