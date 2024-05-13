package com.spacecrafts.spacecrafts.infraestructure.repository;

import com.spacecrafts.spacecrafts.domain.Spacecraft;
import com.spacecrafts.spacecrafts.domain.exception.repository.RepositoryErrorEnum;
import com.spacecrafts.spacecrafts.domain.exception.repository.RespositoryException;
import com.spacecrafts.spacecrafts.domain.repository.SpacecraftRepository;
import com.spacecrafts.spacecrafts.infraestructure.jparepository.SpacecraftDB;
import com.spacecrafts.spacecrafts.infraestructure.jparepository.SpacecraftsJpaRepository;
import com.spacecrafts.spacecrafts.infraestructure.mapper.SpacecraftDbMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Component
public class SpacecraftRepositoryImpl implements SpacecraftRepository {
    @Autowired
    private SpacecraftsJpaRepository repository;
    @Autowired
    private SpacecraftDbMapper mapper;
    @Autowired
    CacheManager cacheManager;

    @Override
    @Cacheable(value = "get-spacecraft-by-id")
    public Spacecraft findById(Long id) {
        Optional<SpacecraftDB> optional= this.repository.findById(id);
        if (!optional.isPresent()){
            throw new RespositoryException(RepositoryErrorEnum.NOT_FOUND_ID);
        }
        return this.mapper.fromDBtoDomain(optional.get());
    }

    @Override
    public List<Spacecraft> findByName(String name) {
        List<SpacecraftDB> list= this.repository.findByNameIsContaining(name);
        if (list.isEmpty()){
            throw new RespositoryException(RepositoryErrorEnum.NOT_FOUND_NAME);
        }
        return this.mapper.fromDBtoDomainList(list);

    }

    @Override
    public Page<Spacecraft> findAll(Pageable pageable) {
        Page<SpacecraftDB> allSpaceCraftsDB = this.repository.findAll(pageable);
        return allSpaceCraftsDB.map(spacecraftDB-> this.mapper.fromDBtoDomain(spacecraftDB));
    }

    @Override
    public void saveSpacecraft(Spacecraft spacecraft) {
        this.repository.save(this.mapper.fromDomainToDB(spacecraft));
    }

    @Override
    public void delete(Long id) {
        if (this.repository.findById(id).isEmpty()){
            throw new RespositoryException(RepositoryErrorEnum.NOT_FOUND_ID);
        }
        Objects.requireNonNull(this.cacheManager.getCache("get-spacecraft-by-id")).clear();
        this.repository.deleteById(id);
    }

    @Override
    public void update(Spacecraft spacecraft) {
        Optional<SpacecraftDB> spacecraftToUpdate= this.repository.findById(spacecraft.getId());
        if (spacecraftToUpdate.isEmpty()){
            throw new RespositoryException(RepositoryErrorEnum.NOT_FOUND_ID);
        }
        if (spacecraft.getName()!=null && !spacecraft.getName().isBlank()){
            spacecraftToUpdate.get().setName(spacecraft.getName());
        }
        if (spacecraft.getFilm()!=null && !spacecraft.getFilm().isBlank()){
            spacecraftToUpdate.get().setFilm(spacecraft.getFilm());
        }
        if (spacecraft.getDescription()!=null && !spacecraft.getDescription().isBlank()){
            spacecraftToUpdate.get().setDescription(spacecraft.getDescription());
        }
        Objects.requireNonNull(this.cacheManager.getCache("get-spacecraft-by-id")).clear();
        this.repository.save(spacecraftToUpdate.get());

    }
}
