package com.wewanderdust.wewanderdust.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CityDTO {
    private Long id;
    private String name;
    private Long countryId;
}

