package com.example.starwars.service;

import com.example.starwars.domain.Planet;
import com.example.starwars.repository.PlanetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PlanetService {
    @Autowired
    private PlanetRepository planetRepository;

    public Planet savePlanet(Planet planet) {
        return planetRepository.save(planet);
    }

    public List<Planet> findAll() {
        return planetRepository.findAll();
    }

    public List<Planet> findPlanetByNames(List<String> planetName) {
        return planetRepository.findByNameIn(planetName);
    }

    public List<Planet> findPlanetByName(String planetName) {
       return planetRepository.findByName(planetName);
    }

    public Planet findPlanetById(Long planetId) {
        Optional<Planet> planetOptional = planetRepository.findById(planetId);
        return planetOptional.orElseThrow(() -> new RuntimeException("Planeta nao encontrado"));
    }

    public void deletePlanet(Long planetId) {
        planetRepository.deleteById(planetId);
    }
}
