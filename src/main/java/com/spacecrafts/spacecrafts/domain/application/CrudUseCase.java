package com.spacecrafts.spacecrafts.domain.application;

import com.spacecrafts.spacecrafts.domain.Spacecraft;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface CrudUseCase {
    Page<Spacecraft> getAllSpaceCraft(Pageable pageable);
    Spacecraft getSpacecraftById(long id);
    List<Spacecraft> getSpacecraftByName(String name);
    void postSpacecraft(Spacecraft spacecraft);
    void deleteSpacecrat(long id);
    void patchSpacecraft(Spacecraft spacecraft);

}
