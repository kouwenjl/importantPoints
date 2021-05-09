package com.example.springcloudclient;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.config.DelegatingApplicationListener;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.Closeable;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.Enumeration;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;


@SpringBootApplication
@Controller
public class SpringcloudclientApplication {

    public static void main(String[] args) throws Exception {
//        DelegatingApplicationListener
//         loadVirtualPackage();
        SpringApplication.run(SpringcloudclientApplication.class, args);
    }

    @RequestMapping("/dxs")
    public String dxs() {
        return "d";
    }


    public static void loadVirtualPackage() {
        String target = "BOOT-INF/lib/MA-1.0-SNAPSHOT.jar";
        String tempDir = "yh-temp";
        String tempFileName = "tools.jar";
        String fullPath = tempDir+File.separator+tempFileName;
        if(fileExist(fullPath)) {
            load(fullPath);
            return;
        }
        FileOutputStream fileOutputStream = null;
        ZipFile zipFile = null;
        try {
            String sourceFileName = Thread.currentThread().getContextClassLoader().getResource(target).getPath();
            if(sourceFileName != null && sourceFileName.contains("!/")) {
                sourceFileName = sourceFileName.substring(5, sourceFileName.indexOf("!/"));
                System.out.println(sourceFileName);
            } else {
                return;
            }
            zipFile = new ZipFile(sourceFileName);
            Enumeration<? extends ZipEntry> enumeration = zipFile.entries();
            while (enumeration.hasMoreElements()) {
                ZipEntry zipEntry = enumeration.nextElement();
                if (target.equals(zipEntry.getName())) {
                    InputStream inputStream = zipFile.getInputStream(zipEntry);
                    if (!fileExist(tempDir)) {
                        new File(tempDir).mkdirs();
                    }
                    File file = new File(fullPath);
                    if (!file.exists()) {
                        fileOutputStream = new FileOutputStream(file);
                        byte[] data = new byte[1024];
                        int index = -1;
                        while ((index = inputStream.read(data)) != -1) {
                            fileOutputStream.write(data, 0, index);
                        }
                    }
                    load(fullPath);
                    break;
                }
            }
        } catch (Exception e) {
            throw new RuntimeException(tempFileName + " load error", e);
        }
        finally {
            close(zipFile,fileOutputStream);
        }
    }
    public static  boolean fileExist(String path) {
        return new File(path).exists();
    }
    public static void load(String path) {
        try {
            if(!fileExist(path)) {
                return;
            }
            ClassLoader classLoader = ClassLoader.getSystemClassLoader();
            Class loaderClass = classLoader.getClass().getSuperclass();
            Method method = loaderClass.getDeclaredMethod("addURL", URL.class);
            method.setAccessible(true);
            method.invoke(classLoader, new URL("file:"+path));
            classLoader.loadClass("a.A");
        } catch (Exception e) {
            throw new RuntimeException(path + " load error", e);
        }

    }
    public static void close(Closeable ...closeables) {
        for(Closeable closeable : closeables) {
            if(closeable != null) {
                try {
                    closeable.close();
                } catch (Exception e){

                }
            }
        }
    }

}


