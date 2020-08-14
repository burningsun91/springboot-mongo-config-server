package com.suraj.config.client;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class SpringCloudConfigClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringCloudConfigClientApplication.class, args);
	}

}

@RefreshScope
@RestController
class UserRestController {

	@Value("${test1.property}")
	private String propertyValue;
	
	@Value("${spring.test.property.uri}")
	private String springProperty;
	
	@Value("${spring.active.test-app}")
	private String springPropertyNew;

	@RequestMapping("/getDetails")
	String getDetails() {
		return "Test Property : "+propertyValue+" ## Spring Property : "+springProperty+" ## Spring Property 2 :"+springPropertyNew;
	}
}