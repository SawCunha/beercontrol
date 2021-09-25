package com.dio.sawcunha.beercontrol.mapper;

import com.dio.sawcunha.beercontrol.dto.request.WarehouseRequestDTO;
import com.dio.sawcunha.beercontrol.dto.response.WarehouseResponseDTO;
import com.dio.sawcunha.beercontrol.entity.Warehouse;
import com.dio.sawcunha.beercontrol.model.BeerControlResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.util.Base64;
import java.util.List;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring")
public interface WarehouseMapper {

    Warehouse toModel(WarehouseRequestDTO warehouseRequestDTO);
    WarehouseResponseDTO toDTO(Warehouse warehouse);

    @Mapping(source = "warehouse", target = "data")
    BeerControlResponse<WarehouseResponseDTO> toResponseDTO(Warehouse warehouse);

    @Mapping(source = "warehouses", target = "data")
    default BeerControlResponse<List<WarehouseResponseDTO>> toResponseDTOs(List<Warehouse> warehouses){
        return BeerControlResponse.<List<WarehouseResponseDTO>>builder()
                .data(warehouses
                        .stream()
                        .map(this::toDTO)
                        .collect(Collectors.toList())
                )
                .build();
    }

    List<Warehouse> toModels(List<WarehouseRequestDTO> warehouseRequestDTOS);
    List<WarehouseRequestDTO> toDTOs(List<Warehouse> warehouses);

    @Named("bytestoBase64")
    public static String bytestoBase64(byte[] image) {
        return Base64.getEncoder().encodeToString(image);
    }

    @Named("base64ToBytes")
    public static byte[] base64ToBytes(String image) {
        return Base64.getDecoder().decode(image);
    }
}
