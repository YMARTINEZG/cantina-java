package com.exercise.cantinajava.controllers;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest
@AutoConfigureMockMvc
public class MainViewControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void loadJson_IsValid_JsonNodeCreated() throws Exception {

        final String json = "{ \"identifier\" : \"system\", \"subviews\" : \"[]\" }";
        mockMvc
                .perform(post("/api/load").content(json).contentType(APPLICATION_JSON))
                .andExpect(status().isOk());
    }
    @Test
    void loadJson_NotValid_JsonNodeNotCreated() throws Exception {

        final String json = "{}";
        mockMvc
                .perform(post("/api/load").content(json).contentType(APPLICATION_JSON))
                .andExpect(status().isBadRequest());
    }
}
