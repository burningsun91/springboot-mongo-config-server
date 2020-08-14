package com.suraj.config.server.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.config.server.environment.EnvironmentRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoTemplate;

import com.suraj.config.server.repository.MongoEnvironmentRepository;

@Configuration
public class MongoEnvironmentRepositoryConfiguration {

	@Autowired
	private MongoTemplate mongoTemplate;
	
	@Bean
	public EnvironmentRepository environmentRepository() {
		return new MongoEnvironmentRepository(mongoTemplate);
	}
	
	

}
