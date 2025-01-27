package com.example.springapi;

import com.example.springapi.controller.SearchController;
import com.example.springapi.service.StudentService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class SearchControllerTests {
    @Autowired
    private MockMvc mockMvc;
    private StudentService studentService;
    @Test
    void testGetStudents() throws Exception {
        mockMvc.perform(get("/students"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON));
    }

    @Test
    void testSearchStudents() throws Exception {
        mockMvc.perform(get("/filter")
                        .param("birthDateFrom", "10-03-2000")
                        .param("birthDateTo", "30-03-2000")
                        .param("courseNumber", "3"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON));
    }

    @Test
    void testCannotFindStudentsBySearch() throws Exception {
        mockMvc.perform(get("/filter")
                        .param("courseNumber", "99999"))
                .andExpect(status().isNoContent());
    }
}
