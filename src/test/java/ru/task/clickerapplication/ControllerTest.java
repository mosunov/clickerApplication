package ru.task.clickerapplication;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import ru.task.clickerapplication.controller.Controller;
import ru.task.clickerapplication.service.IncrementService;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

    @RunWith(SpringRunner.class)
    @WebMvcTest(Controller.class)
    @AutoConfigureMockMvc
    public class ControllerTest {
        @MockBean
        private IncrementService incrementService;
        @Autowired
        private MockMvc mockMvc;

        @Test
        public void test() throws Exception {
            when(incrementService.increment()).thenReturn("10");
            mockMvc.perform(post("/index")).andExpect(status().isOk()).andExpect(content().string("10"));
        }
    }
