package com.example.demo;

import com.example.demo.service.impl.ThrowService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author JiangT
 * @company sunyard
 * @projectName pmc
 * @date 2019/6/19 10:15
 * @description: 测试类
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ThrowServiceTest {

    @Autowired
    private ThrowService throwService;
    @Test
    public void test01() {
        throwService.dd(11);
    }

    @Test
    public void test02() {
        throwService.mm();
    }

    @Test
    public void test03() {
    }

    @Test
    public void test04() {
    }

    @Test
    public void test05() {
    }
}
