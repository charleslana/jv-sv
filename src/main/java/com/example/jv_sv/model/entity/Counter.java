package com.example.jv_sv.model.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Document(collection = "counter")
public class Counter {
    @Id
    private String id;

    private String name;

    private Long seq;
}
