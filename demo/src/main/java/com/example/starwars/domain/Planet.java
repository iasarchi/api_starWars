package com.example.starwars.domain;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Planet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String name;
    @Column
    private String climate;
    @Column
    private String terrain;

}
