package com.example.demo.bean;

import lombok.Data;

/**
 * @author JiangT
 * @company sunyard
 * @projectName pmc
 * @date 2019/5/23 9:25
 * @description: TODO
 */
@Data
//lombok的注解 @Data 注解在类上 提供类所有属性的 getting 和 setting 方法，此外还提供了equals、canEqual、hashCode、toString 方法
public class Demo {

    private int id ;

    private String name ;

    private String address ;

}
