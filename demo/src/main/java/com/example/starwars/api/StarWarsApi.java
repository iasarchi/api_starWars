package com.example.starwars.api;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@Slf4j
public class StarWarsApi {

    public int getApparitionsByName(String name) {
        String response = new RestTemplate().getForObject("https://swapi.dev/api/planets?search=" + name , String.class);
        ObjectMapper mapper = new ObjectMapper();
        try {
            JsonNode rootNode = mapper.readValue(response, JsonNode.class);
            return rootNode.get("results").get(0).get("films").size();
        } catch (JsonProcessingException e) {
            log.error("Aconteceuy o erro tal | Erro -> {}", e.getMessage());
            throw new RuntimeException(e);
        }
    }

}
