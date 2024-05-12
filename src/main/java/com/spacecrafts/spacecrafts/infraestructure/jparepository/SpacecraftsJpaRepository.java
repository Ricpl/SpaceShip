package com.spacecrafts.spacecrafts.infraestructure.jparepository;

import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.domain.Pageable;

import java.util.List;

@Repository
public interface SpacecraftsJpaRepository extends JpaRepository<SpacecraftDB, Long> {
    Page<SpacecraftDB> findAll(Pageable pageRequest);

    List<SpacecraftDB> findByNameIsContaining(String name);


}
