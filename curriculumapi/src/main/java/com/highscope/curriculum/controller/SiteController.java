package com.highscope.curriculum.controller;

import com.highscope.curriculum.dto.ApiResponse;
import com.highscope.curriculum.dto.SiteDTO;
import com.highscope.curriculum.service.SiteService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/site")
@RequiredArgsConstructor
public class SiteController {

    private final SiteService siteService;

    @PostMapping("/create")
    public ResponseEntity<ApiResponse<SiteDTO>> createSite(@RequestBody SiteDTO dto) {
        ApiResponse<SiteDTO> response = siteService.createSite(dto);
        return ResponseEntity.status(response.getStatus()).body(response);
    }

    @PutMapping("/updateSite/{id}")
    public ResponseEntity<ApiResponse<SiteDTO>> updateSite(@PathVariable UUID id, @RequestBody SiteDTO dto) {
        ApiResponse<SiteDTO> response = siteService.updateSite(id, dto);
        return ResponseEntity.status(response.getStatus()).body(response);
    }

    @GetMapping("/getSiteById/{id}")
    public ResponseEntity<ApiResponse<SiteDTO>> getSiteById(@PathVariable UUID id) {
        ApiResponse<SiteDTO> response = siteService.getSiteById(id);
        return ResponseEntity.status(response.getStatus()).body(response);
    }

    @GetMapping("/getAllSites")
    public ResponseEntity<ApiResponse<List<SiteDTO>>> getAllSites() {
        ApiResponse<List<SiteDTO>> response = siteService.getAllSites();
        return ResponseEntity.status(response.getStatus()).body(response);
    }

    @DeleteMapping("/deleteSite/{id}")
    public ResponseEntity<ApiResponse<Void>> deleteSite(@PathVariable UUID id) {
        ApiResponse<Void> response = siteService.deleteSite(id);
        return ResponseEntity.status(response.getStatus()).body(response);
    }
}
