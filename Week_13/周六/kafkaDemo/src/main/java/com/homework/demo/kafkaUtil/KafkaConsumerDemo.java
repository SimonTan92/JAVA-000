package com.homework.demo.kafkaUtil;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class KafkaConsumerDemo {

    /**
     * 简单消费者
     * @param record
     */
    @KafkaListener(topics = {"test1"})
    public void onMessage(ConsumerRecord<?, ?> record) {
        System.out.println("简单消费: " + record.topic() + "-" + record.value());
    }
}
