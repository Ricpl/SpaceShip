package com.spacecrafts.spacecrafts.infraestructure.repository;

import com.spacecrafts.spacecrafts.domain.Spacecraft;
import com.spacecrafts.spacecrafts.domain.repository.SpacecraftRepository;
import com.spacecrafts.spacecrafts.infraestructure.jparepository.SpacecraftDB;
import com.spacecrafts.spacecrafts.infraestructure.jparepository.SpacecraftsJpaRepository;
import com.spacecrafts.spacecrafts.infraestructure.mapper.SpacecraftDbMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

@Component
public class SpacecraftRepositoryImpl implements SpacecraftRepository {
    @Autowired
    private SpacecraftsJpaRepository repository;
    @Autowired
    private SpacecraftDbMapper mapper;

    @Override
    public Spacecraft findById(Long id) {
        Optional<SpacecraftDB> optional= this.repository.findById(id);
        if (optional.isPresent()){
            return this.mapper.fromDBtoDomain(optional.get());
        }else {throw new RuntimeException() ;}
    }

    @Override
    public List<Spacecraft> findByName(String name) {
        List<SpacecraftDB> list= this.repository.findByNameIsContaining(name);
        if (!list.isEmpty()){
            return this.mapper.fromDBtoDomainList(list);
        }
        throw new RuntimeException();
    }

    @Override
    public Page<Spacecraft> findAll(Pageable pageable) {
        Page<SpacecraftDB> allSpaceCraftsDB = this.repository.findAll(pageable);
        if (allSpaceCraftsDB.isEmpty()){
            return null;
        }
        return allSpaceCraftsDB.map(spacecraftDB-> this.mapper.fromDBtoDomain(spacecraftDB));
    }

    @Override
    public void saveSpacecraft(Spacecraft spacecraft) {
        this.repository.save(this.mapper.fromDomainToDB(spacecraft));
    }

    @Override
    public void delete(Long id) {
        if (this.repository.findById(id).isPresent()){
            this.repository.deleteById(id);
        }
        throw new RuntimeException();
    }

}
