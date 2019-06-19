package com.example.demo.service.impl;

import com.example.demo.common.Throw;
import org.springframework.stereotype.Service;

/**
 * @author JiangT
 * @company sunyard
 * @projectName pmc
 * @date 2019/6/19 10:12
 * @description: 切面测试接口
 */
@Service
public class ThrowService {

    @Throw
    public String mm () {
        System.out.println("mmmmmmmmmmmmmmm");
        return "mm接口中方法 Hello World !!";
    }

    @Throw
    public String dd (int xx) {
        System.out.println("gg 接口中输出 : " + xx);
        return "dd接口中方法 Hello World !!" + xx;
    }

    @Throw
    public void gg (int xx) {
        System.out.println("gg 接口中输出 : " + xx);
    }
}
