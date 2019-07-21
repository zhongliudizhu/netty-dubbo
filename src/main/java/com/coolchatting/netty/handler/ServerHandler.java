package com.coolchatting.netty.handler;

import com.coolchatting.netty.protocol.RpcRequest;
import com.coolchatting.netty.protocol.RpcResponse;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class ServerHandler extends ChannelInboundHandlerAdapter {
    private static final Logger logger = LoggerFactory.getLogger(ServerHandler.class);
    private RpcRequest rpcRequest;

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        RpcRequest msg1 = (RpcRequest) msg;
        this.rpcRequest = msg1;
        logger.info("====" + msg1 + "====");
        RpcResponse rpcResponse = RpcResponse.buildSucess(rpcRequest);
        ctx.writeAndFlush(rpcResponse);
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        super.exceptionCaught(ctx, cause);
    }
}
