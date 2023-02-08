package com.ae_chat.aechatapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@SpringBootApplication
@EnableJpaRepositories("com.ae_chat.aechatapi.repositories")
public class AeChatApiApplication {
	public static void main(String[] args) {
		SpringApplication.run(AeChatApiApplication.class, args);
	}
} 
