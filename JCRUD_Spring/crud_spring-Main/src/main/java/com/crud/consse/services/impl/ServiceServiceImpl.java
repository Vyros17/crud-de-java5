package com.crud.consse.services.impl;

import com.crud.consse.domain.dto.ServiceDto;
import com.crud.consse.domain.entities.CarEntity;
import com.crud.consse.domain.entities.Car_ServiceEntity;
import com.crud.consse.domain.entities.ServiceEntity;
import com.crud.consse.mappers.impl.CarMapper;
import com.crud.consse.repositories.CarRepositories;
import com.crud.consse.repositories.Car_ServiceRepositories;
import com.crud.consse.repositories.ServiceRepositories;
import com.crud.consse.services.ServiceService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ServiceServiceImpl implements ServiceService {
    private CarRepositories carRepositories;
    private ServiceRepositories serviceRepositories;
    private Car_ServiceRepositories carServiceRepositories;

    public ServiceServiceImpl(CarRepositories carRepositories, ServiceRepositories serviceRepositories, Car_ServiceRepositories carServiceRepositories, CarMapper carMapper){
        this.carRepositories = carRepositories;
        this.serviceRepositories = serviceRepositories;
        this.carServiceRepositories = carServiceRepositories;
    }

    @Override
    public String getServices() {
        final StringBuilder[] sb = {new StringBuilder()};
        Iterable<ServiceEntity> services = serviceRepositories.findAll();
        services.forEach(e -> {
            sb[0].append("***SERVICIO***");
            sb[0].append(String.format("\n-------------------------------\n*ID:%d\n*Tipo de Servicio:%s\n",e.getId(),e.getService_type()));
            sb[0].append("***AUTOS***\n");
            sb[0] = getCarService(sb[0],e);
        });
        return sb[0].toString();
    }

    public StringBuilder getCarService(StringBuilder sb, ServiceEntity service){
        Iterable<Car_ServiceEntity> cars_services = carServiceRepositories.findAll();
        cars_services.forEach(e -> {
            if(service.getId()==e.getId_service()){
                CarEntity car = carRepositories.findById(e.getId_car()).get();
                sb.append(String.format("-------------------------------\n*ID:%d\n*Placa:%s\n",car.getId(),car.getPlate()));
            }
        });
        return sb;
    }

    @Override
    public String createService(ServiceEntity serviceEntity) {
        serviceRepositories.save(serviceEntity);
        return "Servicio Creado";
    }

    @Override
    public Optional<ServiceEntity> updateService(long id, ServiceEntity serviceEntity) {
        Optional<ServiceEntity> foundService = serviceRepositories.findById(id);
        if(foundService.isPresent()){
            foundService.get().setService_type(serviceEntity.getService_type());
            serviceRepositories.save(foundService.get());
            return foundService;
        }
        return Optional.empty();
    }

    @Override
    public String deleteService(long id) {
        serviceRepositories.deleteById(id);
        return "Servicio Eliminado";
    }

    @Override
    public void createCarService(Long idService, ServiceDto serviceDto) {
        Car_ServiceEntity serviceCar = new Car_ServiceEntity();
        serviceCar.setId_service(idService);
        serviceDto.getCars().forEach(serviceCar::setId_car);
        carServiceRepositories.save(serviceCar);
    }


}
