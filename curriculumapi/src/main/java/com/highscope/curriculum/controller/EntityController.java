package com.highscope.curriculum.controller;

import com.highscope.curriculum.dto.ApiResponse;
import com.highscope.curriculum.dto.EntityDTO;
import com.highscope.curriculum.model.EntityInfo;
import com.highscope.curriculum.service.EntityService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/entity")
@RequiredArgsConstructor
public class EntityController {

    private final EntityService entityService;

    @PostMapping("/create")
    public ResponseEntity<ApiResponse<EntityInfo>> createEntity(@RequestBody EntityDTO request) {
        EntityInfo savedEntity = entityService.createEntity(request);
        ApiResponse<EntityInfo> response = ApiResponse.<EntityInfo>builder()
                .status(HttpStatus.CREATED.value())
                .message("Entity created successfully")
                .success(true)
                .data(savedEntity)
                .build();

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
}
