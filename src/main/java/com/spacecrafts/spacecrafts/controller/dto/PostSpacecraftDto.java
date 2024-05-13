package com.spacecrafts.spacecrafts.controller.dto;

import jakarta.validation.constraints.NotBlank;

import java.io.Serializable;


public class PostSpacecraftDto implements Serializable {
    @NotBlank
    private String name;
    @NotBlank
    private String film;
    @NotBlank
    private String description;

    public PostSpacecraftDto(){}
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFilm() {
        return film;
    }

    public void setFilm(String film) {
        this.film = film;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
