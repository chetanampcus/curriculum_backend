package com.highscope.curriculum.service;

import com.highscope.curriculum.dto.ApiResponse;
import com.highscope.curriculum.dto.SiteDTO;

import java.util.List;
import java.util.UUID;

public interface SiteService {
    ApiResponse<SiteDTO> createSite(SiteDTO dto);
    ApiResponse<SiteDTO> updateSite(UUID id, SiteDTO dto);
    ApiResponse<SiteDTO> getSiteById(UUID id);
    ApiResponse<List<SiteDTO>> getAllSites();
    ApiResponse<Void> deleteSite(UUID id);
}
