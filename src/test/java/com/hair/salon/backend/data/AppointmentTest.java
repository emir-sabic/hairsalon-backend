package com.hair.salon.backend.data;

import com.hair.salon.backend.models.AppointmentDto;
import com.hair.salon.backend.models.entities.AppointmentEntity;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;



@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class AppointmentTest {
    private static long id2 = 1L;
    private static String name1 = "name1";
    private static String email1 = "email1@mail.com";
    private static String date1 = "date1";
    private static String time1 = "time1";
    private static String stylist1 = "stylist1";
    private static String service1 = "service1";



    public static AppointmentEntity appointment() {
        AppointmentEntity appointment = new AppointmentEntity();
        appointment.setId(id2);
        appointment.setName(name1);
        appointment.setEmail(email1);
        appointment.setDate(date1);
        appointment.setTime(time1);
        appointment.setStylist(stylist1);
        appointment.setService(service1);


        return appointment;
    }

    public static AppointmentDto appointmentDto1() {
        return new AppointmentDto(id2, name1, email1, date1, time1, stylist1, service1);
    }

    public static AppointmentDto appointmentDto3() {
        return new AppointmentDto(3L, "name2",
                "email2@gmail.com",
                "date2",
                "time2",
                "stylist2",
                "service2");
    }

}
