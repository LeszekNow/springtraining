package com.leszeknowinski.springtraining.models;


import org.springframework.stereotype.Service;

import java.util.UUID;

@Service //działająca usługa component - usługa ale jako cały oddzielny model bean - nie da sie skategoryzować to jest @bean
public class SimpleBean {
    public String generateString(){
        return UUID.randomUUID().toString();
    }
}
