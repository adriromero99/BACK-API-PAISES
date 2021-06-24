package apirest.primerapi;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
public class ServiceTest {

    @Autowired
    PaisService service;

    PaisDTO paisDTO;

    @BeforeEach
    public void setup() {
        paisDTO = paisDTO.builder()
                .nombre("Bolivia")
                .cantidadHabitantes(2)
                .tamanio(1)
                .build();
    }

    @Test
    public void agregoBoliviaYLoRecupero() {
        service.save(paisDTO);
        assertEquals(service.findByNombre("Bolivia"), paisDTO);
    }

    @Test
    public void buscoEcuadorYNoEsta() {
        assertThrows(Exception.class, () -> service.findByNombre("Ecuador"));
    }

    @Test
    public void borrarUSANoPermiteRecuperarlo() {
        service.deleteByNombre("USA");
        assertThrows(Exception.class, () -> service.findByNombre("USA"));
    }

    @Test
    public void borrarDosVecesArgentinaCausaError() {
        service.deleteByNombre("Argentina");
        assertThrows(Exception.class, () -> service.deleteByNombre("Argentina"));
    }

}
