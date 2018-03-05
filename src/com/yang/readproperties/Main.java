package com.yang.readproperties;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        PropertiesUtil p=new PropertiesUtil("d:\\p.properties");
        System.out.println(p.getProperty("yang"));
    }
}
