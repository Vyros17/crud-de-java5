package com.crud.consse.repositories;


import com.crud.consse.domain.entities.Car_ServiceEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Car_ServiceRepositories extends CrudRepository<Car_ServiceEntity, Long> {
}