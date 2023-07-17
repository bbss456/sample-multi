package com.example.netty.decoder;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class TestDecoder extends ByteToMessageDecoder {
    private int DATA_LENGTH = 2024;

    int Count = 0;
    @Override
    protected void decode(ChannelHandlerContext ctx, ByteBuf in, List<Object> out) throws Exception {


        System.out.println(Count++);
        ByteBuf byteBufMessage = (ByteBuf) in;
//        // 읽을 수 있는 바이트의 길이를 가져옵니다.
//        int size = byteBufMessage.readableBytes();
//
//        // 읽을 수 있는 바이트의 길이만큼 바이트 배열을 초기화합니다.
//        byte [] byteMessage = new byte[size];
//        // for문을 돌며 가져온 바이트 값을 연결합니다.
//        for(int i = 0 ; i < size; i++){
//            byteMessage[i] = byteBufMessage.getByte(i);
//        }
//
//
//
//
//        // 바이트를 String 형으로 변환합니다.
//        String str = new String(byteMessage);
//
//        // 결과를 콘솔에 출력합니다.
//        System.out.println(str);

        // 그후 컨텍스트를 종료합니다.

        //out.clear();
    }
}