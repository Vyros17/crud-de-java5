package com.crud.consse.services;

import com.crud.consse.domain.entities.ColorEntity;

import java.util.Optional;

public interface ColorService {
    public String getColors();
    public ColorEntity createColor(ColorEntity colorEntity);
    public Optional<ColorEntity> updateColor(long id, ColorEntity colorEntity);
    public String deleteColor(long id);
}
