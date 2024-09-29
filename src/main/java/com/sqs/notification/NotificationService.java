package com.sqs.notification;

import com.amazonaws.services.sqs.model.SendMessageRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.aws.messaging.core.QueueMessagingTemplate;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

@Service
public class NotificationService {

    @Autowired
    private QueueMessagingTemplate amazonSQSAsyncClient;

    @Autowired
    private NotificationListener notificationListener;

    @Value("${cloud.aws.sqs.queue-name}")
    private String queueName;

    public void sendPaymentStatusToTheQueue(String message) {
        try {
            SendMessageRequest messageRequest = new SendMessageRequest();
            messageRequest.setMessageBody(message);
            amazonSQSAsyncClient.convertAndSend(queueName, MessageBuilder.withPayload(message).build());
            System.out.println(message);
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
}
