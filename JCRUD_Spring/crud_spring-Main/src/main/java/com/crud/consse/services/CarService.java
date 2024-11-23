package com.crud.consse.services;
import com.crud.consse.domain.dto.CarDto;
import com.crud.consse.domain.entities.CarEntity;
import com.crud.consse.domain.entities.ServiceEntity;
import org.springframework.http.ResponseEntity;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Optional;
import java.util.Set;


public interface CarService {
    public String createCar(CarEntity carEntity);
    public String getCars();
    public Optional<CarEntity> updateCar(long id,CarEntity carEntity);
    public String deleteCar(long id);
    public void createServiceCar(Long idCar,CarDto carDto);
}
