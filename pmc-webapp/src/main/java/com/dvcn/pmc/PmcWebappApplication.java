package com.dvcn.pmc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class PmcWebappApplication {

	public static void main(String[] args) {
		SpringApplication.run(PmcWebappApplication.class, args);
	}

}
