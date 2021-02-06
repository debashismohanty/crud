package com.example.microservice.crud.model;

import com.fasterxml.jackson.annotation.JsonAnySetter;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.LinkedHashMap;
import java.util.Map;

@Data
@NoArgsConstructor
public class GenericObject {
    private Long id;
    private Map<String, Object> object = new LinkedHashMap<>();

    @JsonAnySetter
    void setObject(String key, Object value) {
        object.put(key, value);
    }
}
