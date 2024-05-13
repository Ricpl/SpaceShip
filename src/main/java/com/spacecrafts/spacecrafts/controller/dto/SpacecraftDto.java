package com.spacecrafts.spacecrafts.controller.dto;


public class SpacecraftDto {
    private String name;
    private String film;
    private String description;

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

    public SpacecraftDto() {
    }

    public SpacecraftDto(String description, String film, String name) {
        this.description = description;
        this.film = film;
        this.name = name;
    }
}
