package com.highscope.curriculum.model;

import com.highscope.curriculum.model.common.Auditable;
import com.highscope.curriculum.model.embedded.Country;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "organizations")
@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EntityInfo extends Auditable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false, nullable = false)
    private Long id;

    @Column(name = "entity_name", nullable = false)
    private String entityName;

    @Column(name = "entity_type")
    private String entityType;

    @Column(name = "entity_level")
    private String entityLevel;

    @Column(name = "program_type")
    private String programType;

    @Column(name = "contact_name")
    private String contactName;

    @Column(name = "primary_email")
    private String primaryEmail;

    @Column(name = "primary_phone")
    private String primaryPhone;

    @Column(name = "complete_phone_number")
    private String completePhoneNumber;

    @Column(name = "address1")
    private String address1;

    @Column(name = "address2")
    private String address2;

    @Column(name = "city")
    private String city;

    @Column(name = "state_province")
    private String stateProvince;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "countryCode", column = @Column(name = "country_code")),
            @AttributeOverride(name = "label", column = @Column(name = "label")),
            @AttributeOverride(name = "value", column = @Column(name = "value"))
    })
    private Country country;

    @Column(name = "zip_code")
    private String zipCode;

//    @Column(name = "entity_status")
//    private String entityStatus;

    @Column(name = "no_of_licenses")
    private Integer noOfLicenses;

    @Column(name = "subscription_type")
    private String subscriptionType;

    @Column(name = "subscription_start_date")
    private LocalDateTime subscriptionStartDate;

    @Column(name = "subscription_expired_date")
    private LocalDateTime subscriptionExpiredDate;

    @Column(name = "hs_uuid")
    private UUID hsUuid;

    @Column(name = "hs_id")
    private Integer hsId;

    @Column(name = "hs_unique_id")
    private String hsUniqueId;

    @Builder.Default
    @Column(name = "is_deleted")
    private Boolean isDeleted = false;

    @Builder.Default
    @Column(name = "has_service_centers")
    private boolean hasServiceCenters = false;

    @Builder.Default
    @OneToMany(mappedBy = "entity", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ServiceCenter> serviceCenters = new ArrayList<>();
}
