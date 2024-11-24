package com.wewanderdust.wewanderdust.entity;


import jakarta.persistence.*;
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

    @Column(nullable = false, unique = true)
    private String name;

    @OneToMany(mappedBy = "country", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<City> cities = new ArrayList<>();

}
