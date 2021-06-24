package apirest.primerapi;

import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Builder
@Data
public class PaisDTO {

    @ApiModelProperty(
            value = "Nombre del pais",
            name = "nombre",
            dataType = "String",
            required = true,
            example = "Argentina"
    )
    @NotBlank
    @Size(max = 20)
    private String nombre;

    @ApiModelProperty(
            value = "Cantidad de habitantes del pais",
            name = "cantidadHabitantes",
            dataType = "long",
            required = true,
            example = "3000000"
    )
    private long cantidadHabitantes;

    @ApiModelProperty(
            value = "Metros cuadrados del pais",
            name = "tamanio",
            dataType = "long",
            required = true,
            example = "10000"
    )
    private long tamanio;

    @ApiModelProperty(
            value = "Religion principal del pais",
            name = "religion",
            dataType = "String",
            required = true,
            example = "Catolica"
    )
    private String religion;

    @ApiModelProperty(
            value = "Idioma principal del pais",
            name = "idioma",
            dataType = "String",
            required = true,
            example = "Ingles"
    )
    private String idioma;

    @ApiModelProperty(
            value = "Continente del pais",
            name = "continente",
            dataType = "String",
            required = true,
            example = "Europa"
    )
    private String continente;

}