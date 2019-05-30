package com.dvcn.pmc.service;

import com.dvcn.pmc.test.Test;

import java.util.List;

/**
 * @author JiangT
 * @company sunyard
 * @projectName pmc
 * @date 2019/5/28 15:05
 * @description: TODO
 */
public interface ITestService {

    /**
     * 功能描述:
     *      查全部
     * @param
     * @return
     * @auther: JiangT
     * @date: 2019/5/23 9:27
     */
    List<Test> queryByList();
    /**
     * 功能描述:
     *      添加数据
     * @param
     * @return
     * @auther: JiangT
     * @date: 2019/5/24 9:15
     */
    int addDemo(Test test);
}
