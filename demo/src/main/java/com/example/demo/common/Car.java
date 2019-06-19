package com.example.demo.common;



/**
 * @author JiangT
 * @company sunyard
 * @projectName pmc
 * @date 2019/6/13 15:46
 * @description: 单例设计模式
 */
public class Car {

    private static  Car car ;

    public static synchronized Car getIns(){

        if (null == car){
            car = new Car();
        }

        return car;
    }

    private Car(){}


}
