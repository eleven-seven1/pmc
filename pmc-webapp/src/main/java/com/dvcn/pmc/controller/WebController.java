package com.dvcn.pmc.controller;

import com.dvcn.pmc.service.WebService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author JiangT
 * @company sunyard
 * @projectName pmc
 * @date 2019/5/22 14:34
 * @description: 测试消费者控制层
 */
@RestController
@Slf4j
public class WebController {


    @Autowired
    private WebService webService;

    @RequestMapping("/web/hello")
    public String Helle() {
        log.info("测试日志");
        return webService.Hello();

    }

    public ModelAndView index() {

        ModelAndView mv = new ModelAndView();

        mv.addObject("title","测试页面");
        mv.setViewName("index.html");
        return mv;
    }
}
