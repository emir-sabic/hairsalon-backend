package com.hair.salon.backend.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ServiceDto {
    private int id;
    private String name;

    private String description;

    private boolean available;
    private double price;

}
