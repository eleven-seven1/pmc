package com.dvcn.pmc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer //开启Eureka注册中心服务端
public class PmcEurekaBakApplication {

	public static void main(String[] args) {

	    SpringApplication.run(PmcEurekaBakApplication.class, args);
	}

}
