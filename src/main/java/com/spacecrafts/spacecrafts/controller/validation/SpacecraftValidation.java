package com.spacecrafts.spacecrafts.controller.validation;

import com.spacecrafts.spacecrafts.controller.dto.PatchSpacecraftDTO;
import com.spacecrafts.spacecrafts.controller.dto.SpacecraftDto;
import com.spacecrafts.spacecrafts.domain.exception.rest.RestErrorEnum;
import com.spacecrafts.spacecrafts.domain.exception.rest.RestValidationException;

public class SpacecraftValidation {
    public SpacecraftValidation() {
    }

    public static void validatePatchDTO(PatchSpacecraftDTO dto){
        validateId(dto.getId());
        if ((dto.getName() == null || dto.getName().isBlank())
                && (dto.getFilm() ==null || dto.getFilm().isBlank())
                && (dto.getDescription() ==null || dto.getDescription().isBlank())){
            throw new RestValidationException(RestErrorEnum.FIELD_NOT_EMPTY);
        }

    }
    public static void validateId(int id){
        if (id==0){
            throw new RestValidationException(RestErrorEnum.EMPTY_FIELD_ERROR);
        }
        if (id<0){
            throw new RestValidationException(RestErrorEnum.ID_VALUE_ERROR);
        }
    }

    public static void validatePostDto(SpacecraftDto dto ){
        if (dto.getName() == null || dto.getName().isEmpty()||
                dto.getFilm() ==null || dto.getFilm().isEmpty() ||
                dto.getDescription() ==null || dto.getDescription().isEmpty()){
            throw new RestValidationException(RestErrorEnum.EMPTY_FIELD_ERROR);
        }
    }

}
