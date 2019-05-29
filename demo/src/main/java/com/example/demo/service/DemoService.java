package com.example.demo.service;

import com.example.demo.bean.Demo;

import java.util.List;

/**
 * @author JiangT
 * @company sunyard
 * @projectName pmc
 * @date 2019/5/23 9:31
 * @description: TODO
 */
public interface DemoService {

    /**
     * 功能描述:
     *      查全部
     * @param
     * @return
     * @auther: JiangT
     * @date: 2019/5/23 9:27
     */
    List<Demo> queryByList();

    /**
      * 功能描述:
      *      添加数据
      * @param
      * @return
      * @auther: JiangT
      * @date: 2019/5/24 9:18
      */
    int addDemo(Demo demo);
}
