package com.crud.consse.mappers.impl;

import com.crud.consse.domain.dto.ColorDto;
import com.crud.consse.domain.dto.ServiceDto;
import com.crud.consse.domain.entities.ColorEntity;
import com.crud.consse.domain.entities.ServiceEntity;
import com.crud.consse.mappers.Mapper;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class ServiceMapper implements Mapper<ServiceEntity, ServiceDto> {

    private ModelMapper modelMapper;

    public ServiceMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    @Override
    public ServiceDto mapTo(ServiceEntity serviceEntity) {
        return modelMapper.map(serviceEntity, ServiceDto.class);
    }

    @Override
    public ServiceEntity mapFrom(ServiceDto serviceDto) {
        return modelMapper.map(serviceDto, ServiceEntity.class);
    }
}
