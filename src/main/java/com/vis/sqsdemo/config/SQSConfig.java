package com.vis.sqsdemo.config;

import com.amazonaws.services.sqs.AmazonSQSAsync;
import com.amazonaws.services.sqs.AmazonSQSAsyncClient;
import com.amazonaws.services.sqs.AmazonSQSAsyncClientBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.aws.messaging.config.SimpleMessageListenerContainerFactory;
import org.springframework.cloud.aws.messaging.core.QueueMessagingTemplate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class SQSConfig {

    @Value("${aws.region}")
    private String region;


@Primary
@Bean
    public AmazonSQSAsync getAmazonSQSAsync(){
        return AmazonSQSAsyncClientBuilder.standard().withRegion(region).build();
    }


    @Bean
    public QueueMessagingTemplate queueMessagingTemplate(){
    return new QueueMessagingTemplate(getAmazonSQSAsync());
    }

    @Bean
    public SimpleMessageListenerContainerFactory simpleMessageListenerContainerFactory(){
        SimpleMessageListenerContainerFactory factor = new SimpleMessageListenerContainerFactory();
        factor.setAmazonSqs(getAmazonSQSAsync());
        factor.setAutoStartup(true);
        return factor;
    }

}
