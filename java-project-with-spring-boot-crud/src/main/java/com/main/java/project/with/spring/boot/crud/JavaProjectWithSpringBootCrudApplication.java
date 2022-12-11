package com.main.java.project.with.spring.boot.crud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableEurekaClient
public class JavaProjectWithSpringBootCrudApplication {

	public static void main(String[] args) {
		SpringApplication.run(JavaProjectWithSpringBootCrudApplication.class, args);
	}
	
	
  @Bean
  RestTemplate resttemplate () {
	  return new RestTemplate();
  }

}
