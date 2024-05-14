package com.spacecrafts.spacecrafts.controller.validation;

import com.spacecrafts.spacecrafts.controller.dto.PatchSpacecraftDTO;
import com.spacecrafts.spacecrafts.controller.dto.SpacecraftDto;
import com.spacecrafts.spacecrafts.domain.exception.rest.RestValidationException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class SpacecraftValidationTest {


    @ParameterizedTest
    @MethodSource("argumentToTestPatchDtoOK")
    void validatePatchDtoOK(int id, String description, String film, String name) {
        //Given
        PatchSpacecraftDTO dto= new PatchSpacecraftDTO(id,description,film,name);

        assertDoesNotThrow(()->SpacecraftValidation.validatePatchDTO(dto));
    }

    static Stream<Arguments> argumentToTestPatchDtoOK(){
        return Stream.of(
                Arguments.of(1,"Descrption","film","name"),
                Arguments.of(1,"Descrption","",""),
                Arguments.of(1,"Descrption",null,""),
                Arguments.of(1,"Descrption",null,null));
    }

    @ParameterizedTest
    @MethodSource("argumentToTestPatchDtoKO")
    void validatePatchDtoKO(int id, String description, String film, String name) {
        //Given
        PatchSpacecraftDTO dto= new PatchSpacecraftDTO(id,description,film,name);

        assertThrows(RestValidationException.class, ()-> SpacecraftValidation.validatePatchDTO(dto));
    }

    static Stream<Arguments> argumentToTestPatchDtoKO(){
        return Stream.of(
                Arguments.of(0,"","",""),
                Arguments.of(0,null,null,null),
                Arguments.of(1,"","",""),
                Arguments.of(1,null,null,null),
                Arguments.of(-1,"Descrption","film","name"));

    }

    @Test
    void validateIdOK() {
        //Given
        int id=1;
        //then
        assertDoesNotThrow(()->SpacecraftValidation.validateId(id));
    }

    @ParameterizedTest
    @MethodSource("argumentToTestIdKO")
    void validateIdKO(int id) {
        assertThrows(RestValidationException.class, ()-> SpacecraftValidation.validateId(id));
    }

    static Stream<Arguments> argumentToTestIdKO(){
        return Stream.of(
                Arguments.of(0),
                Arguments.of(-1));

    }

    @Test
    void validatePostDtoOK() {
        SpacecraftDto dto = new SpacecraftDto("Descrption","film","name");
        assertDoesNotThrow(() -> SpacecraftValidation.validatePostDto(dto));
    }

    @ParameterizedTest
    @MethodSource("argumentToTestPostKO")
    void validatePostDtoKO(String description, String film, String name) {
        //Given
        SpacecraftDto spacecraft = new SpacecraftDto(description,film,name);
        //Then
        assertThrows(RestValidationException.class, ()-> SpacecraftValidation.validatePostDto(spacecraft));
    }

    static Stream<Arguments> argumentToTestPostKO(){
        return Stream.of(
                Arguments.of("","",""),
                Arguments.of(null,null,null),
                Arguments.of("Descrption",null,null),
                Arguments.of("Descrption","",null),
                Arguments.of("Descrption","",null),
                Arguments.of("Descrption","film",""));


    }
}