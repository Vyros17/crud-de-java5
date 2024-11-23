package com.crud.consse.repositories;

import com.crud.consse.domain.entities.ColorEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ColorRepositories extends CrudRepository<ColorEntity,Long> {
}
