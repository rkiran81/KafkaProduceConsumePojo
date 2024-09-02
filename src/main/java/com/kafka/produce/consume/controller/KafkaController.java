package com.kafka.produce.consume.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kafka.produce.consume.service.KafkaPublisher;

@RestController
public class KafkaController {
	
	@Autowired
	KafkaPublisher publisher;
	
	@GetMapping
	public ResponseEntity<String> test(){
		return ResponseEntity.status(HttpStatus.OK).body("KafkaProduceConsume is up...");
	}
	
	@PostMapping("/publish/{message}")
	public ResponseEntity<String> sendSimpleMessage(@PathVariable String message){
		System.out.println("In sendSimpleMessage");
		publisher.sendMessage(message);
		return ResponseEntity.status(HttpStatus.OK).body("Message sent successfully...");
	}
}
