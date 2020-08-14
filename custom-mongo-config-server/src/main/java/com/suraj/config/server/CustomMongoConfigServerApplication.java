package com.suraj.config.server;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.convert.DbRefResolver;
import org.springframework.data.mongodb.core.convert.DefaultDbRefResolver;
import org.springframework.data.mongodb.core.convert.MappingMongoConverter;
import org.springframework.data.mongodb.core.mapping.MongoMappingContext;

import com.suraj.config.server.annotation.EnableMongoConfigServer;

@SpringBootApplication
@EnableMongoConfigServer
public class CustomMongoConfigServerApplication {
	
	@Autowired
	private MongoMappingContext mongoMappingContext;

	public static void main(String[] args) {
		SpringApplication.run(CustomMongoConfigServerApplication.class, args);
	}
	
	@Bean
	  public MappingMongoConverter mongoConverter(MongoDbFactory mongoFactory) throws Exception {
	    DbRefResolver dbRefResolver = new DefaultDbRefResolver(mongoFactory);
	    MappingMongoConverter mongoConverter = new MappingMongoConverter(dbRefResolver, mongoMappingContext);
	    mongoConverter.setMapKeyDotReplacement("-");

	    return mongoConverter;
	  }

}
