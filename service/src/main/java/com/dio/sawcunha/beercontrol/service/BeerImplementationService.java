package com.dio.sawcunha.beercontrol.service;

import com.dio.sawcunha.beercontrol.dto.request.BeerRequestDTO;
import com.dio.sawcunha.beercontrol.dto.response.BeerResponseDTO;
import com.dio.sawcunha.beercontrol.entity.Beer;
import com.dio.sawcunha.beercontrol.exception.error.BeerHasWarehouseDeleteException;
import com.dio.sawcunha.beercontrol.exception.error.BeerNotFoundException;
import com.dio.sawcunha.beercontrol.exception.error.IdentifierRepeatedException;
import com.dio.sawcunha.beercontrol.exception.error.NameRepeatedException;
import com.dio.sawcunha.beercontrol.mapper.BeerMapper;
import com.dio.sawcunha.beercontrol.model.BeerControlResponse;
import com.dio.sawcunha.beercontrol.repository.BeerRepository;
import com.dio.sawcunha.beercontrol.repository.WarehouseRepository;
import com.dio.sawcunha.beercontrol.specification.service.BeerService;
import com.dio.sawcunha.beercontrol.specification.validation.ValidUpdateEntity;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class BeerImplementationService implements BeerService {

    private final BeerRepository beerRepository;
    private final WarehouseRepository warehouseRepository;
    private final BeerMapper beerMapper;
    private final ValidUpdateEntity<Beer,BeerRequestDTO> validUpdateEntityBeer;

    @Transactional(readOnly = true)
    public BeerControlResponse<List<BeerResponseDTO>> findAll() {
        return beerMapper.toResponseDTOs(beerRepository.findAll());
    }

    @Transactional(readOnly = true)
    public BeerControlResponse<BeerResponseDTO> findById(final Long id) throws BeerNotFoundException {
        return beerMapper.toResponseDTO(beerRepository.findById(id).orElseThrow(BeerNotFoundException::new));
    }

    @Transactional(rollbackFor = {IdentifierRepeatedException.class, NameRepeatedException.class})
    public BeerControlResponse<BeerResponseDTO> save(BeerRequestDTO beerRequestDTO) throws Exception {
        if(beerRepository.existsBeerByIdentifierEquals(beerRequestDTO.getIdentifier())){
            throw new IdentifierRepeatedException();
        }
        if(beerRepository.existsBeerByNameEquals(beerRequestDTO.getName())){
            throw new NameRepeatedException();
        }

        Beer beer = beerMapper.toModel(beerRequestDTO);
        beer.setCreated(LocalDateTime.now());
        return beerMapper.toResponseDTO(beerRepository.save(beer));
    }

    @Transactional(rollbackFor = {BeerNotFoundException.class, IdentifierRepeatedException.class, NameRepeatedException.class})
    public BeerControlResponse<BeerResponseDTO> update(BeerRequestDTO beerRequestDTO) throws Exception {
        if(beerRequestDTO.getId() == null || beerRequestDTO.getId() <= 0){
            throw new BeerNotFoundException();
        }
        Beer beer = beerRepository.findById(beerRequestDTO.getId()).orElseThrow(BeerNotFoundException::new);
        validUpdateEntityBeer.valid(beer,beerRequestDTO);
        return beerMapper.toResponseDTO(beerRepository.save(beer));
    }

    @Transactional(rollbackFor = {BeerNotFoundException.class, BeerHasWarehouseDeleteException.class})
    public void delete(Long id) throws Exception {
        Beer beer = beerRepository.findById(id).orElseThrow(BeerNotFoundException::new);
        if(warehouseRepository.existsWarehouseByBeer(beer)){
            throw new BeerHasWarehouseDeleteException();
        }
        beerRepository.delete(beer);
    }
}
