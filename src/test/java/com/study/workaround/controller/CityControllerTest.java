package com.study.workaround.controller;

import com.study.workaround.domain.dto.CityDTO;
import com.study.workaround.domain.service.CityService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
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

    @InjectMocks
    private CityController controller;

    @Mock
    private CityService servicer;

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

        Mockito.when(servicer.findCitiesByStateId(ID_STATE)).thenReturn(citiesDTO);

        mockMvc.perform(MockMvcRequestBuilders.get("/cities/state/" + ID_STATE))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk());

        Assert.assertEquals(controller.findCitiesByStateId(ID_STATE).getBody().size(), citiesDTO.size());

    }
}