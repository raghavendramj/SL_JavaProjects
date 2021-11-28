package com.simplilearn.SpringApacheKafka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.KafkaListener;

@SpringBootApplication
public class SpringApacheKafkaApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringApacheKafkaApplication.class, args);
	}

	@KafkaListener(topics = "ecommerce", groupId = "group-id")
	public void listen(String message) {
		System.out.println("Received Message in group - group-id: " + message);
	}

}
