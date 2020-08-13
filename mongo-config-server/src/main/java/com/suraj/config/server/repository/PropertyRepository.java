package com.suraj.config.server.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.suraj.config.server.document.PropertySource;

@Repository
public interface PropertyRepository extends MongoRepository<PropertySource, String>{

	public PropertySource findByProfile(String profile);
	
	public PropertySource findByProfileAndLabel(String profile, String label);
}
