package org.vincent.hero;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.vincent.hero.dto.Hero;

@SpringBootTest
@AutoConfigureMockMvc
class HeroControllerTest {

    @Autowired
    private MockMvc mockMvc;

    private ObjectMapper objectMapper = new ObjectMapper();

    @Test
    void testGetHeroes() throws Exception {
        MvcResult mvcResult = mockMvc.perform(get("/api/heroes").contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk()).andReturn();
        List<Hero> heroes = objectMapper.readValue(mvcResult.getResponse().getContentAsString(), List.class);
        assertThat(heroes).hasSize(9);
    }

}
