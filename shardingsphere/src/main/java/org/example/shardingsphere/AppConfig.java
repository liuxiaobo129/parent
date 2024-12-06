package org.example.shardingsphere;


import org.springframework.boot.context.properties.ConfigurationProperties;
import org.yaml.snakeyaml.Yaml;

import java.io.InputStream;
import java.util.Map;
import java.util.List;

@ConfigurationProperties(prefix = "app")
public class AppConfig {


    private String name;

    private Info info;

    private Map<String, User> settings;

    private List<String> features;

    public List<String> getFeatures() {
        return features;
    }

    public void setFeatures(List<String> features) {
        this.features = features;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Info getInfo() {
        return info;
    }

    public void setInfo(Info info) {
        this.info = info;
    }

    public Map<String, User> getSettings() {
        return settings;
    }

    public void setSettings(Map<String, User> settings) {
        this.settings = settings;
    }


    public static void main(String[] args) {
        // 读取 YAML 文件
        Yaml yaml = new Yaml();
        try (InputStream inputStream = AppConfig.class.getClassLoader().getResourceAsStream("/Users/liuxiaobo/IdeaProjects/parent-project/shardingsphere/src/main/java/org/example/shardingsphere/config.yml")) {
            // 将 YAML 文件解析为 Java 对象
            AppConfig appConfig = yaml.loadAs(inputStream, AppConfig.class);
            System.out.println(appConfig);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
