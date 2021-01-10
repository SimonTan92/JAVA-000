package com.homework.demo.kafkaUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Component;
import org.springframework.util.concurrent.ListenableFutureCallback;


@Component
public class KafkaProducerDemo {

    @Autowired
    private KafkaTemplate<String, Object> kafkaTemplate;

    /**
     * 简单生产者
     * @param topic
     * @param message
     */
    public void send(String topic, String message) {
        kafkaTemplate.send(topic, message);
    }

    public void sendWithCallback(String topic, String message) {
        kafkaTemplate.send(topic, message).addCallback(
                success->{
                    System.out.println(success.getRecordMetadata().topic());
                    System.out.println(success.getRecordMetadata().offset());
                }, failure->{
                    System.out.println(failure.toString());
                });
    }

    public void sendWithCallbackAnother(String topic, String message) {
        kafkaTemplate.send(topic, message).addCallback(new ListenableFutureCallback<SendResult<String, Object>>() {
            @Override
            public void onFailure(Throwable ex) {
                System.out.println(ex.getMessage());
            }

            @Override
            public void onSuccess(SendResult<String, Object> result) {
                System.out.println(result.getRecordMetadata().topic());
                System.out.println(result.getRecordMetadata().offset());
            }
        });
    }
}
