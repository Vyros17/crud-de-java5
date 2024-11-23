package com.crud.consse.mappers.impl;

import com.crud.consse.domain.dto.ColorDto;
import com.crud.consse.domain.entities.ColorEntity;
import com.crud.consse.mappers.Mapper;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class ColorMapper implements Mapper<ColorEntity, ColorDto> {

    private ModelMapper modelMapper;
    public ColorMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    @Override
    public ColorDto mapTo(ColorEntity colorEntity) {
        return modelMapper.map(colorEntity, ColorDto.class);
    }

    @Override
    public ColorEntity mapFrom(ColorDto colorDto) {
        return modelMapper.map(colorDto, ColorEntity.class);
    }
}
