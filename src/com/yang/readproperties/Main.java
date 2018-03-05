package com.yang.readproperties;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        PropertiesUtil p=new PropertiesUtil("d:\\p.properties");
        System.out.println(p.getProperty("notifyMessage"));
        p.setProperty("notifyMessage","请快速检修");
        System.out.println(p.getProperty("notifyMessage"));
        System.out.println(p.getProperty("asda"));
    }
}
