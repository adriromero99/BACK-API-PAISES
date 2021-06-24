package apirest.primerapi;
import lombok.Builder;
import lombok.Data;

import javax.persistence.*;

@Entity
@Table
@Data
public class PaisDE {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;

    @Column
    private String nombre;

    @Column
    private long cantidadHabitantes;

    @Column
    private long tamanio;

    @Column
    private long densidad;

    @Column
    private String religion;

    @Column
    private String idioma;

    @Column
    private String continente;

    protected PaisDE(){}

    public PaisDE(String nombre, long cantidadHabitantes, long tamanio, String religion, String idioma, String continente){
        this.nombre = nombre;
        this.cantidadHabitantes = cantidadHabitantes;
        this.tamanio = tamanio;
        this.densidad = cantidadHabitantes/tamanio;
        this.idioma = idioma;
        this.religion = religion;
        this.continente = continente;
    }

}
