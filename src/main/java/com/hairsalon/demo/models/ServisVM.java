package com.hairsalon.demo.models;

import com.hairsalon.demo.models.entities.Servis;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ServisVM {

    private Long id;
    private String name;

    public ServisVM(Servis servis)  {
        this.id = servis.getId();
        this.name = servis.getName();
    }
}
