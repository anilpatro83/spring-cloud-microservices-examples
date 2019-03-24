package com.portfolio.tracker;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableDiscoveryClient
@EnableJpaRepositories(basePackages="com.portfolio.tracker.dto.repo")
public class PortfolioTrackerDbServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(PortfolioTrackerDbServiceApplication.class, args);
	}

}
