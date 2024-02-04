package com.example.service;

import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.*;
import java.util.stream.Collectors;

/**
 * Класс для реализации бизнес логики
 */
@Service
public class Calculate {
    /**
     * Метод преобразует строку в LinkedHashMap
     * @param string Параметр не должен быть null. Строка не должна быть пустой.
     * @return Возвращает LinkedHashMap с упорядоченными по убыванию элементами, где
     * ключ - символ из строки, значение - количество вхождений символа в строку.
     */
    public LinkedHashMap<String,Integer> calculate(String string){
        Map<String,Integer> map =new HashMap<>();
        Integer k;
        for (int i=0;i<string.length();i++){
            if (map.containsKey(string.substring(i,i+1))){
                k=map.get(string.substring(i,i+1));
                map.put(string.substring(i,i+1),++k);
            }else{
                map.put(string.substring(i,i+1),1);
            }
        }
        var link = map.entrySet()
                .stream().sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue
                        ,(k1, k2) -> k1, LinkedHashMap::new));
        return link;
    }
}
