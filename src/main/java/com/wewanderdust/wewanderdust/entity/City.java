package com.wewanderdust.wewanderdust.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "cities")
@Data // Lombok ile otomatik getter, setter, toString, equals, hashCode
@NoArgsConstructor // Parametresiz constructor
@AllArgsConstructor // Tum alanlari iceren constructor
public class City {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "City name is required")
    @Column(nullable = false, length = 100)
    private String name;

    @ManyToOne(optional = false)
    @JoinColumn(name = "country_id", nullable = false)
    @JsonBackReference // Prevents circular reference during serialization
    private Country country; // TODO: incele

}
