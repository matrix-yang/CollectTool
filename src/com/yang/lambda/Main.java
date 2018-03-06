package com.yang.lambda;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {

        List<Case> lstCase=new ArrayList<>();
        lstCase.add(new Case(11,12,13,"A"));
        lstCase.add(new Case(21,22,23,"B"));
        //筛选满足条件的对象
        List<Case> tempLst = lstCase.stream().filter(t -> 11==t.a).collect(Collectors.toList());
        //筛选出对象的某一属性
        List<Integer> ids=lstCase.stream().map(Case::getA).collect(Collectors.toList());


        //三行循环效果相同
        //list.forEach(user -> System.out.println(user.toString()));
        //list.forEach(user -> System.out.println(user));//下面一行代码就是简写形式
        tempLst.forEach(t -> System.out.println(t.toString()));
        ids.forEach(t -> System.out.println(t.toString()));
        lstCase.forEach(System.out::println);
    }
}
