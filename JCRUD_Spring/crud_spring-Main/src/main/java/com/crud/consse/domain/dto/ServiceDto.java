package com.crud.consse.domain.dto;

import com.crud.consse.domain.entities.CarEntity;
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
public class ServiceDto{
    private long id;
    private String service_type;
    private Set<Long> cars;
}