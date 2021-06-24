package apirest.primerapi;

import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
public class RepositoryTest {

    @Autowired
    PaisRepository repository;

    @Test
    public void agregoBoliviaYLoRecupero() {
        PaisDE paisDE = new PaisDE("Bolivia", 42000000,300000, "Catolica", "Español", "America");
        repository.save(paisDE);
        List<PaisDE> paises = repository.findByNombre("Bolivia");
        assertEquals(paises.get(0), paisDE);
    }

    @Test
    public void buscoEcuadorYNoEsta() {
        assertThrows(Exception.class, () -> repository.findByNombre("Ecuador").get(0));
    }


}

