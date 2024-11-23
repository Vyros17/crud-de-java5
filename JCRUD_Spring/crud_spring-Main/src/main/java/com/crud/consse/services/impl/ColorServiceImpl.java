package com.crud.consse.services.impl;

import com.crud.consse.domain.entities.ColorEntity;
import com.crud.consse.repositories.ColorRepositories;
import com.crud.consse.services.ColorService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ColorServiceImpl implements ColorService {
    private ColorRepositories colorRepositories;
    public ColorServiceImpl(ColorRepositories colorRepositories){
        this.colorRepositories = colorRepositories;
    }
    @Override
    public String getColors() {
        StringBuilder sb = new StringBuilder();
        Iterable<ColorEntity> colors = colorRepositories.findAll();
        colors.forEach(e -> {
            sb.append(String.format("-------------------------------\n*ID:%d\n*Color:%s\n-------------------------------",e.getId(),e.getColor()));
        });
        return sb.toString();
    }

    @Override
    public ColorEntity createColor(ColorEntity colorEntity) {
        return colorRepositories.save(colorEntity);
    }

    @Override
    public Optional<ColorEntity> updateColor(long id, ColorEntity colorEntity) {
        Optional<ColorEntity> foundColor = colorRepositories.findById(id);
        if(foundColor.isPresent()){
            foundColor.get().setColor(colorEntity.getColor());
            colorRepositories.save(foundColor.get());
            return foundColor;
        }
        return Optional.empty();
    }

    @Override
    public String deleteColor(long id) {
        colorRepositories.deleteById(id);
        return "Color Eliminado";
    }
}
