package com.spacecrafts.spacecrafts.controller.mapper;

import com.spacecrafts.spacecrafts.controller.dto.PatchSpacecraftDTO;
import com.spacecrafts.spacecrafts.controller.dto.PostSpacecraftDto;
import com.spacecrafts.spacecrafts.domain.Spacecraft;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface SpacecraftDtoMapper {
    PostSpacecraftDto fromDomainToDto(Spacecraft spacecraft);
    Spacecraft  fromDtoToDomainPost(PostSpacecraftDto spacecraft);
    List<PostSpacecraftDto> fromDomainToDtoList(List<Spacecraft> spacecrafts);
    Spacecraft  fromDtoToDomainPatch(PatchSpacecraftDTO spacecraft);

}
