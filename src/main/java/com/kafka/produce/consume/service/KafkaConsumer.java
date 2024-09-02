package com.kafka.produce.consume.service;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumer {
	
	@KafkaListener(topics = "my-first-topic", groupId = "my-first-group")
	public void consumeMessages(String message) {
		System.out.println("In consumeMessages");
		System.out.println("Message consumed => "+message);
	}
}
