package apirest.primerapi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.List;

@RestController
@RequestMapping("/paises")
@CrossOrigin
@Validated
public class PaisController {

    @Autowired
    private PaisService service;
    //AOP inversion de control

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<PaisDTO>> getPaises(){
        return new ResponseEntity<List<PaisDTO>>(service.findAll(), HttpStatus.OK);
    }

    @GetMapping(value ="/{nombre}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<PaisDTO> getPais(@PathVariable @NotBlank @Size(max = 20) String nombre){
        return new ResponseEntity<PaisDTO>(service.findByNombre(nombre), HttpStatus.OK);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> savePais(@Valid @RequestBody PaisDTO pais){
        service.save(pais);
        return new ResponseEntity<String>("Se ha creado el pais: " + pais.getNombre(), HttpStatus.OK);
    }

    @DeleteMapping(value = "/{nombre}")
    public ResponseEntity<String> deletePais(@PathVariable @NotBlank @Size(max = 20) String nombre){
        service.deleteByNombre(nombre);
        return new ResponseEntity<String>("Se ha borrado el pais: " + nombre, HttpStatus.OK);
    }

    @PutMapping(value = "/{nombre}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> updatePais(@RequestBody PaisDTO pais, @PathVariable @NotBlank @Size(max = 20) String nombre){
        service.update(nombre, pais);
        return new ResponseEntity<String>("Se ha actualizado el pais: " + nombre, HttpStatus.OK);
    }

}
