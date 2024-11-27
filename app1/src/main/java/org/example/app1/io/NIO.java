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
        String filePath = "/Users/liuxiaobo/IdeaProjects/parent-project/app1/src/main/java/org/example/app1/io/example.txt";

        try (RandomAccessFile file = new RandomAccessFile(filePath, "rw");
             FileChannel fileChannel = file.getChannel()) {

            // 创建一个 MappedByteBuffer，将文件的前 1024 字节映射到内存
            MappedByteBuffer buffer = fileChannel.map(FileChannel.MapMode.READ_WRITE, 0, Math.min(fileChannel.size(), 1024));

            // 读取文件内容
            System.out.println("文件内容：");
            while (buffer.hasRemaining()) {
                System.out.print((char) buffer.get());
            }

            // 修改文件内容
            System.out.println("\n修改文件内容...");
            buffer.position(0); // 重置位置
            buffer.put("H2llo!".getBytes()); // 写入新的内容
            buffer.force();
            System.out.println("修改完成，请检查文件内容！");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}




class MappedByteBufferWriteExample1 {
    public static void main(String[] args) {
        String filePath = "/Users/liuxiaobo/IdeaProjects/parent-project/app1/src/main/java/org/example/app1/io/example.txt";
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
            buffer.force();

            System.out.println("新内容写入完成！");

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