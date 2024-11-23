package com.crud.consse.domain.dto;

import com.crud.consse.domain.entities.ColorEntity;
import com.crud.consse.domain.entities.ServiceEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CarDto {
    private long id;
    private String plate;
    private String model;
    private String brand;
    private ColorEntity color;
    private float speed;
    private Set<Long> services;
}
