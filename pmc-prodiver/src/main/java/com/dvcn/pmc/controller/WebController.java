package com.dvcn.pmc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author JiangT
 * @company sunyard
 * @projectName pmc
 * @date 2019/5/22 14:34
 * @description: TODO
 */
@RestController
public class WebController {

    @Autowired
    private RestTemplate restTemplate;


    @RequestMapping("/provider/hello")
    public String Helle() {

        return "Hello Spring Cloud";

    }
}
