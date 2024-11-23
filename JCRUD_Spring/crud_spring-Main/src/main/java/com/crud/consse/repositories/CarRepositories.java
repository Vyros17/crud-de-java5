package com.crud.consse.repositories;

import com.crud.consse.domain.entities.CarEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarRepositories extends CrudRepository<CarEntity, Long>{
}
