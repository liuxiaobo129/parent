package org.example.app1.spring.config.yml;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.*;

public class SimpleYamlParser {

    public static Map<String, Object> parseYaml(String filePath) throws Exception {
        Map<String, Object> result = new HashMap<>();
        Stack<Map<String, Object>> stack = new Stack<>();
        stack.push(result);

        int previousIndent = -1;

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                line = line.trim();
                if (line.isEmpty() || line.startsWith("#")) {
                    continue; // 跳过空行或注释
                }

                int currentIndent = countIndent(line);
                String[] parts = line.split(":", 2);
                String key = parts[0].trim();

                if (parts.length > 1) { // 键值对
                    String value = parts[1].trim();
                    if (value.isEmpty()) { // 值为空，则可能有嵌套
                        Map<String, Object> nestedMap = new HashMap<>();
                        stack.peek().put(key, nestedMap);
                        stack.push(nestedMap);
                    } else {
                        stack.peek().put(key, value);
                    }
                } else if (line.startsWith("-")) { // 处理列表
                    String listItem = line.substring(1).trim();
                    List<Object> list = (List<Object>) stack.peek().computeIfAbsent(key, k -> new ArrayList<>());
                    list.add(listItem);
                }

                if (currentIndent < previousIndent) { // 回退到父级
                    for (int i = 0; i < (previousIndent - currentIndent) / 2; i++) {
                        stack.pop();
                    }
                }
                previousIndent = currentIndent;
            }
        }
        return result;
    }

    private static int countIndent(String line) {
        int count = 0;
        while (line.startsWith("  ", count)) {
            count += 2;
        }
        return count;
    }

    public static void main(String[] args) throws Exception {
        Map<String, Object> yamlData = parseYaml("/Users/liuxiaobo/IdeaProjects/parent-project/app1/src/main/java/org/example/app1/spring/config/yml/config.yml");
        System.out.println(yamlData);
    }



}