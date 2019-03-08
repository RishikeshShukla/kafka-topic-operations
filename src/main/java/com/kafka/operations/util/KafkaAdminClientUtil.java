package com.kafka.operations.util;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.apache.kafka.clients.admin.AdminClient;
import org.apache.kafka.clients.admin.AdminClientConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.kafka.operations.exception.AdminClientException;

@Scope("singleton")
@Component
public class KafkaAdminClientUtil {

	private static final Logger LOGGER = LoggerFactory.getLogger(KafkaAdminClientUtil.class);

	@Value("${kafka.server.host}")
	private String kafkaServerHost;

	private final int SESSION_TIME_OUT_IN_MS = 15 * 1000;

	private AdminClient adminClient = null;

	@PostConstruct
	public void init() {
		adminClient = initializingAdminClient();
	}

	private AdminClient initializingAdminClient() {
		LOGGER.info("Initializing kakfa Admin Client ..");
		final Map<String, Object> config = new HashMap<>();
		config.put(AdminClientConfig.BOOTSTRAP_SERVERS_CONFIG, kafkaServerHost);
		config.put(AdminClientConfig.REQUEST_TIMEOUT_MS_CONFIG, SESSION_TIME_OUT_IN_MS);
	
		try {
			adminClient = AdminClient.create(config);
		} catch (Exception e) {
			LOGGER.error("Problem in initializing kafka Admin client !!!");
			LOGGER.error(e.getMessage(), e);
			throw new AdminClientException(e.getMessage(), ErrorCodes.ADMIN_CLIENT_ERROR.getCode());
		}
		LOGGER.info("Kakfa Admin Client initialized successfully.");
		return adminClient;
	}

	/**
	 * 
	 * @return @AdminClient
	 */

	public AdminClient getAdminClient() {
		return adminClient;
	}

}
