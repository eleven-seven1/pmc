package com.dvcn.pmc.test.mapper;

import com.dvcn.pmc.bean.Test;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author JiangT
 * @company sunyard
 * @projectName pmc
 * @date 2019/5/28 14:54
 * @description: TODO
 */
@Mapper
@Component("testDao")
public interface TestDao {

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
