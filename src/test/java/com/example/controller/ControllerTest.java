package com.example.controller;

import com.example.frequency.FrequencyApplication;
import com.example.service.Calculate;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest(classes = {FrequencyApplication.class})
@AutoConfigureMockMvc
class ControllerTest {
    @Autowired
    private MockMvc mvc;
    @Autowired
    private Calculate calculate;
    private final String INPUT_STRING = "  ewrw23ewϠrwerw// w\n\tよろしくお願いします423erfwerwef";
    @Test
    public void zapros() throws Exception {
        var mapper = new ObjectMapper();
        try {
            var stringAnswer = mapper.writeValueAsString(calculate.calculate(INPUT_STRING));
            mvc.perform(MockMvcRequestBuilders.post("/string")
                            .param("string", INPUT_STRING)
                            .contentType(MediaType.APPLICATION_FORM_URLENCODED_VALUE))
                    .andExpect(status().isOk())
                    .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                    .andExpect(content().json(stringAnswer));
        } catch (JsonProcessingException e) {
        }
    }

}