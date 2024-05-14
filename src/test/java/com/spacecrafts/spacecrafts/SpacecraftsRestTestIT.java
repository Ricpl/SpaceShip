package com.spacecrafts.spacecrafts;

import com.spacecrafts.spacecrafts.controller.dto.SpacecraftDto;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest(webEnvironment =  SpringBootTest.WebEnvironment.RANDOM_PORT)
public class SpacecraftsRestTestIT {
    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate template;

    final int CORRECT_ID= 1;
    final String ASSOCIATE_FILM="Star Wars";


    @Test
    void testGetByIdOK()  throws URISyntaxException {
        String baseUrl = "http://localhost:"+port+"/spacecraft/id/"+ CORRECT_ID;
        URI uri =new URI(baseUrl);

        ResponseEntity<SpacecraftDto> response=this.template.getForEntity(uri,SpacecraftDto.class);
        assertNotNull(response.getBody());
        assertEquals(ASSOCIATE_FILM, response.getBody().getFilm());
    }

    @ParameterizedTest
    @MethodSource("argumentToTestGetById")
    void testGetByIdKO(int id, HttpStatus expected) throws URISyntaxException {
        String baseUrl = "http://localhost:"+port+"/spacecraft/id/"+ id;
        URI uri =new URI(baseUrl);

        ResponseEntity<?> response=this.template.getForEntity(uri,String.class);
        assertEquals(expected, response.getStatusCode());
        assertEquals(expected, response.getStatusCode());
    }

    static Stream<Arguments> argumentToTestGetById(){
        return Stream.of(
                Arguments.of(-1, HttpStatus.BAD_REQUEST),
                Arguments.of(15, HttpStatus.NOT_FOUND));
    }


    @ParameterizedTest
    @MethodSource("argumentToTestPost")
    void testPost(String description, String film, String name, HttpStatus expected)throws URISyntaxException{
        String baseUrl = "http://localhost:"+port+"/addSpacecraft";
        URI uri =new URI(baseUrl);

        SpacecraftDto request= new SpacecraftDto(description,film,name);

        ResponseEntity<?> response=this.template.postForEntity(uri,request,String.class);
        assertEquals(expected, response.getStatusCode());

    }
    static Stream<Arguments> argumentToTestPost(){
        return Stream.of(
                Arguments.of("Descrption","Film","name", HttpStatus.OK),
                Arguments.of("Descrption",null,"name", HttpStatus.BAD_REQUEST),
                Arguments.of("Descrption","","name", HttpStatus.BAD_REQUEST));
    }

    @ParameterizedTest
    @MethodSource("argumentToTestDelete")
    void testDelete(int id, HttpStatus expected)throws URISyntaxException{
        String baseUrl = "http://localhost:"+port+"/deleteSpacecraft/id/"+ id;
        URI uri =new URI(baseUrl);


        ResponseEntity<?> response=this.template.exchange(uri,HttpMethod.DELETE,new HttpEntity<>(""),String.class);
        assertEquals(expected, response.getStatusCode());
    }
    static Stream<Arguments> argumentToTestDelete(){
        return Stream.of(
                Arguments.of(1, HttpStatus.OK),
                Arguments.of(-1, HttpStatus.BAD_REQUEST),
                Arguments.of(15, HttpStatus.NOT_FOUND));
    }

}
