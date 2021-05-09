import io.netty.bootstrap.Bootstrap;
import io.netty.buffer.ByteBuf;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.timeout.IdleStateHandler;

public class NettyClient {
    public static void run(String ip, int port) throws Exception {
        NioEventLoopGroup handle = new NioEventLoopGroup(2);
        Bootstrap bootstrap = new Bootstrap();
        bootstrap.group(handle).channel(NioSocketChannel.class).handler(new ChannelInitializer<SocketChannel>() {
            @Override
            protected void initChannel(SocketChannel socketChannel) throws Exception {
                socketChannel.pipeline().addLast(new IdleStateHandler(10, 10, 0), new MyIdleHandler(), new CustomHandlerOut());
            }
        });
        ChannelFuture future = bootstrap.connect(ip, port).sync();
        future.channel().writeAndFlush(123);
        System.in.read();
    }

    private static class CustomHandlerOut extends ChannelOutboundHandlerAdapter {
        @Override
        public void write(ChannelHandlerContext ctx, Object msg, ChannelPromise promise) throws Exception {
            ByteBuf byteBuf = ctx.alloc().buffer();
            byteBuf.writeInt((Integer) msg);
            ctx.writeAndFlush(byteBuf);
        }
    }

    private static class MyIdleHandler extends ChannelDuplexHandler {
        @Override
        public void userEventTriggered(ChannelHandlerContext ctx, Object evt) throws Exception {
            System.out.println(evt);
        }
    }

    public static void main(String[] args) throws Exception {
        NettyClient.run("localhost", 8082);
    }
}
