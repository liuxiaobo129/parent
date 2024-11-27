package org.example.netty.socket;

import java.io.*;
import java.net.*;

public class SimpleClient {
    public static void main(String[] args) {
        String host = "127.0.0.1"; // 服务器地址
        int port = 12345;          // 服务器端口

        try (Socket socket = new Socket(host, port)) {
            System.out.println("已连接到服务器 " + host + ":" + port);

            // 获取输出流发送消息到服务器
            OutputStream output = socket.getOutputStream();
            PrintWriter writer = new PrintWriter(output, true);
            writer.println("你好，服务器！");

            // 获取输入流读取服务器回复
            InputStream input = socket.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(input));
            String serverMessage = reader.readLine();
            System.out.println("收到服务器回复: " + serverMessage);
        } catch (IOException ex) {
            System.out.println("客户端异常: " + ex.getMessage());
            ex.printStackTrace();
        }
    }
}