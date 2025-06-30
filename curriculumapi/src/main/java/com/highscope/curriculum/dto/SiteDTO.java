package com.highscope.curriculum.dto;

import com.highscope.curriculum.model.embedded.Country;
import com.highscope.curriculum.model.embedded.Timezone;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.time.LocalTime;
import java.util.UUID;

import static io.swagger.v3.oas.annotations.media.Schema.AccessMode.READ_ONLY;

@Data
public class SiteDTO {
    @Schema(accessMode = READ_ONLY)
    private UUID id;
    private String siteName;
    private Long entityId;
    private String contactName;
    private String contactCity;
    private String contactState;
    private String contactPhone;
    private String contactEmail;
    private String address;
    private String zipCode;
    private Country country;
    private Timezone timezone;
    private LocalTime startTime;
    private LocalTime endTime;
    private Boolean isDeleted;
}
