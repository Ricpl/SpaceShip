package com.spacecrafts.spacecrafts.controller.api;

import com.spacecrafts.spacecrafts.controller.dto.PatchSpacecraftDTO;
import com.spacecrafts.spacecrafts.controller.dto.PostSpacecraftDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.data.domain.Pageable;

import java.util.List;


public interface SpacecraftApi {
    @RequestMapping(
            method = RequestMethod.GET,
            value = "/spacecrafts",
            produces = "application/json")
    default ResponseEntity<?> getSpacecraft(Pageable pageable){
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }

    @RequestMapping(
            method = RequestMethod.GET,
            value = "/spacecraft/id/{id}",
            produces = "application/json")
    default ResponseEntity<PostSpacecraftDto> getSpacecraftById(@PathVariable Long id){
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }

    @RequestMapping(
            method = RequestMethod.GET,
            value = "/spacecraft/name/{name}",
            produces = "application/json")
    default ResponseEntity<List<PostSpacecraftDto>> getSpacecraftByName(@PathVariable String name){
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }


    @RequestMapping(
            method = RequestMethod.POST,
            value = "/addSpacecraft",
            produces = "application/json",
            consumes = "application/json" )
    default ResponseEntity<?> postSpacecraft(@RequestBody(required = true) PostSpacecraftDto dto){
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }

    @RequestMapping(
            method = RequestMethod.DELETE,
            value = "/deleteSpacecraft/id/{id}",
            produces = "application/json",
            consumes = "application/json" )
    default ResponseEntity<?> deleteSpacecraft(@PathVariable Long id){
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }
    @RequestMapping(
            method = RequestMethod.PATCH,
            value = "/updatespacecraft",
            produces = "application/json",
            consumes = "application/json" )
    default ResponseEntity<?> upateSpacecraft(@RequestBody(required = true) PatchSpacecraftDTO dto){
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }

}
