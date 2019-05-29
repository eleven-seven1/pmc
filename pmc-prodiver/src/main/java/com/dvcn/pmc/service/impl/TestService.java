package com.dvcn.pmc.service.impl;

import com.dvcn.pmc.bean.Test;
import com.dvcn.pmc.service.ITestService;
import com.dvcn.pmc.test.mapper.TestDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author JiangT
 * @company sunyard
 * @projectName pmc
 * @date 2019/5/28 14:50
 * @description: TODO
 */
@Service
public class TestService implements ITestService {


    @Autowired
    private TestDao testDao;

    /**
     * 功能描述:
     *      查全部
     * @param
     * @return
     * @auther: JiangT
     * @date: 2019/5/23 9:27
     */
    public List<Test> queryByList(){
        return testDao.queryByList();
    }

    /**
     * 功能描述:
     *      添加数据
     * @param
     * @return
     * @auther: JiangT
     * @date: 2019/5/24 9:15
     */
    public int addDemo(Test test){
        return testDao.addDemo(test);
    }

}
