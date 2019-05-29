package com.example.demo.service.impl;

import com.example.demo.bean.Demo;
import com.example.demo.dao.DemoDao;
import com.example.demo.service.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author JiangT
 * @company sunyard
 * @projectName pmc
 * @date 2019/5/23 9:31
 * @description: TODO
 */
@Service
public class DemoServiceImpl implements DemoService{

    @Autowired
    private DemoDao demoDao;

    @Override
    public List<Demo> queryByList() {
        return demoDao.queryByList();
    }

    @Override
    public int addDemo(Demo demo) {
        return demoDao.addDemo(demo);
    }
}
