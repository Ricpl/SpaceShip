package com.spacecrafts.spacecrafts.domain.repository;

import com.spacecrafts.spacecrafts.domain.Spacecraft;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface SpacecraftRepository {

     Page<Spacecraft> findAll(Pageable pageable);
     Spacecraft findById(Long id);
     List<Spacecraft> findByName(String name);
     void saveSpacecraft(Spacecraft spacecraft);
     void delete(Long id);
     void update(Spacecraft spacecraft);
}
