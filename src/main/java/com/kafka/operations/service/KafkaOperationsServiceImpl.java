package com.kafka.operations.service;

import com.kafka.operations.exception.CreateTopicException;
import com.kafka.operations.exception.DeleteTopicException;
import com.kafka.operations.exception.DescribeTopicException;
import com.kafka.operations.exception.KafkaOperationsBaseException;
import com.kafka.operations.model.CreateTopicRequest;
import com.kafka.operations.model.DeleteTopicRequest;
import com.kafka.operations.model.PartitionInfo;
import com.kafka.operations.model.TopicDescriptionResponse;
import com.kafka.operations.util.ErrorCodes;
import com.kafka.operations.util.KafkaAdminClientUtil;
import org.apache.kafka.clients.admin.*;
import org.apache.kafka.common.TopicPartitionInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ExecutionException;
import java.util.stream.Collectors;

@Service
public class KafkaOperationsServiceImpl implements KafkaOperationsService {

	private static final Logger LOGGER = LoggerFactory.getLogger(KafkaOperationsServiceImpl.class);

	@Autowired
	private KafkaAdminClientUtil kafkaClientUtil;

	/**
	 * @param createTopicRequest
	 * @return
	 * @throws KafkaOperationsBaseException
	 */

	@Override
	public Boolean createTopic(CreateTopicRequest createTopicRequest) throws KafkaOperationsBaseException {
		LOGGER.info("Create Topic request : " + createTopicRequest);
		String topicName = createTopicRequest.getTopicName();
		System.out.println("Generated Topic name is : " + topicName);

		int noOfPartitions = createTopicRequest.getNoOfPartitions();
		short noOfReplications = createTopicRequest.getNoOfReplications();

		AdminClient adminClient = kafkaClientUtil.getAdminClient();

		final NewTopic newTopic = new NewTopic(topicName, noOfPartitions, noOfReplications);
		CreateTopicsResult createTopicsResult = adminClient.createTopics(Collections.singleton(newTopic));

		try {
			createTopicsResult.values().get(createTopicRequest.getTopicName()).get();
			if (createTopicsResult.values().get(createTopicRequest.getTopicName()) != null) {
				LOGGER.info("Create Topic request Completed Successfully.");
				return Boolean.TRUE;
			}
		} catch (InterruptedException | ExecutionException e) {
			LOGGER.error(e.getMessage(), e);
			throw new CreateTopicException(e.getMessage(), ErrorCodes.CREATE_TOPIC_ERROR.toString() + ErrorCodes.CREATE_TOPIC_ERROR.getCode());
		}
		LOGGER.error("Create Topic request failed !!!");
		return Boolean.FALSE;
	}

	/**
	 * @param deleteTopicRequest
	 * @return
	 * @throws KafkaOperationsBaseException
	 */
	@Override
	public Boolean deleteTopic(DeleteTopicRequest deleteTopicRequest) throws KafkaOperationsBaseException {
		LOGGER.info("Delete Topic request : " + deleteTopicRequest);
		AdminClient adminClient = kafkaClientUtil.getAdminClient();
		DeleteTopicsResult deleteTopicsResult = adminClient
				.deleteTopics(Collections.singleton(deleteTopicRequest.getTopicName()));

		try {
			deleteTopicsResult.values().get(deleteTopicRequest.getTopicName()).get();
			if (deleteTopicsResult.values().get(deleteTopicRequest.getTopicName()) != null) {
				LOGGER.info("Topic: " + deleteTopicRequest.getTopicName() + " deleted Successfully.");
				return Boolean.TRUE;
			}
		} catch (InterruptedException | ExecutionException e) {
			LOGGER.error(e.getMessage(), e);
			throw new DeleteTopicException(e.getMessage(), ErrorCodes.DELETE_TOPIC_ERROR.getCode());
		}
		LOGGER.error("Delete Topic request failed !!!");
		return Boolean.FALSE;
	}

	/**
	 * @param topicName
	 * @return
	 * @throws KafkaOperationsBaseException
	 */

	@Override
	public Boolean isTopicExist(String topicName) throws KafkaOperationsBaseException {
		LOGGER.info("Check Topic existence request : " + topicName);
		AdminClient adminClient = kafkaClientUtil.getAdminClient();
		ListTopicsResult topicsResult = adminClient.listTopics();
		try {
			Set<String> topicNames = topicsResult.names().get();
			if (topicNames.stream().anyMatch(topic -> topicName.equals(topic)))
				return Boolean.TRUE;
		} catch (InterruptedException | ExecutionException e) {
			LOGGER.error(e.getMessage(), e);
			throw new KafkaOperationsBaseException(e.getMessage(), ErrorCodes.IS_TOPIC_EXIST_ERROR.getCode(),
					HttpStatus.EXPECTATION_FAILED);
		}
		return Boolean.FALSE;
	}

	/**
	 * @param topicName
	 * @return
	 * @throws KafkaOperationsBaseException
	 */
	@Override
	public TopicDescriptionResponse describeTopic(String topicName) throws KafkaOperationsBaseException {
		LOGGER.info("Describing topic info : " + topicName);

		AdminClient adminClient = kafkaClientUtil.getAdminClient();
		TopicDescriptionResponse response = null;
		DescribeTopicsResult describeTopicsResult = adminClient.describeTopics(Collections.singleton(topicName));

		try {
			TopicDescription topicDescription = describeTopicsResult.values().get(topicName).get();
			if (topicDescription != null) {
				response = new TopicDescriptionResponse();
				response.setTopicName(topicDescription.name());
				response.setInternal(topicDescription.isInternal());
				response.setPartitionInfo(populatePartitionInfo(topicDescription.partitions()));
				response.setPartitionCount(topicDescription.partitions().size());
				response.setReplicationFactor(topicDescription.partitions().get(0).replicas().size());
			}
		} catch (InterruptedException | ExecutionException e) {
			LOGGER.error(e.getMessage(), e);
			throw new DescribeTopicException(e.getMessage(), ErrorCodes.DESCRIBE_TOPIC_ERROR.getCode());
		}

		if (response == null)
			throw new DescribeTopicException("Describe topic response for topic: " + topicName + " is null!!",
					ErrorCodes.DESCRIBE_TOPIC_ERROR.getCode());

		LOGGER.info("Describing topic info : " + topicName + " \n " + response.toString());
		return response;
	}

	private List<PartitionInfo> populatePartitionInfo(List<TopicPartitionInfo> partitions) {
		return partitions.stream().map(partition -> new PartitionInfo(partition.partition(), partition.leader(),
				partition.replicas(), partition.isr())).collect(Collectors.toList());
	}

}