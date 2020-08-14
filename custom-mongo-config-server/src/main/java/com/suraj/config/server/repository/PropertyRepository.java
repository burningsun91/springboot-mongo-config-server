package com.suraj.config.server.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.suraj.config.server.document.ApplicationProperty;

@Repository
public interface PropertyRepository extends MongoRepository<ApplicationProperty, String>{

	public ApplicationProperty findByApplicationName(String applicationName);
	
	public ApplicationProperty findByApplicationNameAndProfile(String applicationName, String profile);
	
	public ApplicationProperty findByApplicationNameAndProfileAndLabel(String applicationName, String profile, String label);
}
