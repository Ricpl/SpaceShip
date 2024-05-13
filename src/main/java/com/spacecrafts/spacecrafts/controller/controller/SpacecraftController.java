package com.spacecrafts.spacecrafts.controller.controller;

import com.spacecrafts.spacecrafts.controller.api.SpacecraftApi;
import com.spacecrafts.spacecrafts.controller.dto.PatchSpacecraftDTO;
import com.spacecrafts.spacecrafts.controller.dto.SpacecraftDto;
import com.spacecrafts.spacecrafts.controller.mapper.SpacecraftDtoMapper;
import com.spacecrafts.spacecrafts.controller.validation.SpacecraftValidation;
import com.spacecrafts.spacecrafts.domain.application.CrudUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.stream.Collectors;


@RestController
public class SpacecraftController implements SpacecraftApi {

    @Autowired
    CrudUseCase getService;

    @Autowired
    SpacecraftDtoMapper mapper;

    private final SpacecraftValidation validation = new SpacecraftValidation();

    @Override
    public ResponseEntity<SpacecraftDto> getSpacecraftById(int id) {
        this.validation.validateId(id);
        return new ResponseEntity<>(this.mapper.fromDomainToDto(this.getService.getSpacecraftById(id)), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<?> getSpacecraft(Pageable pageable) {
        return new ResponseEntity<>(this.getService.getAllSpaceCraft(pageable).stream().collect(Collectors.toList()), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<SpacecraftDto>> getSpacecraftByName(String name) {
        return new ResponseEntity<>(this.mapper.fromDomainToDtoList(this.getService.getSpacecraftByName(name)),HttpStatus.OK);
    }

    @Override
    public ResponseEntity<String> postSpacecraft(@RequestBody SpacecraftDto dto) {
        this.validation.validatePostDto(dto);
        this.getService.postSpacecraft(this.mapper.fromDtoToDomainPost(dto));
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @Override
    public ResponseEntity<?> deleteSpacecraft(int id) {
        this.validation.validateId(id);
        this.getService.deleteSpacecrat(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @Override
    public ResponseEntity<?> upateSpacecraft(PatchSpacecraftDTO dto) {
        this.validation.validatePatchDTO(dto);
        this.getService.patchSpacecraft(this.mapper.fromDtoToDomainPatch(dto));
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
