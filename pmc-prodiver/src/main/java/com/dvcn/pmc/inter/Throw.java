package com.dvcn.pmc.inter;

import java.lang.annotation.*;

/**
 * @author JiangT
 * @company sunyard
 * @projectName pmc
 * @date 2019/6/19 9:48
 * @description: 异常处理注解
 */
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Throw {
}
