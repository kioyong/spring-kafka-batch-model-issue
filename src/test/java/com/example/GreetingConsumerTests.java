package com.example;

import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.stream.binder.test.InputDestination;
import org.springframework.cloud.stream.binder.test.TestChannelBinderConfiguration;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.context.annotation.Import;
import org.springframework.messaging.support.GenericMessage;

@SpringBootTest
@Import(TestChannelBinderConfiguration.class)
class GreetingConsumerTests {

    @Autowired
    InputDestination process;

    @Autowired
    StreamBridge streamBridge;

    @Test
    void sentMessage() {

//        process.send(new GenericMessage<>(new GreetingMessage("test", 10)),"greeting");
        streamBridge.send("greeting-out-0", new GreetingMessage("hello"));
    }

}