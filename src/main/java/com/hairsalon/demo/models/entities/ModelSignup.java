package com.hairsalon.demo.models.entities;

import com.hairsalon.demo.models.ModelSignupVM;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.Banner;

@Entity
@Table(name ="modelsignup")
@Getter
@Setter
public class ModelSignup  {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "fullname")
    private String fullname;

    @Column(name = "email")
    private String email;

    @Column(name = "phonenumber")
    private String phonenumber;

    @Column(name = "age")
    private String age;

    @Column(name = "prevexp")
    private String prevexp;

    public ModelSignup(ModelSignupVM modelSignupVM){
        this.fullname = modelSignupVM.getFullname();
        this.email = modelSignupVM.getEmail();
        this.phonenumber = modelSignupVM.getPhonenumber();
        this.age = modelSignupVM.getAge();
        this.prevexp = modelSignupVM.getPrevexp();
    }

    public ModelSignup(){}
    @Override
    public String toString() {
        return "ModelSignup{" +
                "id=" + id +
                ", fullname='" + fullname + '\'' +
                ", email='" + email + '\'' +
                ", phonenumber='" + phonenumber + '\'' +
                ", age='" + age + '\'' +
                ", prevexp='" + prevexp + '\'' +
                '}';
    }
}