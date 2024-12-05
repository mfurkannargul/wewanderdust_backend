package com.wewanderdust.wewanderdust.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "countries")
@Data // Lombok ile Getter, Setter, toString, equals, ve hashCode metotları otomatik eklenir
@NoArgsConstructor // Parametresiz constructor otomatik oluşturulur
@AllArgsConstructor // Tum alanlari iceren constructor
public class Country {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Country name is required")
    @Column(nullable = false, unique = true, length = 100)
    private String name;

    @OneToMany(mappedBy = "country", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private List<City> cities = new ArrayList<>();
}
