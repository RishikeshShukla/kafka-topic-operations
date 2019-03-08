package com.kafka.operations.service;

import com.kafka.operations.model.CreateTopicRequest;
import com.kafka.operations.model.DeleteTopicRequest;
import com.kafka.operations.model.TopicDescriptionResponse;

public interface KafkaOperationsService {

    Boolean createTopic(CreateTopicRequest createTopicRequest);

    Boolean deleteTopic(DeleteTopicRequest deleteTopicRequest);

    Boolean isTopicExist(String topicName);

    TopicDescriptionResponse describeTopic(String topicName);

}
