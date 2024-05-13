package com.spacecrafts.spacecrafts.controller.dto;

import jakarta.validation.constraints.NotBlank;

public class PatchSpacecraftDTO {
    @NotBlank
    private Long id;
    @NotBlank
    private String name;
    @NotBlank
    private String film;
    @NotBlank
    private String description;

    public PatchSpacecraftDTO() {
    }

    public @NotBlank Long getId() {
        return id;
    }

    public void setId(@NotBlank Long id) {
        this.id = id;
    }

    public @NotBlank String getName() {
        return name;
    }

    public void setName(@NotBlank String name) {
        this.name = name;
    }

    public @NotBlank String getFilm() {
        return film;
    }

    public void setFilm(@NotBlank String film) {
        this.film = film;
    }

    public @NotBlank String getDescription() {
        return description;
    }

    public void setDescription(@NotBlank String description) {
        this.description = description;
    }
}
