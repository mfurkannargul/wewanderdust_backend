package com.wewanderdust.wewanderdust.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;

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

    @NotBlank(message = "Title is mandatory")
    @Size(max = 255, message = "Title must not exceed 255 characters")
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

    @CreatedDate
    @Temporal(TemporalType.TIMESTAMP)
    @Column(nullable = false, updatable = false)
    private Date createdAt;
}
