package com.study.workaround.service;

import com.study.workaround.dto.CityDTO;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CityServiceTest {

    @Autowired
    @MockBean
    private CityService service;

    @Test
    public void testFindCitiesByStateId() throws Exception {
        CityDTO c1 = new CityDTO(4100103L, "Abatiá");
        CityDTO c2 = new CityDTO(4100202L, "Adrianópolis");
        when(service.findCitiesByStateId(41L)).thenReturn(Arrays.asList(c1, c2));
        assertEquals(2, service.findCitiesByStateId(41L).size());
    }
}