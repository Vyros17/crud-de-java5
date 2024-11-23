package com.crud.consse.mappers.impl;

import com.crud.consse.domain.dto.CarDto;
import com.crud.consse.domain.entities.CarEntity;
import com.crud.consse.mappers.Mapper;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class CarMapper implements Mapper<CarEntity, CarDto> {

    private ModelMapper modelMapper;
    public CarMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    @Override
    public CarDto mapTo(CarEntity carEntity) {
        return modelMapper.map(carEntity, CarDto.class);
    }

    @Override
    public CarEntity mapFrom(CarDto carDto) {
        return modelMapper.map(carDto, CarEntity.class);
    }
}