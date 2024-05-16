package com.spacecrafts.spacecrafts.infraestructure.event;

import com.spacecrafts.spacecrafts.domain.application.CrudUseCase;
import com.spacecrafts.spacecrafts.infraestructure.event.mapper.SpacecraftKafkaMapper;
import com.spacecrafts.spacecrafts.infraestructure.event.payload.SpacecraftKafkaPayload;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class SpacecraftKafkaConsumer {
    @Autowired
    SpacecraftKafkaMapper mapper;
    @Autowired
    CrudUseCase useCase;

    @KafkaListener(topics="spacecraftUpdateTopic", groupId = "groupId")
    public void consumer(SpacecraftKafkaPayload message){
        this.useCase.postSpacecraft(this.mapper.fromKafkaToDomain(message));
    }
}
