package com.spider.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.spider"})
public class DomainSpiderApplication {

	public static void main(String[] args) {
		SpringApplication.run(DomainSpiderApplication.class, args);
	}

}
