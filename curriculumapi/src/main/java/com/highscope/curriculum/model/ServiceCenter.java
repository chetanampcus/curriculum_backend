package com.highscope.curriculum.model;

import com.highscope.curriculum.model.common.Auditable;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "service_centers")
@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ServiceCenter extends Auditable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false, nullable = false)
    private Long id;

    @Column(name = "hs_id")
    private Integer hsId;

    @Column(name = "service_name", nullable = false)
    private String serviceName;

    @Column(name = "no_of_licenses")
    private Integer noOfLicenses;

    @Builder.Default
    @Column(name = "is_deleted")
    private Boolean isDeleted = false;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "entity_id", referencedColumnName = "id", nullable = false)
    private EntityInfo entity;

    @Column(name = "subscription_type")
    private String subscriptionType;

    @Column(name = "subscription_start_date")
    private LocalDateTime subscriptionStartDate;

    @Column(name = "subscription_expired_date")
    private LocalDateTime subscriptionExpiredDate;

}
