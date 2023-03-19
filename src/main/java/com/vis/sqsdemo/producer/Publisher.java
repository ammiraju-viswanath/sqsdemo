package com.vis.sqsdemo.producer;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.aws.messaging.core.QueueMessagingTemplate;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class Publisher {

    @Value("${aws.sqs-name}")
    private String sqsQueueName;
    @Autowired
    private QueueMessagingTemplate queueMessagingTemplate;
    public void sendMessage(CustomMessage message){
      log.info("Sending messaging...");
        queueMessagingTemplate.convertAndSend(sqsQueueName, message);
    }
}
