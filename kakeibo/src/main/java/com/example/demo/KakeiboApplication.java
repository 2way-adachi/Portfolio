package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class KakeiboApplication {

	public static void main(String[] args) throws InterruptedException {
//		SpringApplication.run(IndexController.class, args);
		ConfigurableApplicationContext context = SpringApplication.run(KakeiboApplication.class, args);
//		IndexController indexC =  context.getBean(IndexController.class);
//		StartUpBrowser startUpBrowser = context.getBean(StartUpBrowser.class);
		
	}
}
