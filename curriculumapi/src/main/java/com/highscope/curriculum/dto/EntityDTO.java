package com.highscope.curriculum.dto;

import com.highscope.curriculum.model.embedded.Country;
import lombok.Data;

import java.util.List;
import java.util.UUID;

@Data
public class EntityDTO {
    private String orgEntityName;
    private String orgEntityType;
    private String orgEntityLevel;
    private String programType;
    private String orgProgramType;

    private String contactName;
    private String contactEmail;
    private String contactPhone;

    private String address1;
    private String address2;
    private String city;
    private String state;
    private String zipCode;

    private Country country;

    private String subscriptionType;
    private String subscriptionStartDate;
    private String subscriptionExpiredDate;
    private Integer noOfLicenses;

    private UUID hsUuid;
    private Integer hsId;
    private String hsUniqueId;
    private Long hsUserId;

    private Integer isDeleted;

    private String createdBy;
    private String createdById;

    private boolean hasServiceCenters;
    private List<ServiceCenterDTO> serviceCenters;
}
