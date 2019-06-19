package com.dvcn.pmc;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableEurekaClient //开启Eureka客户端功能
@MapperScan("com.dvcn.pmc.test.mapper")
public class PmcProviderApplication {

	public static void main(String[] args) {
		SpringApplication.run(PmcProviderApplication.class, args);
	}

}
