package com.example.starwars.repository;

import com.example.starwars.domain.Planet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PlanetRepository extends JpaRepository<Planet, Long> {
    List<Planet> findByName(String planetName);

    List<Planet> findByNameIn(List<String> names);

    List<Planet> findByClimate(String planetCimate);

}
