package com.crud.consse.controllers;

import com.crud.consse.domain.dto.CarDto;
import com.crud.consse.domain.entities.CarEntity;
import com.crud.consse.mappers.impl.CarMapper;
import com.crud.consse.services.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.Optional;



@RestController
@RequestMapping("/cars")
public class CarController {
    private final CarService carService;
    private final CarMapper carMapper;
    @Autowired
    public CarController(CarService carService, CarMapper carMapper){
        this.carService = carService;
        this.carMapper = carMapper;
    }
    @GetMapping
    public String getAllCars(){
        return carService.getCars();
    }
    @PostMapping
    public String createCar(@RequestBody final CarDto carDto){
        CarEntity carEntity = carMapper.mapFrom(carDto);
        return carService.createCar(carEntity);
    }
    @PutMapping("/{id}")
    public String updateCar(@PathVariable long id, @RequestBody CarDto carDto){
        if(carDto.getServices().size()>1){
            return "ERROR: Solo es posible realizar un servicio por auto";
        }
        CarEntity carEntity = carMapper.mapFrom(carDto);
        carService.createServiceCar(id,carDto);
        if(!carService.updateCar(id,carEntity).equals(Optional.empty())){
            return "Auto Actualizado";
        }else{
            return "Auto no Valido";
        }
    }
    @DeleteMapping("/{id}")
    public String deleteCar(@PathVariable long id){
        return carService.deleteCar(id);
    }

}
