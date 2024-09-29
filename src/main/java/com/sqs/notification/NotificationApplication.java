package com.sqs.notification;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class NotificationApplication implements CommandLineRunner {

	@Autowired
	private NotificationController controller;

	public static void main(String[] args) {
		SpringApplication.run(NotificationApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println(controller.sendNotification("Payment complete"));
		System.out.println(controller.sendNotification("Payment error"));
	}
}
