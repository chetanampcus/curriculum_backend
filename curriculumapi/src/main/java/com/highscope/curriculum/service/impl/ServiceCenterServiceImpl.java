package com.highscope.curriculum.service.impl;

import com.highscope.curriculum.model.ServiceCenter;
import com.highscope.curriculum.repository.ServiceCenterRepository;
import com.highscope.curriculum.service.ServiceCenterService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ServiceCenterServiceImpl implements ServiceCenterService {
    private final ServiceCenterRepository serviceCenterRepository;

    @Override
    public ServiceCenter save(ServiceCenter serviceCenter) {
        return serviceCenterRepository.save(serviceCenter);
    }
}