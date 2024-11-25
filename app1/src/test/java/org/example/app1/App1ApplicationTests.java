package org.example.app1;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.FileOutputStream;
import java.io.IOException;

@SpringBootTest
class App1ApplicationTests {

    @Test
    void contextLoads() {

                // 要写入的十六进制数据
                byte[] data = {
                        (byte) 0x00, (byte) 0x00, (byte) 0x00, (byte) 0x00,
                        (byte) 0x00, (byte) 0x00, (byte) 0x00, (byte) 0xF0,
                        (byte) 0x00, (byte) 0x00, (byte) 0x00, (byte) 0xF0,
                        (byte) 0x00, (byte) 0x00, (byte) 0x00, (byte) 0x00
                };

                // 目标文件路径
                String filePath = "output.bin";

                // 写入文件
                try (FileOutputStream fos = new FileOutputStream(filePath)) {
                    fos.write(data);
                    System.out.println("16进制数据已写入文件: " + filePath);
                } catch (IOException e) {
                    System.err.println("文件写入失败: " + e.getMessage());
                }
            }

}
