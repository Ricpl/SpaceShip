package com.spacecrafts.spacecrafts.controller.mapper;

import com.spacecrafts.spacecrafts.controller.dto.PatchSpacecraftDTO;
import com.spacecrafts.spacecrafts.controller.dto.SpacecraftDto;
import com.spacecrafts.spacecrafts.domain.Spacecraft;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface SpacecraftDtoMapper {
    SpacecraftDto fromDomainToDto(Spacecraft spacecraft);
    Spacecraft  fromDtoToDomainPost(SpacecraftDto spacecraft);
    List<SpacecraftDto> fromDomainToDtoList(List<Spacecraft> spacecrafts);
    Spacecraft  fromDtoToDomainPatch(PatchSpacecraftDTO spacecraft);

}
