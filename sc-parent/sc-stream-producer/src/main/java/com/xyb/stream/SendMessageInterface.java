package com.xyb.stream;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.SubscribableChannel;

// 创建发送消息通道
public interface SendMessageInterface {

    // 1、创建消息发送通道
    @Output("my_stream_channel")
    SubscribableChannel sendMsg();
}
