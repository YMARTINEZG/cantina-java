package com.exercise.cantinajava.controllers;

import com.exercise.cantinajava.domain.SelectorDto;
import com.exercise.cantinajava.exceptions.BadPayloadException;
import com.exercise.cantinajava.services.ViewService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    @PostMapping("/api/count")
    public List<SelectorDto> countSelector(@RequestBody String selector){
        return viewService.getAttributesCount(selector);
    }
}
