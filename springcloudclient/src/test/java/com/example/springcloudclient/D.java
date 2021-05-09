package com.example.springcloudclient;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class D {
    public static void main(String[] args) throws Exception {
        String path = "C:\\Users\\dxs\\Desktop\\基础参数(41)\\基础参数";
        File[] files = new File(path).listFiles();
        for (File file : files) {
            System.out.println(file.getName());
            BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(file), "utf-8"));
            String str = "";
            while ((str = reader.readLine()) != null) {
                if (str.trim().contains("第")) {

                    System.out.println("fileName=:" + file.getName() + str);
                }
            }
            reader.close();

        }

    }
}
