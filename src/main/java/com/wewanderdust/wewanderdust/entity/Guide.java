package com.wewanderdust.wewanderdust.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Table(name = "guides")
@Data // Lombok ile otomatik getter, setter, toString, equals, hashCode
@NoArgsConstructor // Parametresiz constructor
@AllArgsConstructor // Tum alanlari iceren constructor
public class Guide {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    @ManyToOne
    @JoinColumn(name = "country_id", nullable = false)
    private Country country;

    @ManyToOne
    @JoinColumn(name = "city_id", nullable = false)
    private City city;

    @Column(columnDefinition = "TEXT")
    private String attractions;

    @Column(columnDefinition = "TEXT")
    private String activities;

    @Column(columnDefinition = "TEXT")
    private String thingsToKnow;

    @Column(columnDefinition = "TEXT")
    private String visaRequirements;

    @Column(columnDefinition = "TEXT")
    private String transportation;

    @Column(columnDefinition = "TEXT")
    private String moneyAndCosts;

    @Column(columnDefinition = "TEXT")
    private String bestRoutes;

    @Column(columnDefinition = "TEXT")
    private String localFood;

    @Column(columnDefinition = "TEXT")
    private String photoSpots;

    @ManyToOne
    @JoinColumn(name = "created_by", nullable = true)
    private User createdBy;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(nullable = false, updatable = false)
    private Date createdAt = new Date();

}
