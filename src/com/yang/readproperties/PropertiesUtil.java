package com.yang.readproperties;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesUtil {
    private String path = "";
    private Properties pro = null;

    public PropertiesUtil(String path){
        this.path = path;
        this.init();
    }

    public void init(){
        pro = new Properties();
        FileInputStream in = null;
        try {
            in = new FileInputStream(path);
            pro.load(in);
        } catch (FileNotFoundException e) {
            System.out.println("该路径->"+path+"文件不存在");
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
            System.out.println("该路径->"+path+"文件不存在");
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("保存失败");
            e.printStackTrace();
        }
    }

    public void setProperty(String key, String value) {
        pro.setProperty(key, value);
        this.store();
    }

    public String getProperty(String key) {
        return pro.getProperty(key);
    }
}
