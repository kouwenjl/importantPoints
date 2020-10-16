import io.netty.bootstrap.ServerBootstrap;
import io.netty.buffer.ByteBuf;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.ByteToMessageDecoder;
import io.netty.handler.codec.ReplayingDecoder;
import io.netty.handler.timeout.IdleStateHandler;

import java.util.List;

public class NettyServer {
    public static void run(String ip, int port) throws InterruptedException {
        NioEventLoopGroup connect = new NioEventLoopGroup(1);
        NioEventLoopGroup handle = new NioEventLoopGroup(3);
        ServerBootstrap bootstrap = new ServerBootstrap();
        bootstrap.group(connect, handle).channel(NioServerSocketChannel.class).option(ChannelOption.SO_BACKLOG, 10).childOption(ChannelOption.SO_TIMEOUT, 5000).
                childHandler(
                        new ChannelInitializer<SocketChannel>() {
                            @Override
                            protected void initChannel(SocketChannel socketChannel) throws Exception {
                                socketChannel.pipeline().addLast(new CustomStringDecoderTwo(), new CustomHandlerIn(), new CustomHandlerInTwo());
                            }
                        }
                );
        System.out.println("启动netty服务器....");
        ChannelFuture future = bootstrap.bind(ip, port).sync();
        future.channel().closeFuture().sync();
        connect.shutdownGracefully();
        handle.shutdownGracefully();

    }

    private static class CustomStringDecoder extends ByteToMessageDecoder {

        @Override
        protected void decode(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf, List<Object> list) throws Exception {
            System.out.println(byteBuf.readableBytes());
            list.add(byteBuf.readInt());

        }
    }

    private static class CustomStringDecoderTwo extends ReplayingDecoder {
        @Override
        protected void decode(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf, List<Object> list) throws Exception {
            list.add(byteBuf.readInt());
        }
    }

    private static class CustomHandlerIn extends ChannelInboundHandlerAdapter {
        public void channelRead(ChannelHandlerContext channelHandlerContext, Object o) throws Exception {
            System.out.println(o);
            //channelHandlerContext.fireChannelRead("123");
        }
    }

    private static class CustomHandlerInTwo extends ChannelInboundHandlerAdapter {
        public void channelRead(ChannelHandlerContext channelHandlerContext, Object o) throws Exception {
            ByteBuf byteBuf = (ByteBuf) o;
            byte[] bytes = new byte[byteBuf.readableBytes()];
            byteBuf.readBytes(bytes);
            System.out.println(new String(bytes));
        }
    }

    public static void main(String[] args) throws Exception {
        NettyServer.run("localhost", 8082);
    }
}
