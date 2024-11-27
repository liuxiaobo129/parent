package org.example.netty;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.buffer.ByteBuf;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.util.CharsetUtil;

import java.util.concurrent.Executor;

public class EchoServer {
    public static void main(String[] args) throws Exception {
        // 创建两个事件循环组
        EventLoopGroup bossGroup = new NioEventLoopGroup(1);  // 用于接受连接
        EventLoopGroup workerGroup = new NioEventLoopGroup();  // 用于处理请求
        System.out.println("server starting...");
        try {
            // 创建服务器引导类
            ServerBootstrap b = new ServerBootstrap();
            b.group(bossGroup, workerGroup)
                    .channel(NioServerSocketChannel.class)  // 使用 NIO 的 ServerSocketChannel
                    .childHandler(new ChannelInitializer<NioSocketChannel>() {  // 初始化每个连接的Channel
                        @Override
                        public void initChannel(NioSocketChannel ch) {
                            ch.pipeline().addLast(new EchoServerHandler());  // 添加自定义的 Handler
                        }
                    });

            // 绑定端口并等待成功
            ChannelFuture f = b.bind("127.0.0.1",8092).sync();

            // 等待服务器的关闭
            f.channel().closeFuture().sync();
        } finally {
            // 优雅地关闭
            System.out.println("server end0.");
            bossGroup.shutdownGracefully();
            workerGroup.shutdownGracefully();
        }

        System.out.println("server end1.");
    }
}

class EchoServerHandler extends ChannelInboundHandlerAdapter {
    // 处理接收到的消息
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

        ctx.writeAndFlush(msg);  // 将接收到的消息原样返回
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
        cause.printStackTrace();
        ctx.close();  // 发生异常时关闭连接

    }
}