package com.sqs.notification;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;

@RestController
public class NotificationController {

    @Autowired
    private NotificationService notificationService;

    @Autowired
    private OrderService orderService;

    @GetMapping("/payment-status/{message}")
    public ResponseEntity<String> sendNotification(@PathVariable String message) {
        try {
            notificationService.sendPaymentStatusToTheQueue(message);
            return new ResponseEntity<>("Payment Processed", HttpStatus.OK);  // Use HttpStatus.OK
        } catch (Exception e) {
            return new ResponseEntity<>("Payment error", HttpStatus.INTERNAL_SERVER_ERROR);  // Use HttpStatus.INTERNAL_SERVER_ERROR
        }
    }
}
