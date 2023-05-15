package com.hair.salon.backend.services;


import com.hair.salon.backend.data.ServisTest;
import com.hair.salon.backend.models.ServisDto;
import com.hair.salon.backend.models.entities.ServisEntity;
import com.hair.salon.backend.repositories.ServisRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@RunWith(SpringRunner.class)
public class ServisServiceUnitTest {
    @MockBean
    private ServisRepository servisRepository;

    @TestConfiguration
    static class ServisServiceTestConfiguration {

        @Bean
        @Primary
        public ServisService servisService(ServisRepository servisRepository) {
            return new ServisService(servisRepository);
        }
    }

    @Autowired
    private ServisService servisService;

    @Test
    public void givenServis_whenGetServisList_thenListShouldBeFound() {
        // arrange
        Mockito.when(servisRepository.findAll())
                .thenReturn(List.of(ServisTest.servis()));

        // act
        List<ServisDto> returnedList = servisService.getServisList();

        // assert
        assertThat(returnedList).hasSize(1);
    }
    @Test
    public void givenNoServis_whenGetServisList_thenListShouldBeEmpty() {
        // act
        List<ServisDto> returnedList = servisService.getServisList();

        // assert
        assertThat(returnedList).isEmpty();
    }

    @Test
    public void givenValidId_whenGetServis_thenServisShouldBeFound() {
        // arrange
        long id = 1L;
        Mockito.when(servisRepository.findById(id))
                .thenReturn(Optional.of(ServisTest.servis()));

        // act
        ServisDto resultServis = servisService.getServis(id);

        // assert
        assertThat(resultServis.getName()).isEqualTo("name1");
    }
    @Test
    public void givenInvalidId_whenGetServis_thenExceptionShouldBeThrown() {
        assertThatThrownBy(() -> servisService.getServis(3L))
                .isInstanceOf(RuntimeException.class)
                .hasMessageContaining("Servis not found");
    }

    @Test
    public void givenServis_whenCreateServis_thenServisIsReturned() {
        // arrange
        ServisDto inputApointmentDto = ServisTest.servisDto1();
        inputApointmentDto.setId(0L); // reset id
        ServisEntity outputServis = ServisTest.servis();

        Mockito.when(servisRepository.save(any(ServisEntity.class)))
                .thenReturn(outputServis);

        // act
        ServisDto resulServis = servisService.createServis(inputApointmentDto);

        // assert
        assertThat(resulServis).isNotNull();
        assertThat(resulServis.getName()).isEqualTo(inputApointmentDto.getName());
        assertThat(resulServis.getId()).isNotEqualTo(0L);
    }

    @Test
    public void givenServis_whenCreateServis_thenRepositoryCalled() {
        // arrange
        ServisDto servisDto = ServisTest.servisDto3();

        Mockito.when(servisRepository.save(any(ServisEntity.class)))
                .thenReturn(ServisTest.servis());

        // act
        servisService.createServis(servisDto);

        // assert
        verify(servisRepository, times(1)).save(any(ServisEntity.class));
    }

    @Test
    public void givenServisAndValidId_whenUpdate_thenServisReturned() {
        // arrange
        ServisDto inputServisDto = ServisTest.servisDto1();
        inputServisDto.setId(0L); // reset id
        long id = 1L;
        ServisEntity outputServis = ServisTest.servis();
        outputServis.setId(id);

        Mockito.when(servisRepository.findById(id))
                .thenReturn(Optional.of(outputServis));
        Mockito.when(servisRepository.save(any(ServisEntity.class)))
                .thenReturn(outputServis);

        // act
        ServisDto resultServis = servisService.updateServis(id, inputServisDto);

        // assert
        assertThat(resultServis).isNotNull();
        assertThat(resultServis.getName()).isEqualTo(inputServisDto.getName());
        assertThat(resultServis.getId()).isEqualTo(id);
    }

    @Test
    public void givenInvalidId_whenUpdate_thenExceptionShouldBeThrown() {
        assertThatThrownBy(() -> servisService.updateServis(2L, ServisTest.servisDto3()))
                .isInstanceOf(RuntimeException.class)
                .hasMessageContaining("Servis not found");
    }

    @Test
    public void givenServis_whenDelete_thenRepositoryCalled() {
        // arrange
        long id = 2L;

        // act
        servisService.deleteServis(id);

        // assert
        verify(servisRepository, times(1)).deleteById(id);
    }
}
