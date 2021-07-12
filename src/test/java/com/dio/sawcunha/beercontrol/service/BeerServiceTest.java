package com.dio.sawcunha.beercontrol.service;

import com.dio.sawcunha.beercontrol.dto.request.BeerRequestDTO;
import com.dio.sawcunha.beercontrol.dto.response.BeerResponseDTO;
import com.dio.sawcunha.beercontrol.entity.Beer;
import com.dio.sawcunha.beercontrol.exception.error.BeerNotFoundException;
import com.dio.sawcunha.beercontrol.exception.error.IdentifierRepeatedException;
import com.dio.sawcunha.beercontrol.exception.error.NameRepeatedException;
import com.dio.sawcunha.beercontrol.mapper.BeerMapper;
import com.dio.sawcunha.beercontrol.model.BeerControlResponse;
import com.dio.sawcunha.beercontrol.repository.BeerRepository;
import com.dio.sawcunha.beercontrol.repository.WarehouseRepository;
import com.dio.sawcunha.beercontrol.util.BeerFake;
import com.dio.sawcunha.beercontrol.util.ValidUpdateEntityBeer;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class BeerServiceTest {

    @Mock
    private BeerRepository beerRepository;
    @Mock
    private WarehouseRepository warehouseRepository;
    @Mock
    private BeerMapper beerMapper;

    private final BeerMapper beerMapperExample = BeerMapper.INSTANCE;

    @Mock
    private ValidUpdateEntityBeer validUpdateEntityBeer;

    @InjectMocks
    private BeerService beerService;

    @Test
    @Order(1)
    void createBeerSuccess() throws Exception {
        BeerRequestDTO beerRequestDTO = BeerFake.createBeerFake();
        Beer beer = beerMapperExample.toModel(beerRequestDTO);
        BeerControlResponse<BeerResponseDTO> responseDTOBeerControlResponse = beerMapperExample.toResponseDTO(beer);

        when(beerRepository.existsBeerByIdentifierEquals(beerRequestDTO.getIdentifier())).thenReturn(false);
        when(beerRepository.existsBeerByNameEquals(beerRequestDTO.getName())).thenReturn(false);
        when(beerMapper.toModel(beerRequestDTO)).thenReturn(beer);
        when(beerMapper.toResponseDTO(beer)).thenReturn(responseDTOBeerControlResponse);
        when(beerRepository.save(beer)).thenReturn(beer);

        BeerControlResponse<BeerResponseDTO> beerResponseDTO = beerService.save(beerRequestDTO);

        assertThat(beerResponseDTO.getData(), not(nullValue()));
        assertThat(beerResponseDTO.getData().getId(), is(equalTo(beer.getId())));
        assertThat(beerResponseDTO.getData().getName(), is(equalTo(beer.getName())));
        assertThat(beerResponseDTO.getData().getIdentifier(), is(equalTo(beer.getIdentifier())));

    }

    @Test
    @Order(2)
    void createBeerErroByIdentifierRepeatedException() {
        BeerRequestDTO beerRequestDTO = BeerFake.createBeerFake();

        when(beerRepository.existsBeerByIdentifierEquals(beerRequestDTO.getIdentifier())).thenReturn(true);

        assertThrows(IdentifierRepeatedException.class, () -> beerService.save(beerRequestDTO));

    }

    @Test
    @Order(3)
    void createBeerErroByNameRepeatedException() {
        BeerRequestDTO beerRequestDTO = BeerFake.createBeerFake();

        when(beerRepository.existsBeerByIdentifierEquals(beerRequestDTO.getIdentifier())).thenReturn(false);
        when(beerRepository.existsBeerByNameEquals(beerRequestDTO.getName())).thenReturn(true);

        assertThrows(NameRepeatedException.class, () -> beerService.save(beerRequestDTO));

    }

    @Test
    @Order(4)
    void updateBeerErroByBeerNotFoundException() {
        BeerRequestDTO beerRequestDTO = BeerFake.createBeerFake();
        beerRequestDTO.setId(null);
        assertThrows(BeerNotFoundException.class, () -> beerService.update(beerRequestDTO));
    }

    @Test
    @Order(5)
    void updateBeerErroGetBeerByBeerNotFoundException() {
        BeerRequestDTO beerRequestDTO = BeerFake.createBeerFake();
        assertThrows(BeerNotFoundException.class, () -> beerService.update(beerRequestDTO));
    }

    @Test
    @Order(6)
    void updateBeerEqualSuccess() throws Exception {
        BeerRequestDTO beerRequestDTO = BeerFake.createBeerFake();
        Beer beer = beerMapperExample.toModel(beerRequestDTO);
        BeerControlResponse<BeerResponseDTO> responseDTOBeerControlResponse = beerMapperExample.toResponseDTO(beer);

        when(beerRepository.findById(beerRequestDTO.getId())).thenReturn(Optional.of(beer));
        when(beerMapper.toResponseDTO(beer)).thenReturn(responseDTOBeerControlResponse);
        when(beerRepository.save(beer)).thenReturn(beer);

        BeerControlResponse<BeerResponseDTO> beerResponseDTO = beerService.update(beerRequestDTO);

        assertThat(beerResponseDTO.getData(), not(nullValue()));
        assertThat(beerResponseDTO.getData().getId(), is(equalTo(beer.getId())));
        assertThat(beerResponseDTO.getData().getName(), is(equalTo(beer.getName())));
        assertThat(beerResponseDTO.getData().getIdentifier(), is(equalTo(beer.getIdentifier())));

    }

    @Test
    @Order(7)
    void updateBeerSuccess() throws Exception {
        BeerRequestDTO beerRequestDTO = BeerFake.createBeerFake();
        Beer beer = beerMapperExample.toModel(beerRequestDTO);
        beerRequestDTO = BeerFake.createBeerFake();
        beerRequestDTO.setId(beer.getId());
        BeerControlResponse<BeerResponseDTO> responseDTOBeerControlResponse = beerMapperExample.toResponseDTO(beer);

        when(beerRepository.findById(beerRequestDTO.getId())).thenReturn(Optional.of(beer));
        when(beerMapper.toResponseDTO(beer)).thenReturn(responseDTOBeerControlResponse);
        when(beerRepository.save(beer)).thenReturn(beer);

        BeerControlResponse<BeerResponseDTO> beerResponseDTO = beerService.update(beerRequestDTO);

        assertThat(beerResponseDTO.getData(), not(nullValue()));
        assertThat(beerResponseDTO.getData().getId(), is(equalTo(beer.getId())));
        assertThat(beerResponseDTO.getData().getName(), is(equalTo(beer.getName())));
        assertThat(beerResponseDTO.getData().getIdentifier(), is(equalTo(beer.getIdentifier())));

    }

}
