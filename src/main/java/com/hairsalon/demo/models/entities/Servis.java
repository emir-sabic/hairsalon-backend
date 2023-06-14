package com.hairsalon.demo.models.entities;

import com.hairsalon.demo.models.ServisVM;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="servis")
@Getter
@Setter
public class Servis {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    public Servis(ServisVM servisVM){this.name = servisVM.getName();}

    public Servis(){}

    @Override
    public String toString(){
        return "Servis{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
