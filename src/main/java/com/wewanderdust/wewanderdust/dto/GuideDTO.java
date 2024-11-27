package com.wewanderdust.wewanderdust.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GuideDTO {
    private Long id;
    private String title;
    private Long countryId;
    private Long cityId;
    private String attractions;
    private String activities;
    private String thingsToKnow;
    private String visaRequirements;
    private String transportation;
    private String moneyAndCosts;
    private String bestRoutes;
    private String localFood;
    private String photoSpots;
    private Long createdBy;
    private String createdAt;
}

