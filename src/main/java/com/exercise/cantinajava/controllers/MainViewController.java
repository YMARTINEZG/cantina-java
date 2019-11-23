package com.exercise.cantinajava.controllers;

import com.exercise.cantinajava.services.ViewService;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController("/api")
public class MainViewController {

    private ViewService viewService;

    @Autowired
    public MainViewController(ViewService viewService) {
        this.viewService = viewService;
    }

    @PostMapping("/load")
    public ResponseEntity<String> uploadJsonString(@RequestBody String jsonString){
        try {
            viewService.loadJsonPayload(jsonString);
        }catch(Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
