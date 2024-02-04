package com.example.controller;

import com.example.service.Calculate;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.LinkedHashMap;

/**
 * Класс для обработки HTTP запросов.
 * Порт 8080 настроен в файле application.properties.
 * Адрес для приема запроса /string.
 * Программа ожидает при входящем запросе метод Post
 * с типом медиаданных application/x-www-form-urlencoded и
 * ключ с именем string с не пустым значением.
 * В ответе программа отправляет в кодировке UTF-8
 * с типом медиаданных application/json преобразованный в json-формат LinkedHashMap.
 * */
@RestController
@RequiredArgsConstructor
public class Controller {
    /**
     * Поле для вызова бизнес-логики
     */
    private final Calculate calculate;

    @PostMapping(value = "/string"
            , consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE
            , produces = "application/json;charset=UTF-8")
    public ResponseEntity<LinkedHashMap<String,Integer>> process(String string){
        if (string==null||string.isEmpty())
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        var answer = calculate.calculate(string);
        if (answer.isEmpty())
            return new ResponseEntity<>(answer, HttpStatus.BAD_REQUEST);
        return new ResponseEntity<>(answer, HttpStatus.OK);
    }
}
