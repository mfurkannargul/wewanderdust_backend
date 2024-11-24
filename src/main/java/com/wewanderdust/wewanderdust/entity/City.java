package com.wewanderdust.wewanderdust.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "guides")
@Data // Lombok ile otomatik getter, setter, toString, equals, hashCode
@NoArgsConstructor // Parametresiz constructor
@AllArgsConstructor // Tum alanlari iceren constructor
public class City {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @ManyToOne
    @JoinColumn(name = "country_id", nullable = false)
    private Country country;

}
