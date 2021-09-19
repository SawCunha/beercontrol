package com.dio.sawcunha.beercontrol.mapper;

import com.dio.sawcunha.beercontrol.dto.request.BeerRequestDTO;
import com.dio.sawcunha.beercontrol.dto.request.BeerRequestDTO.BeerRequestDTOBuilder;
import com.dio.sawcunha.beercontrol.dto.response.BeerResponseDTO;
import com.dio.sawcunha.beercontrol.dto.response.BeerResponseDTO.BeerResponseDTOBuilder;
import com.dio.sawcunha.beercontrol.entity.Beer;
import com.dio.sawcunha.beercontrol.model.BeerControlResponse;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-09-11T11:22:35-0300",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 11.0.11 (Oracle Corporation)"
)
@Component
public class BeerMapperImpl implements BeerMapper {

    @Override
    public Beer toModel(BeerRequestDTO beerRequestDTO) {
        if ( beerRequestDTO == null ) {
            return null;
        }

        Beer beer = new Beer();

        beer.setId( beerRequestDTO.getId() );
        beer.setIdentifier( beerRequestDTO.getIdentifier() );
        beer.setName( beerRequestDTO.getName() );
        beer.setImage( beerRequestDTO.getImage() );
        beer.setBrand( beerRequestDTO.getBrand() );
        beer.setBeerType( beerRequestDTO.getBeerType() );

        return beer;
    }

    @Override
    public BeerResponseDTO toDTO(Beer beer) {
        if ( beer == null ) {
            return null;
        }

        BeerResponseDTOBuilder beerResponseDTO = BeerResponseDTO.builder();

        beerResponseDTO.id( beer.getId() );
        beerResponseDTO.identifier( beer.getIdentifier() );
        beerResponseDTO.name( beer.getName() );
        beerResponseDTO.image( beer.getImage() );
        beerResponseDTO.brand( beer.getBrand() );
        beerResponseDTO.beerType( beer.getBeerType() );
        beerResponseDTO.created( beer.getCreated() );

        return beerResponseDTO.build();
    }

    @Override
    public BeerControlResponse<BeerResponseDTO> toResponseDTO(Beer beer) {
        if ( beer == null ) {
            return null;
        }

        BeerControlResponse<BeerResponseDTO> beerControlResponse = new BeerControlResponse<BeerResponseDTO>();

        beerControlResponse.setData( toDTO( beer ) );

        return beerControlResponse;
    }

    @Override
    public List<Beer> toModels(List<BeerRequestDTO> beerRequestDTOS) {
        if ( beerRequestDTOS == null ) {
            return null;
        }

        List<Beer> list = new ArrayList<Beer>( beerRequestDTOS.size() );
        for ( BeerRequestDTO beerRequestDTO : beerRequestDTOS ) {
            list.add( toModel( beerRequestDTO ) );
        }

        return list;
    }

    @Override
    public List<BeerRequestDTO> toDTOs(List<Beer> beers) {
        if ( beers == null ) {
            return null;
        }

        List<BeerRequestDTO> list = new ArrayList<BeerRequestDTO>( beers.size() );
        for ( Beer beer : beers ) {
            list.add( beerToBeerRequestDTO( beer ) );
        }

        return list;
    }

    protected BeerRequestDTO beerToBeerRequestDTO(Beer beer) {
        if ( beer == null ) {
            return null;
        }

        BeerRequestDTOBuilder beerRequestDTO = BeerRequestDTO.builder();

        beerRequestDTO.id( beer.getId() );
        beerRequestDTO.identifier( beer.getIdentifier() );
        beerRequestDTO.name( beer.getName() );
        beerRequestDTO.image( beer.getImage() );
        beerRequestDTO.brand( beer.getBrand() );
        beerRequestDTO.beerType( beer.getBeerType() );

        return beerRequestDTO.build();
    }
}
