package com.dvcn.pmc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient //开启Eureka客户端功能
public class PmcProviderApplication {

	public static void main(String[] args) {
		SpringApplication.run(PmcProviderApplication.class, args);
	}

}
