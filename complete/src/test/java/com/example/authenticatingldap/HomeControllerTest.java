package com.example.authenticatingldap;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(HomeController.class)
public class HomeControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    @WithMockUser
    void index() throws Exception {
        this.mockMvc.perform(get("/home/"))
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("Welcome to the home page!")));
    }

    @Test
    @WithMockUser(roles = "DEVELOPERS")
    void hello() throws Exception {
        this.mockMvc.perform(get("/home/hello"))
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("Hello developer!")));
    }

    @Test
    @WithMockUser
    void hello_not_allowed() throws Exception {
        this.mockMvc.perform(get("/home/hello"))
                .andExpect(status().isForbidden());
    }

    @Test
    @WithMockUser(roles = "MANAGERS")
    void managers() throws Exception {
        this.mockMvc.perform(get("/home/managers"))
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("Hello manager!")));
    }

    @Test
    @WithMockUser
    void managers_not_allowed() throws Exception {
        this.mockMvc.perform(get("/home/managers"))
                .andExpect(status().isForbidden());
    }

    @Test
    @WithMockUser(username = "username")
    void user() throws Exception {
        this.mockMvc.perform(get("/home/user"))
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("username")));
    }
}