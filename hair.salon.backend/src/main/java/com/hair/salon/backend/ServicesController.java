package com.hair.salon.backend;

import com.hair.salon.backend.models.ServiceDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RequestMapping("/services")
@RestController()
public class ServicesController {
    @GetMapping
    public List<ServiceDto> getServices(){
        List<ServiceDto> result=new ArrayList<>();
        ServiceDto x=new ServiceDto(10,"Name","Desc",true,125);
        result.add(x);
        x=new ServiceDto(20,"ime","opis",false,50);
        result.add(x);
        return result;
    }
}
