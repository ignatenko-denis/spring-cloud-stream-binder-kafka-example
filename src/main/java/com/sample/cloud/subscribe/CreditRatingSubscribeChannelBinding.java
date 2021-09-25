package com.sample.cloud.subscribe;

import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableBinding(CreditRatingSubscribeChannel.class)
public class CreditRatingSubscribeChannelBinding {
}
