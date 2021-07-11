package com.dio.sawcunha.beercontrol.mapper;

import com.dio.sawcunha.beercontrol.dto.request.MovementDTO;
import com.dio.sawcunha.beercontrol.entity.Movement;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface MovementMapper {

    Movement toModel(MovementDTO movementDTO);
    MovementDTO toDTO(Movement movement);
    List<Movement> toModels(List<MovementDTO> movementDTO);
    List<MovementDTO> toDTOs(List<Movement> movement);

}
