package com.crud.consse.services.impl;

import com.crud.consse.domain.dto.CarDto;
import com.crud.consse.domain.entities.Car_ServiceEntity;
import com.crud.consse.domain.entities.ServiceEntity;
import com.crud.consse.mappers.impl.CarMapper;
import com.crud.consse.repositories.CarRepositories;
import com.crud.consse.repositories.Car_ServiceRepositories;
import com.crud.consse.repositories.ServiceRepositories;
import org.springframework.stereotype.Service;
import com.crud.consse.domain.entities.CarEntity;
import com.crud.consse.services.CarService;
import org.springframework.dao.DataIntegrityViolationException;

import java.util.*;


@Service
public class CarServiceImpl implements CarService {
    private CarRepositories carRepositories;
    private ServiceRepositories serviceRepositories;
    private Car_ServiceRepositories carServiceRepositories;

    public CarServiceImpl(CarRepositories carRepositories,ServiceRepositories serviceRepositories, Car_ServiceRepositories carServiceRepositories,CarMapper carMapper){
        this.carRepositories = carRepositories;
        this.serviceRepositories = serviceRepositories;
        this.carServiceRepositories = carServiceRepositories;
    }

    @Override
    public String createCar(CarEntity carEntity) {
            carRepositories.save(carEntity);
            return "Auto Agregado";
    }

    @Override
    public String getCars() {
        final StringBuilder[] sb = {new StringBuilder()};
        Iterable<CarEntity> cars = carRepositories.findAll();
        cars.forEach(e -> {
            sb[0].append("***AUTO***\n");
            sb[0].append(String.format("-------------------------------\n*ID:%d\n*Placa:%s\n*Modelo:%s\n*Marca:%s\n*ID del color:%d\n*Color:%s\n*Velocidad:%.2f\n"
                    ,e.getId(),e.getPlate(),e.getModel(),e.getBrand(),e.getColor().getId(),e.getColor().getColor(),e.getSpeed()));
            sb[0].append("***SERVICIOS***\n");
            sb[0] = getServiceCar(sb[0],e);
        });
        sb[0].append("-------------------------------");
        return sb[0].toString();
    }
    public StringBuilder getServiceCar(StringBuilder sb, CarEntity car){
        Iterable<Car_ServiceEntity> cars_services = carServiceRepositories.findAll();
        cars_services.forEach(e -> {
            if(car.getId()==e.getId_car()){
                ServiceEntity service = serviceRepositories.findById(e.getId_service()).get();
                sb.append(String.format("-------------------------------\n-ID del Servicio:%d\n-Tipo de Servicio:%s\n",service.getId(),service.getService_type()));
            }
        });
        return sb;
    }

    @Override
    public Optional<CarEntity> updateCar(long id, CarEntity carEntity) {
        Optional<CarEntity> foundCar = carRepositories.findById(id);
        if(foundCar.isPresent()){
            foundCar.get().setPlate(carEntity.getPlate());
            foundCar.get().setModel(carEntity.getModel());
            foundCar.get().setBrand(carEntity.getBrand());
            foundCar.get().setColor(carEntity.getColor());
            foundCar.get().setSpeed(carEntity.getSpeed());
            carRepositories.save(foundCar.get());
            return foundCar;
        }
        return Optional.empty();
    }

    @Override
    public String deleteCar(long id) {
        carRepositories.deleteById(id);
        return "Auto Eliminado";
    }

    @Override
    public void createServiceCar(Long idCar,CarDto carDto) {
        Car_ServiceEntity carService = new Car_ServiceEntity();
        carService.setId_car(idCar);
        carDto.getServices().forEach(carService::setId_service);
        carServiceRepositories.save(carService);
    }
}
