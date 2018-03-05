package com.yang.readproperties;

import java.io.*;
import java.util.Properties;

public class PropertiesUtil {
    private String path = "";
    private Properties pro = null;

    public PropertiesUtil(String path) {
        this.path = path;
        this.init();
    }

    public void init() {
        pro = new Properties();
        FileInputStream in = null;
        try {
            in = new FileInputStream(path);
            pro.load(in);
        } catch (FileNotFoundException e) {
            System.out.println("该路径->" + path + "文件不存在");
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Properties getPro() {
        return pro;
    }

    private void store() {
        FileOutputStream oFile = null;
        try {
            oFile = new FileOutputStream(path, false);
            pro.store(oFile, "Comment");
            oFile.close();
        } catch (FileNotFoundException e) {
            System.out.println("该路径->" + path + "文件不存在");
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("保存失败");
            e.printStackTrace();
        }
    }

    /**
     * Properties 默认使用的编码是ascii，不能使用中文，需要转码
     * @param key
     * @param value
     */
    public void setProperty(String key, String value) {
        String result = null;
        try {
            result = new String(value.getBytes("utf-8"), "iso-8859-1");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        pro.setProperty(key, result);
        this.store();
    }

    public String getProperty(String key) {
        String s = pro.getProperty(key);
        String result = null;
        try {
            result = new String(s.getBytes("iso-8859-1"), "utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return result;
    }
}
