package com.spacecrafts.spacecrafts.infraestructure.event.payload;

public class SpacecraftKafkaPayload {
    private int id;
    private String name;
    private String film;
    private String description;

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

    @Override
    public String toString() {
        return "SpacecraftKafkaPayload{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", film='" + film + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
