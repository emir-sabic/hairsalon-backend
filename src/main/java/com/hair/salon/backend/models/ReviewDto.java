package com.hair.salon.backend.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ReviewDto  {
    private Long id;
    private String name;
    private String email;
    private String review;
}
