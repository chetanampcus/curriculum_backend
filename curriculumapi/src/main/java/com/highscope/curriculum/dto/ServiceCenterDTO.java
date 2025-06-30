package com.highscope.curriculum.dto;

import lombok.Data;

@Data
public class ServiceCenterDTO {
    private String serviceName;
    private Integer noOfLicenses;
    private String subscriptionType;
    private String subscriptionStartDate;
    private String subscriptionExpiredDate;
}