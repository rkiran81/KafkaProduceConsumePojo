package com.kafka.produce.consume.service;

import java.util.concurrent.CompletableFuture;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

@Service
public class KafkaPublisher {
	
	@Autowired
	KafkaTemplate<String, Object> template;
	
	
	public void sendMessage(String message) {
		System.out.println("In sendMessage");
		CompletableFuture<SendResult<String, Object>> future = template.send("my-first-topic", message);
		future.whenComplete((result, ex) -> {
			if(null == ex) {
				System.out.println("Message - " + message + " sent to partition - " + result.getRecordMetadata().partition()
						+ " and offset - " + result.getRecordMetadata().offset());
			}else {
				System.out.println("Exception publishing " + ex.getMessage());
			}
		});
		
	}
}
