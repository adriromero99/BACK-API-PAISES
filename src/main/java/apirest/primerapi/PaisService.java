package apirest.primerapi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Service
public class PaisService {

    @Autowired
    private PaisRepository repository;
    private final PaisMapper mapper;

    public PaisService() {
        this.mapper = new PaisMapper();
    }

    public PaisDTO findByNombre(String nombre){
        List<PaisDE> paises = repository.findByNombre(nombre);
        return mapper.unmap(paises.get(0));
    }

    public void save(PaisDTO pais){
        repository.save(mapper.map(pais));
    }

    public void deleteByNombre(String nombre){
        List<PaisDE> paises = repository.findByNombre(nombre);
        repository.delete(paises.get(0));
    }

    public List<PaisDTO> findAll(){
        Iterable<PaisDE> paises = repository.findAll();
        List<PaisDTO> paisesDTO = new ArrayList<PaisDTO>();
        for (PaisDE pais : paises) {
            paisesDTO.add(mapper.unmap(pais));
        }
        return paisesDTO;
    }

    public void update(String nombre, PaisDTO pais){
        PaisDE paisViejo = repository.findByNombre(nombre).get(0);
        paisViejo.setNombre(pais.getNombre());
        paisViejo.setCantidadHabitantes(pais.getCantidadHabitantes());
        paisViejo.setTamanio(pais.getTamanio());
        paisViejo.setDensidad(pais.getCantidadHabitantes()/pais.getTamanio());
        paisViejo.setIdioma(pais.getIdioma());
        paisViejo.setReligion(pais.getReligion());
        paisViejo.setContinente(pais.getContinente());
        repository.save(paisViejo);
    }

}
