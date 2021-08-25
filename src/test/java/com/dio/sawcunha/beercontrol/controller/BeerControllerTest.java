package com.dio.sawcunha.beercontrol.controller;

import com.dio.sawcunha.beercontrol.dto.request.BeerRequestDTO;
import com.dio.sawcunha.beercontrol.dto.response.BeerResponseDTO;
import com.dio.sawcunha.beercontrol.mapper.BeerMapper;
import com.dio.sawcunha.beercontrol.model.BeerControlResponse;
import com.dio.sawcunha.beercontrol.service.BeerService;
import com.dio.sawcunha.beercontrol.util.BeerFake;
import com.google.gson.Gson;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.web.PageableHandlerMethodArgumentResolver;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(MockitoExtension.class)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class BeerControllerTest {

    private static final String BEER_API_URL_PATH = "/api/v1/beer";

    private MockMvc mockMvc;

    private final BeerMapper beerMapperExample = BeerMapper.INSTANCE;

    @Mock
    private BeerService beerService;

    @InjectMocks
    private BeerController beerController;

    @BeforeEach
    void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(beerController)
                .setCustomArgumentResolvers(new PageableHandlerMethodArgumentResolver())
                .setViewResolvers((s, locale) -> new MappingJackson2JsonView())
                .build();
    }

    @Test
    @Order(1)
    void createBeerSuccess() throws Exception {
        // given
        BeerRequestDTO beerRequestDTO = BeerFake.createBeerFake();
        BeerControlResponse<BeerResponseDTO> responseDTOBeerControlResponse = beerMapperExample.toResponseDTO(beerMapperExample.toModel(beerRequestDTO));

        // when
        when(beerService.save(beerRequestDTO)).thenReturn(responseDTOBeerControlResponse);

        // then
        mockMvc.perform(post(BEER_API_URL_PATH)
                .contentType(MediaType.APPLICATION_JSON)
                .content(new Gson().toJson(beerRequestDTO)))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.data.name", is(beerRequestDTO.getName())))
                .andExpect(jsonPath("$.data.brand", is(beerRequestDTO.getBrand())))
                .andExpect(jsonPath("$.data.beerType", is(beerRequestDTO.getBeerType().toString())));
    }

    @Test
    @Order(2)
    void updateBeerSuccess() throws Exception {
        // given
        BeerRequestDTO beerRequestDTO = BeerFake.createBeerFake();
        BeerControlResponse<BeerResponseDTO> responseDTOBeerControlResponse = beerMapperExample.toResponseDTO(beerMapperExample.toModel(beerRequestDTO));

        // when
        when(beerService.update(beerRequestDTO)).thenReturn(responseDTOBeerControlResponse);

        // then
        mockMvc.perform(put(BEER_API_URL_PATH)
                .contentType(MediaType.APPLICATION_JSON)
                .content(new Gson().toJson(beerRequestDTO)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.data.name", is(beerRequestDTO.getName())))
                .andExpect(jsonPath("$.data.brand", is(beerRequestDTO.getBrand())))
                .andExpect(jsonPath("$.data.beerType", is(beerRequestDTO.getBeerType().toString())));
    }

}
