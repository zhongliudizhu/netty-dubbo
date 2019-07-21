package com.coolchatting.netty.handler;

import com.coolchatting.netty.protocol.RpcRequest;
import com.coolchatting.netty.protocol.RpcResponse;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.util.concurrent.EventExecutorGroup;

public class ClientHandler extends ChannelInboundHandlerAdapter {
    private RpcRequest rpcRequest;

    public ClientHandler() {
        rpcRequest = new RpcRequest("week", "eere");
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        ctx.writeAndFlush(rpcRequest);
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        RpcResponse msg1 = (RpcResponse) msg;
        int code = msg1.getCode();
        String msg2 = msg1.getMsg();
        System.out.println(code + "\t" + msg2);
    }

    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
        ctx.close();
    }
}
