package com.study.workaround.controller;

import com.study.workaround.model.Party;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.WebApplicationContext;

import java.math.BigDecimal;

import static com.study.workaround.utils.JsonUtils.toJson;

@SpringBootTest
@RunWith(SpringRunner.class)
@Transactional
public class PartyControllerTest {

    private MockMvc mockMvc;

    @Autowired
    private WebApplicationContext context;

    private Party party;

    @Before
    public void setUp() {
        mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
        party = new Party();
    }

    @Test
    public void testInsert() throws Exception {
        party.setTitle("bagui loko");
        party.setDescription("insane crazy party fuck yeah");
        party.setPrice(new BigDecimal("35.00"));

        byte[] partyJson = toJson(party);

        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.post("/parties")
                .content(partyJson)
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isCreated())
                .andReturn();

        result.getResponse().getHeaderNames();
        String location = result.getResponse().getHeader("Location");
        String[] split = location.split("/");
        Long id = Long.parseLong(split[split.length - 1]);

        party.setId(id);
    }

    @Test
    public void testFindById() throws Exception {
        testInsert();

        mockMvc.perform(MockMvcRequestBuilders.get("/parties/" + party.getId())).andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.id").value(party.getId()))
                .andExpect(MockMvcResultMatchers.jsonPath("$.title").value(party.getTitle()))
                .andReturn();
    }
}