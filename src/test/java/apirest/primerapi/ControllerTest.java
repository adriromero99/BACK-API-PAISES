package apirest.primerapi;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;

import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@SpringBootTest
@AutoConfigureMockMvc
public class ControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    PaisController controller;
    @Autowired
    PaisRepository repository;

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
    public void controllerNotNull() {
        assertTrue(controller!=null);
    }

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void obtenerArgentinaDevuelveStatus200() throws Exception {
        mockMvc.perform(get("/paises/Argentina")
                .contentType(MediaType.valueOf("application/json"))
                .content(""))
                .andExpect(status().isOk());
    }

    @Test
    public void borrarArgentinaDevueleStatus200() throws Exception {
        mockMvc.perform(delete("/paises/Argentina")
                .contentType(MediaType.valueOf("application/json"))
                .content(""))
                .andExpect(status().isOk());
    }

    @Test
    public void postBoliviaDevueleStatus200OK() throws Exception {
        mockMvc.perform(post("/paises")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(paisDTO)))
                .andExpect(status().isOk());

    }

    @Test
    public void postBoliviaDevueleLaRespuestaAdecuada() throws Exception {
        MvcResult result = mockMvc.perform(post("/paises")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(paisDTO)))
                .andExpect(status().isOk()).andReturn();

        assertEquals(result.getResponse().getContentAsString(), "Se ha creado el pais: Bolivia");
    }

    @Test
    public void putUSADevueleLaRespuestaAdecuada() throws Exception {
        MvcResult result = mockMvc.perform(put("/paises/USA")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(paisDTO)))
                .andExpect(status().isOk()).andReturn();

        assertEquals(result.getResponse().getContentAsString(), "Se ha actualizado el pais: USA");
    }

}
