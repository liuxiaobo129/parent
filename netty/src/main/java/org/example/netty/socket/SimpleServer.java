package org.example.netty.socket;

import java.io.*;
import java.net.*;

public class SimpleServer {
    public static void main(String[] args) {
        int port = 12345; // 监听端口
        try (ServerSocket serverSocket = new ServerSocket(port)) {
            System.out.println("服务器正在监听端口 " + port + "...");

            // 等待客户端连接
            Socket clientSocket = serverSocket.accept();
            System.out.println("客户端已连接: " + clientSocket.getInetAddress());

            // 获取输入流读取客户端消息
            InputStream input = clientSocket.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(input));
            while(true){
                String clientMessage = reader.readLine();
                System.out.println("收到客户端消息: " + clientMessage);
            }
//           // 获取输出流发送回复
//            OutputStream output = clientSocket.getOutputStream();
//            PrintWriter writer = new PrintWriter(output, true);
//            writer.println("服务器已收到你的消息！");
//
//            // 关闭连接
//            clientSocket.close();

        } catch (IOException ex) {
            System.out.println("服务器异常: " + ex.getMessage());
            ex.printStackTrace();
        }
    }
}