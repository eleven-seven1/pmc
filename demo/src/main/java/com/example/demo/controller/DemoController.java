package com.example.demo.controller;

import com.example.demo.bean.Demo;
import com.example.demo.service.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author JiangT
 * @company sunyard
 * @projectName pmc
 * @date 2019/5/23 9:44
 * @description: TODO
 */
@Controller
public class DemoController {

    @Autowired
    private DemoService demoService;


    @Value("${name}")
    private String name;

    @RequestMapping("demo")
    @ResponseBody
    public String demo() {


        List<Demo> demos = demoService.queryByList();
        for (Demo demo : demos) {
            System.out.println(demo.getAddress());
        }

        return demos.toString();
    }

    @RequestMapping("add")
    @ResponseBody
    @Transactional
    public String add() {

        for (int i = 0 ; i <= 5000; i++){
            Demo demo = new Demo();
            demo.setId(i);
            demo.setName(String.valueOf(i));
            demo.setAddress(String.valueOf(i));
            demoService.addDemo(demo);
        }

        return "疯狂执行插入操作!!";
    }
}
