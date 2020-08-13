package com.suraj.config.server.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.suraj.config.server.document.PropertySource;
import com.suraj.config.server.repository.PropertyRepository;

@RestController
@RequestMapping("/config")
public class PropertyController {

	@Autowired
	private PropertyRepository propertyRepository;
	
	@Autowired
	private MongoTemplate mongoTemplate;

	@GetMapping(path = "/props/{profile}")
	public PropertySource get(@PathVariable() String profile) {
		return propertyRepository.findByProfile(profile);
	}

	@GetMapping(path = "/props/{profile}/{label}")
	public PropertySource get(@PathVariable() String profile,
			@PathVariable() String label) {
		return propertyRepository.findByProfileAndLabel(profile, label);
	}

	@PutMapping(path = "/props")
	public PropertySource update(@RequestBody PropertySource newProperties) {
		PropertySource existingProperties = propertyRepository.findByProfileAndLabel(newProperties.getProfile(), newProperties.getLabel());
		if(existingProperties != null) {
			existingProperties.setSource(newProperties.getSource());
			//existingProperties.setLastModified(new Timestamp(System.currentTimeMillis()));
			mongoTemplate.save(existingProperties, existingProperties.getApplicationName());
			propertyRepository.save(existingProperties);
			return existingProperties;
		}else {
			//newProperties.setLastModified(new Timestamp(System.currentTimeMillis()));
			mongoTemplate.save(newProperties, newProperties.getApplicationName());
			return newProperties;
		}
	}
	
	@PostMapping("/props")
	public PropertySource addNewApplication(@RequestBody PropertySource applicationProperty) {
		mongoTemplate.save(applicationProperty, applicationProperty.getApplicationName());
		return applicationProperty;
	}

}
