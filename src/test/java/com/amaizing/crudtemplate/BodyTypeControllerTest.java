package com.amaizing.crudtemplate;


import com.amaizing.crudtemplate.controllers.BodyTypeController;
import com.amaizing.crudtemplate.models.BodyType;
import com.amaizing.crudtemplate.repositories.BodyTypeRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@ExtendWith(MockitoExtension.class)
public class BodyTypeControllerTest {

    private MockMvc mockMvc;

    @Mock
    private BodyTypeRepository repository;

    @InjectMocks
    private BodyTypeController controller;

    @BeforeEach
    void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
    }

    @Test
    void testGetAllBodyTypes() throws Exception {
        List<BodyType> bodyTypes = new ArrayList<>();
        bodyTypes.add(new BodyType(1L, "BodyType 1", "Description 1"));
        bodyTypes.add(new BodyType(2L, "BodyType 2", "Description 2"));

        when(repository.findAllByOrderByIdAsc()).thenReturn(bodyTypes);

        mockMvc.perform(get("/api/v1/tables/body_types"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$[0].name").value("BodyType 1"))
                .andExpect(jsonPath("$[1].name").value("BodyType 2"));

        verify(repository, times(1)).findAllByOrderByIdAsc();
        verifyNoMoreInteractions(repository);
    }

    @Test
    void testCreateBodyType() throws Exception {
        BodyType bodyType = new BodyType(1L, "New BodyType", "New Description");

        when(repository.save(any(BodyType.class))).thenReturn(bodyType);

        mockMvc.perform(post("/api/v1/tables/body_types")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{ \"name\": \"New BodyType\", \"description\": \"New Description\" }"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.name").value("New BodyType"))
                .andExpect(jsonPath("$.description").value("New Description"));

        verify(repository, times(1)).save(any(BodyType.class));
        verifyNoMoreInteractions(repository);
    }

    @Test
    void testUpdateBodyType() throws Exception {
        BodyType existingBodyType = new BodyType(1L, "Existing BodyType", "Existing Description");
        BodyType updatedBodyType = new BodyType(1L, "Updated BodyType", "Updated Description");

        when(repository.findById(1L)).thenReturn(Optional.of(existingBodyType));
        when(repository.save(any(BodyType.class))).thenReturn(updatedBodyType);

        mockMvc.perform(post("/api/v1/tables/body_types/1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{ \"name\": \"Updated BodyType\", \"description\": \"Updated Description\" }"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.name").value("Updated BodyType"))
                .andExpect(jsonPath("$.description").value("Updated Description"));

        verify(repository, times(1)).findById(1L);
        verify(repository, times(1)).save(any(BodyType.class));
        verifyNoMoreInteractions(repository);
    }

    @Test
    void testDeleteBodyType() throws Exception {
        mockMvc.perform(delete("/api/v1/tables/body_types/1"))
                .andExpect(status().isOk());

        verify(repository, times(1)).deleteById(1L);
        verifyNoMoreInteractions(repository);
    }
}
