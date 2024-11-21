package com.ecom.kafka;

import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.common.internals.Topic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;
import com.google.gson.Gson;
import static org.springframework.kafka.support.KafkaHeaders.TOPIC;
@Service
@Slf4j
public class PaymentProducer {
    @Autowired
    private KafkaTemplate<String,Object>kafkaTemplate;
    public void sendMessage(PaymentConformation paymentConformation){
        Gson gson=new Gson();
        String msg= gson.toJson(paymentConformation);
        log.info("Sending notification with body = < {} >", paymentConformation);

        kafkaTemplate.send("payment-topic",msg);

    }

}
