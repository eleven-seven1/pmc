package com.dvcn.pmc;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
@MapperScan("com.dvcn.pmc.test.mapper")
public class PmcWebappApplication {

	public static void main(String[] args) {
		SpringApplication.run(PmcWebappApplication.class, args);
	}

}
