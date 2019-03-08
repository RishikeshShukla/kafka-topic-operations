package com.kafka.operations;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages= {"com.kafka.operations"})
public class KafkaOperationsApplication {
	public static void main(String[] args) {
		SpringApplication.run(KafkaOperationsApplication.class, args);
	}

}
