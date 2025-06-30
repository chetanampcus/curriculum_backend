package com.highscope.curriculum.service.impl;

import com.highscope.curriculum.dto.ApiResponse;
import com.highscope.curriculum.dto.SiteDTO;
import com.highscope.curriculum.model.EntityInfo;
import com.highscope.curriculum.model.Site;
import com.highscope.curriculum.repository.EntityInfoRepository;
import com.highscope.curriculum.repository.SiteRepository;
import com.highscope.curriculum.service.SiteService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class SiteServiceImpl implements SiteService {
    private final SiteRepository siteRepository;
    private final EntityInfoRepository entityInfoRepository;

    @Override
    public ApiResponse<SiteDTO> createSite(SiteDTO dto) {
        EntityInfo entity = entityInfoRepository.findById(dto.getEntityId())
                .orElseThrow(() -> new EntityNotFoundException("Entity not found"));

        Site site = Site.builder()
                .siteName(dto.getSiteName())
                .entity(entity)
                .contactName(dto.getContactName())
                .contactCity(dto.getContactCity())
                .contactState(dto.getContactState())
                .contactPhone(dto.getContactPhone())
                .contactEmail(dto.getContactEmail())
                .address(dto.getAddress())
                .zipCode(dto.getZipCode())
                .country(dto.getCountry())
                .timezone(dto.getTimezone())
                .startTime(dto.getStartTime())
                .endTime(dto.getEndTime())
                .isDeleted(dto.getIsDeleted() != null ? dto.getIsDeleted() : false)
                .build();

        Site savedSite = siteRepository.save(site);

        return ApiResponse.<SiteDTO>builder()
                .status(201)
                .message("Site created successfully")
                .success(true)
                .data(mapToDTO(savedSite))
                .build();
    }

    @Override
    public ApiResponse<SiteDTO> updateSite(UUID id, SiteDTO dto) {
        Site site = siteRepository.findByIdAndIsDeletedFalse(id)
                .orElseThrow(() -> new EntityNotFoundException("Site not found or is deleted"));

        EntityInfo entity = entityInfoRepository.findById(dto.getEntityId())
                .orElseThrow(() -> new EntityNotFoundException("Entity not found"));

        site.setSiteName(dto.getSiteName());
        site.setEntity(entity);
        site.setContactName(dto.getContactName());
        site.setContactCity(dto.getContactCity());
        site.setContactState(dto.getContactState());
        site.setContactPhone(dto.getContactPhone());
        site.setContactEmail(dto.getContactEmail());
        site.setAddress(dto.getAddress());
        site.setZipCode(dto.getZipCode());
        site.setCountry(dto.getCountry());
        site.setTimezone(dto.getTimezone());
        site.setStartTime(dto.getStartTime());
        site.setEndTime(dto.getEndTime());
        site.setIsDeleted(dto.getIsDeleted());

        Site updatedSite = siteRepository.save(site);

        return ApiResponse.<SiteDTO>builder()
                .status(200)
                .message("Site updated successfully")
                .success(true)
                .data(mapToDTO(updatedSite))
                .build();
    }

    @Override
    public ApiResponse<SiteDTO> getSiteById(UUID id) {
        Site site = siteRepository.findByIdAndIsDeletedFalse(id)
                .orElseThrow(() -> new EntityNotFoundException("Site not found or is deleted"));

        return ApiResponse.<SiteDTO>builder()
                .status(200)
                .message("Site retrieved successfully")
                .success(true)
                .data(mapToDTO(site))
                .build();
    }

    @Override
    public ApiResponse<List<SiteDTO>> getAllSites() {
        List<SiteDTO> sites = siteRepository.findAllByIsDeletedFalse()
                .stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());

        return ApiResponse.<List<SiteDTO>>builder()
                .status(200)
                .message("Sites retrieved successfully")
                .success(true)
                .data(sites)
                .build();

    }

    @Override
    public ApiResponse<Void> deleteSite(UUID id) {
        Site site = siteRepository.findByIdAndIsDeletedFalse(id)
                .orElseThrow(() -> new EntityNotFoundException("Site not found or is deleted"));

        site.setIsDeleted(true);
        siteRepository.save(site);

        return ApiResponse.<Void>builder()
                .status(200)
                .message("Site deleted successfully")
                .success(true)
                .data(null)
                .build();
    }

    private SiteDTO mapToDTO(Site site) {
        SiteDTO dto = new SiteDTO();
        dto.setId(site.getId());
        dto.setSiteName(site.getSiteName());
        dto.setEntityId(site.getEntity().getId());
        dto.setContactName(site.getContactName());
        dto.setContactCity(site.getContactCity());
        dto.setContactState(site.getContactState());
        dto.setContactPhone(site.getContactPhone());
        dto.setContactEmail(site.getContactEmail());
        dto.setAddress(site.getAddress());
        dto.setZipCode(site.getZipCode());
        dto.setCountry(site.getCountry());
        dto.setTimezone(site.getTimezone());
        dto.setStartTime(site.getStartTime());
        dto.setEndTime(site.getEndTime());
        dto.setIsDeleted(site.getIsDeleted());
        return dto;
    }
}
