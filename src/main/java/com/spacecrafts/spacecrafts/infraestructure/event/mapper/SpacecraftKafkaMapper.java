package com.spacecrafts.spacecrafts.infraestructure.event.mapper;

import com.spacecrafts.spacecrafts.domain.Spacecraft;
import com.spacecrafts.spacecrafts.infraestructure.event.payload.SpacecraftKafkaPayload;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface SpacecraftKafkaMapper {
    SpacecraftKafkaPayload fromDomainToKafka(Spacecraft spacecraft);
    Spacecraft  fromKafkaToDomain( SpacecraftKafkaPayload spacecraft);
}
