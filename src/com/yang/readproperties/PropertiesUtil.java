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
            //Properties 默认使用的编码是ascii，不能使用中文，需要转码
            pro.load(new InputStreamReader(in,"utf-8"));
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
            //Properties 默认使用的编码是ascii，不能使用中文，需要转码
            pro.store(new OutputStreamWriter(oFile, "utf-8"), "Comment");
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
        pro.setProperty(key, value);
        this.store();
    }

    public String getProperty(String key) {
        String result = pro.getProperty(key).trim();  //去掉末尾空格
        return result;
    }
}
