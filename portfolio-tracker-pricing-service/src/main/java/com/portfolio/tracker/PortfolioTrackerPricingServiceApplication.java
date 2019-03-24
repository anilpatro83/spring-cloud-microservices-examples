package com.portfolio.tracker;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class PortfolioTrackerPricingServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(PortfolioTrackerPricingServiceApplication.class, args);
	}

}
