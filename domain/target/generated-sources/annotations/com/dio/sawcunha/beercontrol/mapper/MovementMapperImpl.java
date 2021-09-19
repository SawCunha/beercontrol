package com.dio.sawcunha.beercontrol.mapper;

import com.dio.sawcunha.beercontrol.dto.request.MovementRequestDTO;
import com.dio.sawcunha.beercontrol.dto.request.MovementRequestDTO.MovementRequestDTOBuilder;
import com.dio.sawcunha.beercontrol.dto.response.BeerResponseDTO;
import com.dio.sawcunha.beercontrol.dto.response.BeerResponseDTO.BeerResponseDTOBuilder;
import com.dio.sawcunha.beercontrol.dto.response.MovementResponseDTO;
import com.dio.sawcunha.beercontrol.dto.response.MovementResponseDTO.MovementResponseDTOBuilder;
import com.dio.sawcunha.beercontrol.dto.response.WarehouseResponseDTO;
import com.dio.sawcunha.beercontrol.dto.response.WarehouseResponseDTO.WarehouseResponseDTOBuilder;
import com.dio.sawcunha.beercontrol.entity.Beer;
import com.dio.sawcunha.beercontrol.entity.Movement;
import com.dio.sawcunha.beercontrol.entity.Warehouse;
import com.dio.sawcunha.beercontrol.model.BeerControlResponse;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-09-11T11:22:36-0300",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 11.0.11 (Oracle Corporation)"
)
@Component
public class MovementMapperImpl implements MovementMapper {

    @Override
    public Movement toModel(MovementRequestDTO movementRequestDTO) {
        if ( movementRequestDTO == null ) {
            return null;
        }

        Movement movement = new Movement();

        movement.setId( movementRequestDTO.getId() );
        movement.setMovementType( movementRequestDTO.getMovementType() );
        movement.setQuantity( movementRequestDTO.getQuantity() );
        movement.setAutomatic( movementRequestDTO.isAutomatic() );
        movement.setEmail( movementRequestDTO.getEmail() );

        return movement;
    }

    @Override
    public List<Movement> toModels(List<MovementRequestDTO> movementRequestDTO) {
        if ( movementRequestDTO == null ) {
            return null;
        }

        List<Movement> list = new ArrayList<Movement>( movementRequestDTO.size() );
        for ( MovementRequestDTO movementRequestDTO1 : movementRequestDTO ) {
            list.add( toModel( movementRequestDTO1 ) );
        }

        return list;
    }

    @Override
    public List<MovementRequestDTO> toDTOs(List<Movement> movement) {
        if ( movement == null ) {
            return null;
        }

        List<MovementRequestDTO> list = new ArrayList<MovementRequestDTO>( movement.size() );
        for ( Movement movement1 : movement ) {
            list.add( movementToMovementRequestDTO( movement1 ) );
        }

        return list;
    }

    @Override
    public MovementResponseDTO toDTO(Movement movement) {
        if ( movement == null ) {
            return null;
        }

        MovementResponseDTOBuilder movementResponseDTO = MovementResponseDTO.builder();

        movementResponseDTO.id( movement.getId() );
        movementResponseDTO.identifier( movement.getIdentifier() );
        movementResponseDTO.movementType( movement.getMovementType() );
        movementResponseDTO.movementStatus( movement.getMovementStatus() );
        movementResponseDTO.warehouse( warehouseToWarehouseResponseDTO( movement.getWarehouse() ) );
        movementResponseDTO.quantity( movement.getQuantity() );
        movementResponseDTO.created( movement.getCreated() );
        movementResponseDTO.updated( movement.getUpdated() );
        movementResponseDTO.confirmation( movement.getConfirmation() );
        movementResponseDTO.automatic( movement.isAutomatic() );
        movementResponseDTO.email( movement.getEmail() );

        return movementResponseDTO.build();
    }

    @Override
    public BeerControlResponse<MovementResponseDTO> toResponseDTO(Movement movement) {
        if ( movement == null ) {
            return null;
        }

        BeerControlResponse<MovementResponseDTO> beerControlResponse = new BeerControlResponse<MovementResponseDTO>();

        beerControlResponse.setData( toDTO( movement ) );

        return beerControlResponse;
    }

    protected MovementRequestDTO movementToMovementRequestDTO(Movement movement) {
        if ( movement == null ) {
            return null;
        }

        MovementRequestDTOBuilder movementRequestDTO = MovementRequestDTO.builder();

        movementRequestDTO.id( movement.getId() );
        movementRequestDTO.movementType( movement.getMovementType() );
        movementRequestDTO.quantity( movement.getQuantity() );
        movementRequestDTO.automatic( movement.isAutomatic() );
        movementRequestDTO.email( movement.getEmail() );

        return movementRequestDTO.build();
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

    protected WarehouseResponseDTO warehouseToWarehouseResponseDTO(Warehouse warehouse) {
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
}
