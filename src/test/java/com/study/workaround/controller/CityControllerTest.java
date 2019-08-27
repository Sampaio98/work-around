package com.study.workaround.controller;

import com.study.workaround.dto.CityDTO;
import com.study.workaround.service.CityService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.Arrays;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
public class CityControllerTest {

    private MockMvc mockMvc;

    @Autowired
    private WebApplicationContext context;

    @InjectMocks
    private CityController controller;

    @Mock
    private CityService service;

    private static final Long ID_STATE = 41L;


    @Before
    public void setUp() {
        mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
    }

    @Test
    public void testTest() throws Exception {
    }

    @Test
    public void testFindCitiesByStateId() throws Exception {
        CityDTO c1 = new CityDTO(4100103L, "Abatiá");
        CityDTO c2 = new CityDTO(4100202L, "Adrianópolis");

        List<CityDTO> citiesDTO = Arrays.asList(c1, c2);

//        Mockito.when(controller.findCitiesByStateId(41L)).thenReturn(citiesDTO);

        mockMvc.perform(MockMvcRequestBuilders.get("/cities/state/"+ ID_STATE))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk());
        Assert.assertEquals(controller.findCitiesByStateId(41L).getBody().size(), citiesDTO.size());
    }
}