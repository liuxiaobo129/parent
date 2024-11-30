package org.example.app1.io;

import java.io.FileDescriptor;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;


import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
public class NIO {
}



class ByteBufferSliceExample {
    public static void main(String[] args) {
        ByteBuffer buffer = ByteBuffer.allocate(10);
        buffer.put((byte) 1);
        buffer.put((byte) 2);
        buffer.put((byte) 3);
        // 创建切片
        ByteBuffer slice = buffer.slice();

        // 原始缓冲区切换到读模式

        System.out.println("切片的容量capacity: " + buffer.capacity());
        System.out.println("切片的容量position: " + buffer.position());
        System.out.println("切片的容量limit: " + buffer.limit());

        // 切片的容量等于原始缓冲区剩余字节数
        System.out.println("切片的容量capacity: " + slice.capacity());
        System.out.println("切片的容量position: " + slice.position());
        System.out.println("切片的容量limit: " + slice.limit());
        slice.put((byte) 4);

        System.out.println("切片的容量capacity: " + buffer.capacity());
        System.out.println("切片的容量position: " + buffer.position());
        System.out.println("切片的容量limit: " + buffer.limit());

        // 切片的容量等于原始缓冲区剩余字节数
        System.out.println("切片的容量capacity: " + slice.capacity());
        System.out.println("切片的容量position: " + slice.position());
        System.out.println("切片的容量limit: " + slice.limit());

        buffer.flip();


        buffer.limit(4);




        while (buffer.hasRemaining()) {
            System.out.println(buffer.get());
        }


        // 对切片进行操作
//        slice.put((byte) 4);
        // 由于共享数据，原始缓冲区的数据也会改变




//        buffer.limit(buffer.position());
//        buffer.rewind();
//
//
//        while (buffer.hasRemaining()) {
//            System.out.println(buffer.get());
//        }




    }




}


class A{
    public static void main(String[] args) {
        // 假设这是一个包含两个数据包的缓冲区，每个数据包头部占2字节（表示长度），后面是数据
        ByteBuffer buffer = ByteBuffer.allocate(14);
        buffer.putShort((short) 3);
        buffer.put((byte) 1);
        buffer.put((byte) 2);
        buffer.put((byte) 3);
        buffer.putShort((short) 4);
        buffer.put((byte) 4);
        buffer.put((byte) 5);
        buffer.put((byte) 6);
        buffer.put((byte) 7);

//        System.out.println("切片的容量capacity: " + buffer.capacity());
//        System.out.println("切片的容量position: " + buffer.position());
//        System.out.println("切片的容量limit: " + buffer.limit());
//


        // 处理第一个数据包
        buffer.flip();
        short firstPacketLength = buffer.getShort();
        ByteBuffer firstPacketData = buffer.slice();

        System.out.println("切片的容量capacity: " + buffer.capacity());
        System.out.println("切片的容量position: " + buffer.position());
        System.out.println("切片的容量limit: " + buffer.limit());

        // 切片的容量等于原始缓冲区剩余字节数
        System.out.println("切片的容量capacity: " + firstPacketData.capacity());
        System.out.println("切片的容量position: " + firstPacketData.position());
        System.out.println("切片的容量limit: " + firstPacketData.limit());





        firstPacketData.put((byte) 4);

        System.out.println("切片的容量capacity: " + firstPacketData.capacity());
        System.out.println("切片的容量position: " + firstPacketData.position());
        System.out.println("切片的容量limit: " + firstPacketData.limit());

        firstPacketData.limit(firstPacketLength);
        System.out.println("第一个数据包的数据:");
        while (buffer.hasRemaining()) {
            System.out.println(buffer.get());
        }
        System.out.println("切片的容量capacity: " + buffer.capacity());
        System.out.println("切片的容量position: " + buffer.position());
        System.out.println("切片的容量limit: " + buffer.limit());

        // 切片的容量等于原始缓冲区剩余字节数
        System.out.println("切片的容量capacity: " + firstPacketData.capacity());
        System.out.println("切片的容量position: " + firstPacketData.position());
        System.out.println("切片的容量limit: " + firstPacketData.limit());




//        // 移动到第二个数据包
//        buffer.position(buffer.position() + firstPacketLength);
//        short secondPacketLength = buffer.getShort();
//        ByteBuffer secondPacketData = buffer.slice();
//        secondPacketData.limit(secondPacketLength);
//        System.out.println("第二个数据包的数据:");
//        while (secondPacketData.hasRemaining()) {
//            System.out.println(secondPacketData.get());
//        }
    }
}





