package com.dvcn.pmc.controller;

import com.dvcn.pmc.service.ITestService;
import com.dvcn.pmc.test.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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
    private ITestService testService;


    @RequestMapping("/provider/hello")
    public String Hello() {

        List<Test> tests = testService.queryByList();

        return "Hello " + tests.get(0).getName();

    }
}
