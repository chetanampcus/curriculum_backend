package com.highscope.curriculum.service.impl;

import com.highscope.curriculum.dto.EntityDTO;
import com.highscope.curriculum.model.EntityInfo;
import com.highscope.curriculum.model.ServiceCenter;
import com.highscope.curriculum.repository.EntityInfoRepository;
import com.highscope.curriculum.service.EntityService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class EntityServiceImpl implements EntityService {

    private final EntityInfoRepository entityRepo;

    @Override
    public EntityInfo createEntity(EntityDTO entityDTO) {
        System.out.println("Creating entity with DTO: " + entityDTO);
        EntityInfo entity = EntityInfo.builder()
                .entityName(entityDTO.getOrgEntityName())
                .entityType(entityDTO.getOrgEntityType())
                .entityLevel(entityDTO.getOrgEntityLevel())
                .programType(entityDTO.getProgramType())
                .contactName(entityDTO.getContactName())
                .primaryEmail(entityDTO.getContactEmail())
                .primaryPhone(entityDTO.getContactPhone())
                .completePhoneNumber(entityDTO.getCountry().getCountryCode() + entityDTO.getContactPhone())
                .address1(entityDTO.getAddress1())
                .address2(entityDTO.getAddress2())
                .city(entityDTO.getCity())
                .stateProvince(entityDTO.getState())
                .country(entityDTO.getCountry())
                .zipCode(entityDTO.getZipCode())
                .noOfLicenses(entityDTO.getNoOfLicenses())
                .subscriptionType(entityDTO.getSubscriptionType())
                .subscriptionStartDate(LocalDateTime.parse(entityDTO.getSubscriptionStartDate()))
                .subscriptionExpiredDate(LocalDateTime.parse(entityDTO.getSubscriptionExpiredDate()))
                .hsUuid(entityDTO.getHsUuid())
                .hsId(entityDTO.getHsId())
                .hsUniqueId(entityDTO.getHsUniqueId())
                .isDeleted(false)
                .hasServiceCenters(entityDTO.isHasServiceCenters())
                .build();

        entity.setCreatedBy(String.valueOf(entityDTO.getHsUserId()));
        entity.setCreatedDate(LocalDateTime.now());

        if (entityDTO.isHasServiceCenters() && entityDTO.getServiceCenters() != null) {
            entityDTO.getServiceCenters().forEach(scDTO -> {
                ServiceCenter sc = ServiceCenter.builder()
                        .serviceName(scDTO.getServiceName())
                        .noOfLicenses(scDTO.getNoOfLicenses())
                        .subscriptionType(scDTO.getSubscriptionType())
                        .subscriptionStartDate(LocalDateTime.parse(scDTO.getSubscriptionStartDate()))
                        .subscriptionExpiredDate(LocalDateTime.parse(scDTO.getSubscriptionExpiredDate()))
                        .entity(entity)
                        .isDeleted(false)
                        .build();

                sc.setCreatedBy(String.valueOf(entityDTO.getHsUserId()));
                sc.setCreatedDate(LocalDateTime.now());

                entity.getServiceCenters().add(sc);
            });
        }

        return entityRepo.save(entity);
    }
}