class MappedByteBufferWriteExample {
    public static void main(String[] args) throws Exception {
        // 文件路径
        String filePath = "/Users/liuxiaobo/IdeaProjects/parent-project/app1/src/main/java/org/example/app1/io/a.txt";

        try (RandomAccessFile file = new RandomAccessFile(filePath, "rw");
             FileChannel fileChannel = file.getChannel()) {

            // 创建一个 MappedByteBuffer，将文件的前 1024 字节映射到内存
//            MappedByteBuffer buffer = fileChannel.map(FileChannel.MapMode.READ_WRITE, 0,100);
            MappedByteBuffer buffer = fileChannel.map(FileChannel.MapMode.READ_WRITE, 0,100);

            // 读取文件内容
            System.out.println("文件内容：");
            while (buffer.hasRemaining()) {
                System.out.print((char) buffer.get());
            }

            // 修改文件内容
            System.out.println("\n修改文件内容...");
            buffer.position(10); // 重置位置
            buffer.put("H2llo!".getBytes()); // 写入新的内容
            buffer.force();
            System.out.println("修改完成，请检查文件内容！");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}




class MappedByteBufferWriteExample1 {
    public static void main(String[] args) throws InterruptedException {
        String filePath = "/Users/liuxiaobo/IdeaProjects/parent-project/app1/src/main/java/org/example/app1/io/e.txt";
        String newContent = "This is the new content of the file.";

        try (RandomAccessFile file = new RandomAccessFile(filePath, "rw");
             FileChannel fileChannel = file.getChannel()) {

            // 清空文件内容
            file.setLength(0); // 清空文件
            file.setLength(newContent.length()); // 扩展文件大小到新内容的长度

            // 映射文件到内存
            MappedByteBuffer buffer = fileChannel.map(FileChannel.MapMode.READ_WRITE, 0, newContent.length());

            // 写入新内容
            buffer.put(newContent.getBytes());

            // 强制同步到磁盘
//            buffer.force();

            System.out.println("新内容写入完成！");

            Thread.sleep(1000000);

        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}




 class ByteBufferMarkExample {
    public static void main(String[] args) {
        // 创建一个容量为10的ByteBuffer
        ByteBuffer buffer = ByteBuffer.allocate(10);

        // 写入数据
        buffer.put((byte) 1);
        buffer.put((byte) 2);
        buffer.put((byte) 3);

        // 设置标记
        buffer.mark(); // 此时 position = 3

        // 写入更多数据
        buffer.put((byte) 4);
        buffer.put((byte) 5);

        System.out.println("当前位置（position）: " + buffer.position()); // 输出 5

        // 重置到标记位置
        buffer.reset(); // position 恢复到 mark 时的值

        System.out.println("重置后位置（position）: " + buffer.position()); // 输出 3

        // 再次写入数据
        buffer.put((byte) 6);

        // 切换到读取模式
        buffer.flip();

        System.out.println("缓冲区内容：");
        while (buffer.hasRemaining()) {
            System.out.print(buffer.get() + " ");
        }
    }
}





 class AppendToFileWithMappedByteBuffer {
    public static void main(String[] args) {
        String filePath = "/Users/liuxiaobo/IdeaProjects/parent-project/app1/src/main/java/org/example/app1/io/e.txt";

        int iterations = 100;                // 循环写入的次数

        try (RandomAccessFile file = new RandomAccessFile(filePath, "rw");
             FileChannel fileChannel = file.getChannel()) {

            long currentFileSize = fileChannel.size(); // 初始文件大小

            for (int i = 0; i < iterations; i++) {
                String content = String.valueOf(i) + "Hello, World!\n"; // 每次写入的内容
                // 新内容所需的大小
                long additionalSize = content.getBytes().length;
                long newFileSize = currentFileSize + additionalSize;

                // 扩展文件大小
                file.setLength(newFileSize);

                // 映射新增的部分
                MappedByteBuffer buffer = fileChannel.map(
                        FileChannel.MapMode.READ_WRITE, currentFileSize, additionalSize);

                // 写入数据
                buffer.put(content.getBytes());

                // 同步到磁盘
                buffer.force();

                // 更新文件大小
                currentFileSize = newFileSize;

                System.out.println("已写入第 " + (i + 1) + " 次内容：" + content.trim());
            }

            System.out.println("循环写入完成！");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}





 class FileWriteExperiment {
     public static void main(String[] args) {
         String filePath = "/Users/liuxiaobo/IdeaProjects/parent-project/app1/src/main/java/org/example/app1/io/e.txt";
//         String newContent = "This is the new content of the file.";

         try (RandomAccessFile file = new RandomAccessFile(filePath, "rw")) {
             FileChannel fileChannel = file.getChannel();

             for (int i = 0; i < 10; i++) {
                 // 获取当前文件大小，用于确定新内容的写入位置
                 String newContent = String.valueOf(i) + "Hello, World!\n";
                 long currentFileSize = fileChannel.size();

                 // 映射文件到内存，从当前文件末尾开始映射足够写入新内容的空间
                 MappedByteBuffer buffer = fileChannel.map(FileChannel.MapMode.READ_WRITE, currentFileSize, newContent.length());

                 // 写入新内容
                 buffer.put(newContent.getBytes());

                 // 部分情况下不强制同步到磁盘
                 if (i % 2 == 0) {
                     System.out.println("不调用force()，写入第 " + i + " 次");
                 } else {
                     buffer.force();
                     System.out.println("调用force()，写入第 " + i + " 次");
                 }

                 Thread.sleep(1000);
             }
             Thread.sleep(10000000);
             fileChannel.close();
         } catch (IOException | InterruptedException e) {
             e.printStackTrace();
         }
     }
}





class MappedByteBufferNoForceExample {
    public static void main(String[] args) {
        String filePath = "/Users/liuxiaobo/IdeaProjects/parent-project/app1/src/main/java/org/example/app1/io/e.txt";


        try (RandomAccessFile file = new RandomAccessFile(filePath, "rw");
             FileChannel channel = file.getChannel()) {

            // 设置文件大小为1GB
            long fileSize = 1024L * 1024 * 1024;  // 1GB
            file.setLength(fileSize);

            // 映射文件的1GB区域到内存
            MappedByteBuffer buffer = channel.map(FileChannel.MapMode.READ_WRITE, 0, fileSize);

            // 在映射区域写入数据
            String content = "Hello, MappedByteBuffer! This is a large file test.\n";
            for (int i = 0; i < 1000000; i++) {  // 大量写入数据
                buffer.put(content.getBytes());
            }

            // 不调用 force()，数据没有被强制刷新到磁盘
            System.out.println("大量数据已写入内存，但未调用 force() 来刷新到磁盘");

            // 模拟程序崩溃，直接退出
            System.out.println("程序即将退出，数据尚未刷新到磁盘");

            // 程序退出，模拟崩溃
            System.exit(0);  // 强制退出，模拟程序崩溃

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}


 class FileChannelWriteExample {
    public static void main(String[] args) {
        try {
            String filePath = "/Users/liuxiaobo/IdeaProjects/parent-project/app1/src/main/java/org/example/app1/io/e.txt";
            // 创建一个文件输出流，并获取对应的FileChannel
            FileOutputStream fos = new FileOutputStream(filePath);
            FileChannel channel = fos.getChannel();

            // 创建一个ByteBuffer，并放入要写入的数据
            ByteBuffer buffer = ByteBuffer.allocate(1024);
            buffer.put("Hello, FileChannel!112122".getBytes());
            buffer.flip(); // 切换缓冲区为读模式，准备写入
            buffer.position(10);
            // 使用write方法将缓冲区的数据写入文件
            int bytesWritten = channel.write(buffer);
            System.out.println("写入的字节数: " + bytesWritten);

            // 关闭通道和流
            channel.close();
            fos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}