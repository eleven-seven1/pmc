package com.example.demo.dao;

import com.example.demo.bean.Demo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author JiangT
 * @company sunyard
 * @projectName pmc
 * @date 2019/5/23 9:25
 * @description: TODO
 */
@Mapper()
@Component("demoDao")
public interface DemoDao {

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
      * @date: 2019/5/24 9:15
      */
    int addDemo(Demo demo);
}
