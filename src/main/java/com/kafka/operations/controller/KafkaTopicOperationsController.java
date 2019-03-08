package com.kafka.operations.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.kafka.operations.model.CreateTopicRequest;
import com.kafka.operations.model.DeleteTopicRequest;
import com.kafka.operations.model.TopicDescriptionResponse;
import com.kafka.operations.service.KafkaOperationsService;

@RestController
@RequestMapping("/kafka/topic")
public class KafkaTopicOperationsController {
	private static final Logger LOGGER = LoggerFactory.getLogger(KafkaTopicOperationsController.class);

	@Autowired
	KafkaOperationsService kafkaOperationsService;
	
	@RequestMapping(value = "/isExist", method = RequestMethod.GET)
	public Boolean isTopicExist(@RequestParam("topicName") String topicName) {
		return kafkaOperationsService.isTopicExist(topicName);
	}

	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public Boolean createTopic(@RequestBody CreateTopicRequest createTopicRequest) {
		return kafkaOperationsService.createTopic(createTopicRequest);
	}

	@RequestMapping(value = "/describe-topic", method = RequestMethod.GET)
	public TopicDescriptionResponse describeTopic(@RequestParam("topicName") String topicName) {
		LOGGER.info("Calling describe Topic for: " + topicName);
		return kafkaOperationsService.describeTopic(topicName);
	}

	@RequestMapping(value = "/delete", method = RequestMethod.DELETE)
	public Boolean deleteTopic(@RequestBody DeleteTopicRequest deleteTopicRequest) {
		return kafkaOperationsService.deleteTopic(deleteTopicRequest);
	}
}
