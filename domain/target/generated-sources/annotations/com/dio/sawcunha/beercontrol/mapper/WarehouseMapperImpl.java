package com.dio.sawcunha.beercontrol.mapper;

import com.dio.sawcunha.beercontrol.dto.request.WarehouseRequestDTO;
import com.dio.sawcunha.beercontrol.dto.request.WarehouseRequestDTO.WarehouseRequestDTOBuilder;
import com.dio.sawcunha.beercontrol.dto.response.BeerResponseDTO;
import com.dio.sawcunha.beercontrol.dto.response.BeerResponseDTO.BeerResponseDTOBuilder;
import com.dio.sawcunha.beercontrol.dto.response.WarehouseResponseDTO;
import com.dio.sawcunha.beercontrol.dto.response.WarehouseResponseDTO.WarehouseResponseDTOBuilder;
import com.dio.sawcunha.beercontrol.entity.Beer;
import com.dio.sawcunha.beercontrol.entity.Warehouse;
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
public class WarehouseMapperImpl implements WarehouseMapper {

    @Override
    public Warehouse toModel(WarehouseRequestDTO warehouseRequestDTO) {
        if ( warehouseRequestDTO == null ) {
            return null;
        }

        Warehouse warehouse = new Warehouse();

        warehouse.setId( warehouseRequestDTO.getId() );
        warehouse.setQuantityMin( warehouseRequestDTO.getQuantityMin() );
        warehouse.setQuantityMaxExpectd( warehouseRequestDTO.getQuantityMaxExpectd() );

        return warehouse;
    }

    @Override
    public WarehouseResponseDTO toDTO(Warehouse warehouse) {
        if ( warehouse == null ) {
            return null;
        }

        WarehouseResponseDTOBuilder warehouseResponseDTO = WarehouseResponseDTO.builder();

        warehouseResponseDTO.id( warehouse.getId() );
        warehouseResponseDTO.beer( beerToBeerResponseDTO( warehouse.getBeer() ) );
        warehouseResponseDTO.quantityMin( warehouse.getQuantityMin() );
        warehouseResponseDTO.quantityMaxExpectd( warehouse.getQuantityMaxExpectd() );
        warehouseResponseDTO.quantity( warehouse.getQuantity() );
        warehouseResponseDTO.update( warehouse.getUpdate() );

        return warehouseResponseDTO.build();
    }

    @Override
    public BeerControlResponse<WarehouseResponseDTO> toResponseDTO(Warehouse warehouse) {
        if ( warehouse == null ) {
            return null;
        }

        BeerControlResponse<WarehouseResponseDTO> beerControlResponse = new BeerControlResponse<WarehouseResponseDTO>();

        beerControlResponse.setData( toDTO( warehouse ) );

        return beerControlResponse;
    }

    @Override
    public List<Warehouse> toModels(List<WarehouseRequestDTO> warehouseRequestDTOS) {
        if ( warehouseRequestDTOS == null ) {
            return null;
        }

        List<Warehouse> list = new ArrayList<Warehouse>( warehouseRequestDTOS.size() );
        for ( WarehouseRequestDTO warehouseRequestDTO : warehouseRequestDTOS ) {
            list.add( toModel( warehouseRequestDTO ) );
        }

        return list;
    }

    @Override
    public List<WarehouseRequestDTO> toDTOs(List<Warehouse> warehouses) {
        if ( warehouses == null ) {
            return null;
        }

        List<WarehouseRequestDTO> list = new ArrayList<WarehouseRequestDTO>( warehouses.size() );
        for ( Warehouse warehouse : warehouses ) {
            list.add( warehouseToWarehouseRequestDTO( warehouse ) );
        }

        return list;
    }

    protected BeerResponseDTO beerToBeerResponseDTO(Beer beer) {
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

    protected WarehouseRequestDTO warehouseToWarehouseRequestDTO(Warehouse warehouse) {
        if ( warehouse == null ) {
            return null;
        }

        WarehouseRequestDTOBuilder warehouseRequestDTO = WarehouseRequestDTO.builder();

        warehouseRequestDTO.id( warehouse.getId() );
        warehouseRequestDTO.quantityMin( warehouse.getQuantityMin() );
        warehouseRequestDTO.quantityMaxExpectd( warehouse.getQuantityMaxExpectd() );

        return warehouseRequestDTO.build();
    }
}
