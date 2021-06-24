package apirest.primerapi;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PaisRepository extends CrudRepository<PaisDE, Long> {
    List<PaisDE> findByNombre(String nombre);
}
