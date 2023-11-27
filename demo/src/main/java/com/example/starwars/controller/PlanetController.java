package com.example.starwars.controller;

import com.example.starwars.domain.Planet;
import com.example.starwars.service.PlanetService;
import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("api/v1/planets")
public class PlanetController {
    @Autowired
    private PlanetService planetService;

    @PostMapping
    public Planet saveDepartment(@RequestBody Planet department) {
        // Retorna status 201 - Created
        return planetService.savePlanet(department);
    }

    @GetMapping
    public ResponseEntity<List<Planet>> findAll(@RequestParam(required = false, name = "name") String name) {

        List<String> planetNames = Strings.isNotBlank(name) ? List.of(name.split(",")) : Collections.emptyList();

        if(planetNames.size() == 1) {
            return ResponseEntity.status(HttpStatus.OK).body(planetService.findPlanetByName(planetNames.get(0)));
        } else if(planetNames.size() > 1){
            return ResponseEntity.status(HttpStatus.OK).body(planetService.findPlanetByNames(planetNames));
        }

        return ResponseEntity.status(HttpStatus.OK).body(planetService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Planet> findById(@PathVariable("id") Long planetId) {
        return ResponseEntity.status(HttpStatus.OK).body(planetService.findPlanetById(planetId));
    }

    @DeleteMapping("/{id}")
    public String deleteDepartmentById(@PathVariable("id") Long planetId) {
        planetService.deletePlanet(planetId);
        return "Deleted Successfully";
    }
}
