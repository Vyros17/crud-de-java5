package com.crud.consse.services;


import com.crud.consse.domain.dto.ServiceDto;
import com.crud.consse.domain.entities.ServiceEntity;

import java.util.Optional;

public interface ServiceService {
    public String getServices();
    public String createService(ServiceEntity serviceEntity);
    public Optional<ServiceEntity> updateService(long id,ServiceEntity serviceEntity);
    public String deleteService(long id);
    public void createCarService(Long idService, ServiceDto serviceDto);
}
