package com.hairsalon.demo.models.entities;

import com.hairsalon.demo.models.NewsLetterVM;
import com.hairsalon.demo.models.StylistVM;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="stylist")
@Getter
@Setter
public class Stylist {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;


    public Stylist(StylistVM stylistVM){
        this.name = stylistVM.getName();
    }

    public Stylist(){}
    @Override
    public String toString() {
        return "Stylist{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
