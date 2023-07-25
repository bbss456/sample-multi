package com.example.netty.config;


import com.example.netty.socket.NettyServer;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@RequiredArgsConstructor
public class NettServerTest {

    private final NettyServer nettyServer;

    @Bean
    public void nettTest() {
        log.info("Init Netty SERVER");
        nettyServer.startServer();
    }

}
