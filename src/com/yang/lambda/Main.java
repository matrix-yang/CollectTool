package com.yang.lambda;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        System.out.println("Hello World!");

        //筛选满足条件的对象
        List<Case> lstCase=new ArrayList<>();


        lstCase.add(new Case());
        List<Case> tempLst = lstCase.stream().filter(t -> 1==t.a).collect(Collectors.toList());
        //筛选出对象的某一属性
        List<Integer> ids=lstCase.stream().map(Case::getA).collect(Collectors.toList());
    }
}
