package com.study.workaround.controller;

import com.study.workaround.domain.model.Party;
import com.study.workaround.domain.service.PartyService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.math.BigDecimal;

import static com.study.workaround.utils.JsonUtils.toJson;

@RunWith(SpringRunner.class)
public class PartyControllerTest {

    private MockMvc mockMvc;

    @InjectMocks
    private PartyController controller;

    @Mock
    private PartyService service;

    private Party party;

    @Before
    public void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
        party = new Party();
    }

    @Test
    public void testInsert() throws Exception {
        party.setTitle("bagui loko");
        party.setDescription("insane crazy party fuck yeah");
        party.setPrice(new BigDecimal("35.00"));

        byte[] partyJson = toJson(party);

        Mockito.when(service.insert(party)).thenReturn(party);

        mockMvc.perform(MockMvcRequestBuilders.post("/parties")
                .content(partyJson)
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isCreated());
    }

    @Test
    public void testFindById() throws Exception {
        Party p = new Party();

        p.setId(10L);
        p.setTitle("azideia mermao");
        p.setDescription("a party mais loka do everson zoio mermao");
        p.setPrice(new BigDecimal("1.00"));

        Mockito.when(service.findById(p.getId())).thenReturn(p);

        mockMvc.perform(MockMvcRequestBuilders.get("/parties/" + p.getId())).andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.id").value(p.getId()))
                .andExpect(MockMvcResultMatchers.jsonPath("$.title").value(p.getTitle()))
                .andReturn();
    }
}