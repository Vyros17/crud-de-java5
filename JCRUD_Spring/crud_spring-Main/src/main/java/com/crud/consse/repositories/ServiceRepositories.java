package com.crud.consse.repositories;

import com.crud.consse.domain.entities.ServiceEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ServiceRepositories extends CrudRepository<ServiceEntity,Long> {
}
