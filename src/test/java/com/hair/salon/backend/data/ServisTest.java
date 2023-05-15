package com.hair.salon.backend.data;


import com.hair.salon.backend.models.ServisDto;
import com.hair.salon.backend.models.entities.ServisEntity;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ServisTest {
    private static long id2 = 1L;
    private static String name1 = "name1";
    private static String description1 = "description1";
    private static double price1 = 10;




    public static ServisEntity servis() {
        ServisEntity servis = new ServisEntity();
        servis.setId(id2);
        servis.setName(name1);
        servis.setDescription(description1);
        servis.setPrice(price1);



        return servis;
    }

    public static ServisDto servisDto1() {
        return new ServisDto(id2, name1, description1, price1);
    }

    public static ServisDto servisDto3() {
        return new ServisDto(3L, "name2",
                "description2",
                25);
    }
}
