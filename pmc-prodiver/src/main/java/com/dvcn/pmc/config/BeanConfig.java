package com.dvcn.pmc.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @author JiangT
 * @company sunyard
 * @projectName pmc
 * @date 2019/5/22 14:51
 * @description: TODO
 */
//@Configuration // 等价于spring application配置文件
public class BeanConfig {

    /**
      * 功能描述:  @Bean注解 等价于 spring application配置文件中
      * <bean id="restTemplate(方法名)" class="org.springframework.web.client.RestTemplate(类名)"></bean>
      *
      * @param
      * @return
      * @auther: JiangT
      * @date: 2019/5/22 14:53
      */
    //@Bean
    public RestTemplate restTemplate () {
        return new RestTemplate();
    }
}
