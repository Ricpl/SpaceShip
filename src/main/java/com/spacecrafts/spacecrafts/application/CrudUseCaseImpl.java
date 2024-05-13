package com.spacecrafts.spacecrafts.application;

import com.spacecrafts.spacecrafts.domain.application.CrudUseCase;
import com.spacecrafts.spacecrafts.domain.Spacecraft;
import com.spacecrafts.spacecrafts.domain.repository.SpacecraftRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;
import org.springframework.data.domain.Pageable;

import java.util.List;

@Component
public class CrudUseCaseImpl implements CrudUseCase {
    @Autowired
    SpacecraftRepository repository;

    @Override
    public Page<Spacecraft> getAllSpaceCraft(Pageable pageable) {
        return this.repository.findAll(pageable);
    }

    @Override
    public Spacecraft getSpacecraftById(long id) {
        return this.repository.findById(id);
    }

    @Override
    public List<Spacecraft> getSpacecraftByName(String name) {
        return this.repository.findByName(name);
    }

    @Override
    public void postSpacecraft(Spacecraft spacecraft){
        this.repository.saveSpacecraft(spacecraft);
    }

    @Override
    public void deleteSpacecrat(Long id) {
        this.repository.delete(id);
    }


    @Override
    public void patchSpacecraft(Spacecraft spacecraft) {
        this.repository.update(spacecraft);
    }
}
