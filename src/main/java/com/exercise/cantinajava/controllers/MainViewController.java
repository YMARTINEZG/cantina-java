package com.exercise.cantinajava.controllers;

import com.exercise.cantinajava.domain.ResultDto;
import com.exercise.cantinajava.exceptions.BadPayloadException;
import com.exercise.cantinajava.services.ViewService;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class MainViewController {

    private final ViewService viewService;

    public MainViewController(ViewService viewService) {
        this.viewService = viewService;
    }

    @PostMapping("/api/load")
    public ResponseEntity<String> uploadJsonString(@RequestBody String jsonString){
        try {
            viewService.loadJsonPayload(jsonString);
        }catch(BadPayloadException ex){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        return ResponseEntity.status(HttpStatus.OK).build();
    }
    @GetMapping("/api/count/{selector}")
    public ResultDto countSelector(@PathVariable String selector){
           Integer result = viewService.getAttributesCount(selector);
           return new ResultDto("View", selector, result);
    }
}
