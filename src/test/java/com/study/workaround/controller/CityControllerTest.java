package com.study.workaround.controller;

import com.study.workaround.dto.CityDTO;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Arrays;
import java.util.List;

@RunWith(SpringRunner.class)
public class CityControllerTest {

    private MockMvc mockMvc;

    @MockBean
    private CityController controller;

    private static final Long ID_STATE = 41L;


    @Before
    public void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
    }

    @Test
    public void testFindCitiesByStateId() throws Exception {
        CityDTO c1 = new CityDTO(4100103L, "Abatiá");
        CityDTO c2 = new CityDTO(4100202L, "Adrianópolis");

        List<CityDTO> citiesDTO = Arrays.asList(c1, c2);

        Mockito.when(controller.findCitiesByStateId(ID_STATE)).thenReturn(ResponseEntity.ok().body(citiesDTO));

        mockMvc.perform(MockMvcRequestBuilders.get("/cities/state/" + ID_STATE))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk());

        Assert.assertEquals(controller.findCitiesByStateId(ID_STATE).getBody().size(), citiesDTO.size());

    }
}