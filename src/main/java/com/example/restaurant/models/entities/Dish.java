package com.example.restaurant.models.entities;


import lombok.AllArgsConstructor;
import lombok.Data;
import javax.persistence.Id;

@Data
@AllArgsConstructor
public class Dish {

    @Id
    private int id;
    private String name;
    private String description;
    private Double price;

    public Dish() {

    }
}
