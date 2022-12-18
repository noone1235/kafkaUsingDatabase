package com.chary.spring.jpa.h2.kafka.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class TopicConfig {
	 @Bean 
	 NewTopic javaguidesTopic() { 
		  return TopicBuilder.name("javaguides")
				  .build(); 
} }