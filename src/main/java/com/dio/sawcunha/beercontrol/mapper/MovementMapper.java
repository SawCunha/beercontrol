package com.dio.sawcunha.beercontrol.mapper;

import com.dio.sawcunha.beercontrol.dto.request.MovementRequestDTO;
import com.dio.sawcunha.beercontrol.dto.response.MovementResponseDTO;
import com.dio.sawcunha.beercontrol.dto.response.WarehouseResponseDTO;
import com.dio.sawcunha.beercontrol.entity.Movement;
import com.dio.sawcunha.beercontrol.entity.Warehouse;
import com.dio.sawcunha.beercontrol.model.BeerControlResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring")
public interface MovementMapper {

    Movement toModel(MovementRequestDTO movementRequestDTO);
    List<Movement> toModels(List<MovementRequestDTO> movementRequestDTO);
    List<MovementRequestDTO> toDTOs(List<Movement> movement);


    MovementResponseDTO toDTO(Movement movement);

    @Mapping(source = "movement", target = "data")
    BeerControlResponse<MovementResponseDTO> toResponseDTO(Movement movement);

    @Mapping(source = "movements", target = "data")
    default BeerControlResponse<List<MovementResponseDTO>> toResponseDTOs(List<Movement> movements){
        return BeerControlResponse.<List<MovementResponseDTO>>builder()
                .data(movements
                        .stream()
                        .map(this::toDTO)
                        .collect(Collectors.toList())
                )
                .build();
    }
}
