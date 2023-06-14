package com.hairsalon.demo.models;

import com.hairsalon.demo.models.entities.ModelSignup;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.Banner;

@Getter
@Setter
@AllArgsConstructor
public class ModelSignupVM {
    private Long id;
    private String fullname;
    private String email;
    private String phonenumber;
    private String age;
    private String prevexp;

    public ModelSignupVM(ModelSignup modelSignup){
        this.id = modelSignup.getId();
        this.fullname = modelSignup.getFullname();
        this.email = modelSignup.getEmail();
        this.phonenumber = modelSignup.getPhonenumber();
        this.age = modelSignup.getAge();
        this.prevexp = modelSignup.getPrevexp();
    }
}
