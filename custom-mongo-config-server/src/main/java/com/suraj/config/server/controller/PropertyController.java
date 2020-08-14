package com.suraj.config.server.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.suraj.config.server.document.ApplicationProperty;
import com.suraj.config.server.repository.PropertyRepository;

@RestController
@RequestMapping("/config")
public class PropertyController {

	@Autowired
	private PropertyRepository propertyRepository;
	
	@Autowired
	private MongoTemplate mongoTemplate;

	@GetMapping(path = "/props/{applicationName}")
	public ApplicationProperty get(@PathVariable() String applicationName) {
		return propertyRepository.findByApplicationName(applicationName);
	}

	@GetMapping(path = "/props/{applicationName}/{profile}")
	public ApplicationProperty get(@PathVariable() String applicationName, @PathVariable() String profile) {
		return propertyRepository.findByApplicationNameAndProfile(applicationName, profile);
	}

	@GetMapping(path = "/props/{applicationName}/{profile}/{label}")
	public ApplicationProperty get(@PathVariable() String applicationName, @PathVariable() String profile,
			@PathVariable() String label) {
		return propertyRepository.findByApplicationNameAndProfileAndLabel(applicationName, profile, label);
	}

	@PutMapping(path = "/props")
	public ApplicationProperty update(@Valid @RequestBody ApplicationProperty newProperties) {
		ApplicationProperty existingProperties = propertyRepository.findByApplicationNameAndProfileAndLabel(newProperties.getApplicationName(), newProperties.getProfile(), newProperties.getLabel());
		if(existingProperties != null) {
			existingProperties.setSource(newProperties.getSource());
			//existingProperties.setLastModified(new Timestamp(System.currentTimeMillis()));
			mongoTemplate.save(existingProperties, existingProperties.getApplicationName());
			return existingProperties;
		}else {
			//newProperties.setLastModified(new Timestamp(System.currentTimeMillis()));
			mongoTemplate.save(newProperties, newProperties.getApplicationName());
			return newProperties;
		}
	}
	
	@PostMapping("/props")
	public ApplicationProperty addNewApplication(@Valid @RequestBody ApplicationProperty applicationProperty) {
		mongoTemplate.save(applicationProperty, applicationProperty.getApplicationName());
		return applicationProperty;
	}

}
