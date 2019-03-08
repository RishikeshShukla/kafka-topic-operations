package com.kafka.operations.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.fasterxml.jackson.databind.ObjectMapper;

@Configuration
public class KafkaOperationsConfiguration {

	@Bean
	public ObjectMapper objectMapper() {
		return new ObjectMapper();

	}
}
