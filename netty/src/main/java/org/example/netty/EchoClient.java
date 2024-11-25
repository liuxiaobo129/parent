package org.example.netty;

import io.netty.bootstrap.Bootstrap;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.util.CharsetUtil;

import java.nio.charset.StandardCharsets;

public class EchoClient {
    public static void main(String[] args) throws Exception {
        String host = "127.0.0.1";  // 服务器地址
        int port = 8092;  // 服务器端口

        // 创建事件循环组
        EventLoopGroup group = new NioEventLoopGroup();
        System.out.println("client starting...");
        try {
            // 创建客户端引导类
            Bootstrap b = new Bootstrap();
            b.group(group)
                    .channel(NioSocketChannel.class)  // 使用 NIO 的 SocketChannel
                    .handler(new ChannelInitializer<Channel>() {
                        @Override
                        public void initChannel(Channel ch) {
                            ch.pipeline().addLast(new EchoClientHandler());
                        }
                    });

            // 连接到服务器
            ChannelFuture f = b.connect(host, port).sync();

//            // 发送消息
//            ByteBuf buf = f.channel().alloc().buffer();
//
//            buf.writeBytes("你好，服务器！".getBytes(StandardCharsets.UTF_8));
//            f.channel().writeAndFlush(buf).sync();
            // 发送消息
            // 使用 Unpooled.copiedBuffer() 将 String 转换为 ByteBuf
            f.channel().writeAndFlush(Unpooled.copiedBuffer("Hello, Netty!", CharsetUtil.UTF_8));
            // 等待客户端关闭
            f.channel().closeFuture().sync();
        } finally {
            System.out.println("client stopped1");
            // 优雅地关闭
            group.shutdownGracefully();
        }
        System.out.println("client stopped.");
    }
}

class EchoClientHandler extends ChannelInboundHandlerAdapter {
    // 处理从服务器收到的消息
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) {
        if (msg instanceof ByteBuf) {
            ByteBuf byteBuf = (ByteBuf) msg;
            // 将 ByteBuf 转换为字符串，使用 UTF-8 编码
            String receivedMessage = byteBuf.toString(CharsetUtil.UTF_8);
            System.out.println("Server received: " + receivedMessage);
        } else {
            System.out.println("Received unknown message type: " + msg.getClass());
        }
        ctx.close();  // 读取完数据后关闭连接
    }


    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
        cause.printStackTrace();
        ctx.close();  // 发生异常时关闭连接
    }
}