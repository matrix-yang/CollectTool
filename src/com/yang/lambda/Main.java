package com.yang.lambda;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        System.out.println("Hello World!");
        //筛选满足条件的对象
        List<Case> lstCase=new ArrayList<>();
        List<Case> tempLst = lstCase.stream().filter(t -> 1==t.a).collect(Collectors.toList());
    }
}
