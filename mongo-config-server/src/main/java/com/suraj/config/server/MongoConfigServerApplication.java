package com.suraj.config.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.mongodb.EnableMongoConfigServer;

@SpringBootApplication
@EnableMongoConfigServer
public class MongoConfigServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(MongoConfigServerApplication.class, args);
	}

}
