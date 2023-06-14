package com.hairsalon.demo.models;

import com.hairsalon.demo.models.entities.NewsLetter;
import com.hairsalon.demo.models.entities.Stylist;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class StylistVM {
    private Long id;
    private String name;

    public StylistVM(Stylist stylist)  {
        this.id = stylist.getId();
        this.name = stylist.getName();
    }
}
