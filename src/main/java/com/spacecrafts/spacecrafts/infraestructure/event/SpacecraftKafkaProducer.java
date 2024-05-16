package com.spacecrafts.spacecrafts.infraestructure.event;

import com.spacecrafts.spacecrafts.domain.Spacecraft;
import com.spacecrafts.spacecrafts.infraestructure.event.mapper.SpacecraftKafkaMapper;
import com.spacecrafts.spacecrafts.infraestructure.event.payload.SpacecraftKafkaPayload;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

@Service
public class SpacecraftKafkaProducer {
    @Autowired
    SpacecraftKafkaMapper mapper;

    private KafkaTemplate<String,SpacecraftKafkaPayload> kafkaTemplate;

    public SpacecraftKafkaProducer(KafkaTemplate<String, SpacecraftKafkaPayload> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendMessage(Spacecraft input){
        SpacecraftKafkaPayload data= this.mapper.fromDomainToKafka(input);
        Message<SpacecraftKafkaPayload> message = MessageBuilder
                .withPayload(data)
                        .setHeader(KafkaHeaders.TOPIC,"spacecraftUpdateTopic")
                                .build();
        System.out.println("Mensaje enviado");
        this.kafkaTemplate.send(message);
    }
}
