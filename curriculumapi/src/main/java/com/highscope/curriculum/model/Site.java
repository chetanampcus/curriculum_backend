package com.highscope.curriculum.model;

import com.highscope.curriculum.model.embedded.Country;
import com.highscope.curriculum.model.embedded.Timezone;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalTime;
import java.util.UUID;

@Entity
@Table(name = "sites")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Site {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private UUID id;

    @Column(name = "site_name", nullable = false)
    private String siteName;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "entity_id", nullable = false)
    private EntityInfo entity;

    @Column(name = "contact_name")
    private String contactName;

    @Column(name = "contact_city")
    private String contactCity;

    @Column(name = "contact_state")
    private String contactState;

    @Column(name = "contact_phone")
    private String contactPhone;

    @Column(name = "contact_email")
    private String contactEmail;

    @Column(name = "address")
    private String address;

    @Column(name = "zip_code")
    private String zipCode;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "label", column = @Column(name = "country_label")),
            @AttributeOverride(name = "value", column = @Column(name = "country_value")),
            @AttributeOverride(name = "countryCode", column = @Column(name = "country_code"))
    })
    private Country country;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "label", column = @Column(name = "timezone_label")),
            @AttributeOverride(name = "value", column = @Column(name = "timezone_value"))
    })
    private Timezone timezone;

    @Column(name = "start_time")
    private LocalTime startTime;

    @Column(name = "end_time")
    private LocalTime endTime;

    @Builder.Default
    @Column(name = "is_deleted")
    private Boolean isDeleted = false;
}
