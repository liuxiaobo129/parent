package org.example.app1.spring.config;


import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.List;
import java.util.Map;

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
}
