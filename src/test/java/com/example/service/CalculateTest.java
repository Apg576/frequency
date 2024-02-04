package com.example.service;

import org.junit.jupiter.api.Test;
import java.util.LinkedHashMap;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 *
 *
 */
class CalculateTest {
    private final String checkString = "122333";
    private final LinkedHashMap<String,Integer> resultMap = new LinkedHashMap<>(){{
        put("3",3);put("2",2);put("1",1);
    }};
    @Test
    void calculate() {
        assertEquals(resultMap, new Calculate().calculate(checkString));
    }
}