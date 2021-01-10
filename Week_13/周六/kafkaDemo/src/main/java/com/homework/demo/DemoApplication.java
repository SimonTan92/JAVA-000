package com.homework.demo;

import com.homework.demo.kafkaUtil.KafkaProducerDemo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(DemoApplication.class, args);
        KafkaProducerDemo kafkaProducer = context.getBean(KafkaProducerDemo.class);
        // SpringApplication.run(DemoApplication.class, args);
        for (int i=0; i<=10; i++) {
            // kafkaProducer.send("test1", "hello"+i);
            kafkaProducer.sendWithCallback("test1", "callback"+i);
            kafkaProducer.sendWithCallbackAnother("test1", "callbackAnther_"+i*2);
        }
    }
}
