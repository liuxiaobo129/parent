package org.example.app1.spring.config.yml;

import org.yaml.snakeyaml.DumperOptions;
import org.yaml.snakeyaml.Yaml;

import java.io.FileInputStream;
import java.io.InputStream;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.locks.LockSupport;

public class YamlParser {

    public static void main(String[] args) {
        // 创建 Yaml 对象
        Yaml yaml = new Yaml();

        // 使用 ClassLoader 加载资源文件
        try (InputStream inputStream = new FileInputStream("/Users/liuxiaobo/IdeaProjects/parent-project/app1/src/main/java/org/example/app1/spring/config/yml/config.yml")) {
            if (inputStream == null) {
                System.out.println("文件未找到");
                return;
            }

            // 解析 YAML 文件并映射到 Config 类
            Config config = yaml.loadAs(inputStream, Config.class);

//            ConcurrentHashMap

            // 打印解析结果
            System.out.println("Server Host: " + config.getServer().getHost());
            System.out.println("Server Port: " + config.getServer().getPort());
            System.out.println("Database URL: " + config.getDatabase().getUrl());
            System.out.println("Database Username: " + config.getDatabase().getUsername());

            LockSupport.park();


            List l;




        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}