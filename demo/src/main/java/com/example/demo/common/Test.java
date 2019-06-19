package com.example.demo.common;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.Stream;

/**
 * @author JiangT
 * @company sunyard
 * @projectName pmc
 * @date 2019/6/13 15:48
 * @description: TODO
 */
public class Test {


    public static void main(String[] args) {

        List<String> list = new ArrayList<>();

        list.add("123");
        list.add("465");
        list.add("789");
        list.add("147");
        list.add("258");
        list.add("369");

//        list.forEach(x -> {
//            Integer integer = Integer.valueOf(x);
//            System.out.println( integer + 1);
//        });

        Stream<String> stream = list.stream();

        stream.forEach(System.out::print);
    }



}
