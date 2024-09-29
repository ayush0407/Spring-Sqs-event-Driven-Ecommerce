package com.sqs.notification;

import org.springframework.stereotype.Service;

@Service
public class OrderService {
    public void confirmOrder() {
        System.out.println("The order is confirmed-------------");
    }

    public void declineOrder() {
        System.out.println("The order is declined because the payment didn't go through.");
    }
}
