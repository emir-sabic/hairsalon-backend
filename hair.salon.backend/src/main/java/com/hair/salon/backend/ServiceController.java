package com.hair.salon.backend;

import com.hair.salon.backend.models.ServiceDto;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/service")
@RestController
public class ServiceController {
    @GetMapping
    public ServiceDto getService(int ID){
        return new ServiceDto(ID,"Imeservisa","Opisservisa",true,20);
    }
    @PostMapping
    public boolean postService(int ID,String Name,String Desc,Boolean Avail,double Price){
        ServiceDto x=new ServiceDto(ID,Name,Desc,Avail,Price);
        return true;
    }
    @DeleteMapping
    public boolean deleteService(int ID){
        return true;
    }
    @PatchMapping
    public ServiceDto patchService(int ID,String Name,String Desc,Boolean Avail,double Price){
        ServiceDto x=new ServiceDto(ID,Name,Desc,Avail,Price);
        return x;
    }
}
