package com.study.workaround.controller;

import com.study.workaround.model.State;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Arrays;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
public class StateControllerTest {

    private MockMvc mockMvc;

    @MockBean
    private StateController controller;


    @Before
    public void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
    }

    @Test
    public void testFindStateFromAPI() throws Exception {
        State state = new State();
        state.setId(1L);
        state.setName("Paraná");
        state.setInitials("PR");

        State state1 = new State();
        state1.setId(2L);
        state1.setName("São Paulo");
        state1.setInitials("SP");

        List<State> states = Arrays.asList(state, state1);

        Mockito.when(controller.findStateFromAPI()).thenReturn(ResponseEntity.ok().body(states));

        mockMvc.perform(MockMvcRequestBuilders.get("/states"))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk());

        Assert.assertTrue(controller.findStateFromAPI().getBody().size() == states.size());

    }
}