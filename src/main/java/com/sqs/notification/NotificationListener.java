package com.sqs.notification;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.aws.messaging.listener.annotation.SqsListener;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class NotificationListener {

    @Autowired
    private OrderService orderService;

    @SqsListener("spring-sqs")
    public void processPaymentNotification(String message){
            if( message.contains("complete")){
            orderService.confirmOrder();
        }
        else{
            orderService.declineOrder();
        }
    }
}
