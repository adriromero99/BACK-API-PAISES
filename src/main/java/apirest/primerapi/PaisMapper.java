package apirest.primerapi;

public class PaisMapper {

    public PaisDE map(PaisDTO paisDTO){
        return new PaisDE(paisDTO.getNombre(), paisDTO.getCantidadHabitantes(), paisDTO.getTamanio(), paisDTO.getReligion(), paisDTO.getIdioma(), paisDTO.getContinente());
    }

    public PaisDTO unmap(PaisDE paisDE){
        return PaisDTO.builder()
                .nombre(paisDE.getNombre())
                .cantidadHabitantes(paisDE.getCantidadHabitantes())
                .tamanio(paisDE.getTamanio())
                .religion(paisDE.getReligion())
                .idioma(paisDE.getIdioma())
                .continente(paisDE.getContinente())
                .build();
    }

}
