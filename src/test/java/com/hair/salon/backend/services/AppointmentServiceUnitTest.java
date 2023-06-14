package com.hair.salon.backend.services;

import com.hair.salon.backend.data.AppointmentTest;
import com.hair.salon.backend.models.AppointmentDto;
import com.hair.salon.backend.models.entities.AppointmentEntity;
import com.hair.salon.backend.repositories.AppointmentRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.test.context.junit4.SpringRunner;
;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@RunWith(SpringRunner.class)
public class AppointmentServiceUnitTest {
    @MockBean
    private AppointmentRepository appointmentRepository;

    @TestConfiguration
    static class AppointmentServiceTestConfiguration {

        @Bean
        @Primary
        public AppointmentService appointmentService(AppointmentRepository appointmentRepository) {
            return new AppointmentService(appointmentRepository);
        }
    }

    @Autowired
    private AppointmentService appointmentService;

    @Test
    public void givenAppointment_whenGetAppointmentList_thenListShouldBeFound() {
        // arrange
        Mockito.when(appointmentRepository.findAll())
                .thenReturn(List.of(AppointmentTest.appointment()));

        // act
        List<AppointmentDto> returnedList = appointmentService.getAppointmentList();

        // assert
        assertThat(returnedList).hasSize(1);
    }
    @Test
    public void givenNoAppointment_whenGetAppointmentList_thenListShouldBeEmpty() {
        // act
        List<AppointmentDto> returnedList = appointmentService.getAppointmentList();

        // assert
        assertThat(returnedList).isEmpty();
    }

    @Test
    public void givenValidId_whenGetAppointment_thenAppointmentShouldBeFound() {
        // arrange
        long id = 1L;
        Mockito.when(appointmentRepository.findById(id))
                .thenReturn(Optional.of(AppointmentTest.appointment()));

        // act
        AppointmentDto resultAppointment = appointmentService.getAppointment(id);

        // assert
        assertThat(resultAppointment.getName()).isEqualTo("name1");
    }
    @Test
    public void givenInvalidId_whenGetAppointment_thenExceptionShouldBeThrown() {
        assertThatThrownBy(() -> appointmentService.getAppointment(3L))
                .isInstanceOf(RuntimeException.class)
                .hasMessageContaining("Appointment not found");
    }

    @Test
    public void givenAppointment_whenCreateAppointment_thenAppointmentIsReturned() {
        // arrange
        AppointmentDto inputApointmentDto = AppointmentTest.appointmentDto1();
        inputApointmentDto.setId(0L); // reset id
        AppointmentEntity outputAppointment = AppointmentTest.appointment();

        Mockito.when(appointmentRepository.save(any(AppointmentEntity.class)))
                .thenReturn(outputAppointment);

        // act
        AppointmentDto resulAppointment = appointmentService.createAppointment(inputApointmentDto);

        // assert
        assertThat(resulAppointment).isNotNull();
        assertThat(resulAppointment.getName()).isEqualTo(inputApointmentDto.getName());
        assertThat(resulAppointment.getId()).isNotEqualTo(0L);
    }

    @Test
    public void givenAppointment_whenCreateAppointment_thenRepositoryCalled() {
        // arrange
        AppointmentDto appointmentDto = AppointmentTest.appointmentDto3();

        Mockito.when(appointmentRepository.save(any(AppointmentEntity.class)))
                .thenReturn(AppointmentTest.appointment());

        // act
        appointmentService.createAppointment(appointmentDto);

        // assert
        verify(appointmentRepository, times(1)).save(any(AppointmentEntity.class));
    }

    @Test
    public void givenAppointmentAndValidId_whenUpdate_thenAppointmentReturned() {
        // arrange
        AppointmentDto inputAppointmentDto = AppointmentTest.appointmentDto1();
        inputAppointmentDto.setId(0L); // reset id
        long id = 1L;
        AppointmentEntity outputAppointment = AppointmentTest.appointment();
        outputAppointment.setId(id);

        Mockito.when(appointmentRepository.findById(id))
                .thenReturn(Optional.of(outputAppointment));
        Mockito.when(appointmentRepository.save(any(AppointmentEntity.class)))
                .thenReturn(outputAppointment);

        // act
        AppointmentDto resultAppointment = appointmentService.updateAppointment(id, inputAppointmentDto);

        // assert
        assertThat(resultAppointment).isNotNull();
        assertThat(resultAppointment.getName()).isEqualTo(inputAppointmentDto.getName());
        assertThat(resultAppointment.getId()).isEqualTo(id);
    }

    @Test
    public void givenInvalidId_whenUpdate_thenExceptionShouldBeThrown() {
        assertThatThrownBy(() -> appointmentService.updateAppointment(2L, AppointmentTest.appointmentDto3()))
                .isInstanceOf(RuntimeException.class)
                .hasMessageContaining("Appointment not found");
    }

    @Test
    public void givenAppointment_whenDelete_thenRepositoryCalled() {
        // arrange
        long id = 2L;

        // act
        appointmentService.deleteAppointment(id);

        // assert
        verify(appointmentRepository, times(1)).deleteById(id);
    }
}
