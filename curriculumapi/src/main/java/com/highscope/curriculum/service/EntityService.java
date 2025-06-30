package com.highscope.curriculum.service;

import com.highscope.curriculum.dto.EntityDTO;
import com.highscope.curriculum.model.EntityInfo;
import org.springframework.stereotype.Service;

@Service
public interface EntityService {
    EntityInfo createEntity(EntityDTO request);
}
