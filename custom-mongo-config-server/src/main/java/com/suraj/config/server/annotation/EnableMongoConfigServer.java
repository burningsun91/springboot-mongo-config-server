package com.suraj.config.server.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import com.suraj.config.server.configuration.MongoEnvironmentRepositoryConfiguration;


@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Configuration
@Import(MongoEnvironmentRepositoryConfiguration.class)
@EnableConfigServer
public @interface EnableMongoConfigServer {

}
