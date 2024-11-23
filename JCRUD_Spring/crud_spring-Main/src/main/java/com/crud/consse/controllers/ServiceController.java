package com.crud.consse.controllers;

import com.crud.consse.domain.dto.CarDto;
import com.crud.consse.domain.dto.ServiceDto;
import com.crud.consse.domain.entities.CarEntity;
import com.crud.consse.domain.entities.ServiceEntity;
import com.crud.consse.mappers.impl.ServiceMapper;
import com.crud.consse.services.ServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/services")
public class ServiceController {
    private final ServiceService serviceService;
    private final ServiceMapper serviceMapper;
    @Autowired
    public ServiceController(ServiceService serviceService, ServiceMapper serviceMapper){
        this.serviceService = serviceService;
        this.serviceMapper = serviceMapper;
    }
    @GetMapping
    public String getAllServices(){
        return serviceService.getServices();
    }
    @PostMapping
    public String createService(@RequestBody ServiceDto serviceDto){
        ServiceEntity serviceEntity = serviceMapper.mapFrom(serviceDto);
        return serviceService.createService(serviceEntity);
    }
    @PutMapping("/{id}")
    public String updateService(@PathVariable long id, @RequestBody ServiceDto serviceDto){
        if(serviceDto.getCars().size()>1){
            return "ERROR: Solo es posible realizar un servicio por auto";
        }
        ServiceEntity serviceEntity = serviceMapper.mapFrom(serviceDto);
        serviceService.createCarService(id,serviceDto);
        if(!serviceService.updateService(id,serviceEntity).equals(Optional.empty())){
            return "Servicio Actualizado";
        }else{
            return "Servicio no Valido";
        }
    }
    @DeleteMapping("/{id}")
    public String deleteService(@PathVariable long id){
        return serviceService.deleteService(id);
    }
}
