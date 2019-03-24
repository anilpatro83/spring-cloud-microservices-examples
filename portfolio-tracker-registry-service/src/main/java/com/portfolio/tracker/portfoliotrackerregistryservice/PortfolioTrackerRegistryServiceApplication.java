package com.portfolio.tracker.portfoliotrackerregistryservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@EnableZuulProxy
@SpringBootApplication
@EnableEurekaServer
public class PortfolioTrackerRegistryServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(PortfolioTrackerRegistryServiceApplication.class, args);
	}

}
