package com.chary.spring.jpa.h2.kafka.service;

//import org.apache.kafka.clients.producer.ProducerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
//import org.springframework.kafka.support.KafkaHeaders;
//import org.springframework.messaging.Message;
//import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

import com.chary.spring.jpa.h2.kafka.model.Tutorial;




@Service
public class Producer {
	
	private static final Logger LOGGER =LoggerFactory.getLogger(Producer.class);
	
	private KafkaTemplate<String, Tutorial> kafkaTemplate;
	
	public Producer(KafkaTemplate<String, Tutorial> kafkaTemplate) {
		this.kafkaTemplate=kafkaTemplate;
	}
	
	public void sendMessage(Tutorial data) {
		
		LOGGER.info(String.format("message sent %s", data.toString()));
		 /* 
		 * Message<Tutorial> message = MessageBuilder .withPayload(data)
		 * .setHeader(KafkaHeaders.TOPIC, "javaguides") .build();
		 */
			
			  Message<Tutorial> message = MessageBuilder 
					  .withPayload(data)
					  .setHeader(KafkaHeaders.TOPIC, "javaguides") 
					  .build();
			
		
		kafkaTemplate.send(message);
	}
}
