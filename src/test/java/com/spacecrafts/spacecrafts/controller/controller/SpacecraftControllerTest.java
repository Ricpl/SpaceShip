package com.spacecrafts.spacecrafts.controller.controller;

import com.spacecrafts.spacecrafts.controller.dto.PatchSpacecraftDTO;
import com.spacecrafts.spacecrafts.controller.dto.SpacecraftDto;
import com.spacecrafts.spacecrafts.controller.mapper.SpacecraftDtoMapper;
import com.spacecrafts.spacecrafts.controller.validation.SpacecraftValidation;
import com.spacecrafts.spacecrafts.domain.Spacecraft;
import com.spacecrafts.spacecrafts.domain.application.CrudUseCase;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class SpacecraftControllerTest {
    @Mock
    CrudUseCase service;

    @Mock
    SpacecraftDtoMapper mapper;
    @Mock
    SpacecraftValidation validation;

    @InjectMocks
    SpacecraftController controller;

    final int GENERIC_ID = 1;
    final String GENERIC_NAME="name";
    final String GENERIC_DESCRIPTION ="description";
    final String GENERIC_FILM ="film";

    @Test
    void getSpacecraftById() {
        //Given
        int id= GENERIC_ID;

        //when
        when(this.service.getSpacecraftById(id)).thenReturn(this.generateSpacecraftDomain());
        when(this.mapper.fromDomainToDto(any())).thenReturn(this.generateSpacraftDto());

        //Then
        ResponseEntity<SpacecraftDto> response = this.controller.getSpacecraftById(id);
        assertNotNull(response.getBody());
        assertEquals(HttpStatus.OK,response.getStatusCode());
    }


    @Test
    void getSpacecraftByName() {
        //Given
        String name= GENERIC_NAME;

        //when
        when(this.service.getSpacecraftByName(name)).thenReturn(List.of(this.generateSpacecraftDomain()));
        when(this.mapper.fromDomainToDtoList(any())).thenReturn(List.of(this.generateSpacraftDto()));

        //Then
        ResponseEntity<List<SpacecraftDto>> response = this.controller.getSpacecraftByName(name);
        assertNotNull(response.getBody());
        assertEquals(HttpStatus.OK,response.getStatusCode());
    }

    @Test
    void postSpacecraft() {

        //when
        when(this.mapper.fromDtoToDomainPost(any())).thenReturn(this.generateSpacecraftDomain());

        //Then
        ResponseEntity<String> response=this.controller.postSpacecraft(this.generateSpacraftDto());
        assertEquals(HttpStatus.OK,response.getStatusCode());
        verify(this.service,times(1)).postSpacecraft(any());
    }

    @Test
    void deleteSpacecraft() {
        //Given
        int id =GENERIC_ID;

        //Then
        ResponseEntity<?> response=this.controller.deleteSpacecraft(id);
        assertEquals(HttpStatus.OK,response.getStatusCode());
        verify(this.service,times(1)).deleteSpacecrat(id);
    }

    @Test
    void upateSpacecraft() {
        //Given
        PatchSpacecraftDTO patchDto = new PatchSpacecraftDTO(GENERIC_ID,GENERIC_NAME, GENERIC_FILM,GENERIC_DESCRIPTION);

        //Then
        ResponseEntity<?> response=this.controller.upateSpacecraft(patchDto);
        assertEquals(HttpStatus.OK,response.getStatusCode());
        verify(this.service,times(1)).patchSpacecraft(any());

    }


    private Spacecraft generateSpacecraftDomain(){
        return new Spacecraft(1L,GENERIC_NAME, GENERIC_FILM, GENERIC_DESCRIPTION);
    }

    private SpacecraftDto generateSpacraftDto(){
        SpacecraftDto spacecraftDto= new SpacecraftDto();
        spacecraftDto.setDescription(GENERIC_DESCRIPTION);
        spacecraftDto.setFilm(GENERIC_FILM);
        spacecraftDto.setName(GENERIC_NAME);
        return spacecraftDto;
    }

}