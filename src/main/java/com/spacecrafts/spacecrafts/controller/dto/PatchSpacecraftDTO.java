package com.spacecrafts.spacecrafts.controller.dto;



public class PatchSpacecraftDTO {
    private int id;
    private String name;
    private String film;
    private String description;

    public PatchSpacecraftDTO() {
    }

    public PatchSpacecraftDTO(int id, String name, String film, String description) {
        this.id = id;
        this.name = name;
        this.film = film;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

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
