package com.dio.sawcunha.beercontrol.controller;

import com.dio.sawcunha.beercontrol.dto.request.MovementRequestDTO;
import com.dio.sawcunha.beercontrol.dto.response.MovementResponseDTO;
import com.dio.sawcunha.beercontrol.model.BeerControlResponse;
import com.dio.sawcunha.beercontrol.specification.service.MovementService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.UUID;

@RestController
@RequestMapping(value = "/api/v1/movement", produces = MediaType.APPLICATION_JSON_VALUE)
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class MovementController {

    private final MovementService movementService;

    @GetMapping("/identifier/{identifier}")
    @ResponseStatus(HttpStatus.OK)
    public BeerControlResponse<MovementResponseDTO> findByIdentifier(@PathVariable(name = "identifier") final UUID identifier) throws Exception {
        return movementService.findByIdentifier(identifier);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public BeerControlResponse<MovementResponseDTO> save(@RequestBody @Valid final MovementRequestDTO movementRequestDTO) throws Exception {
        return movementService.save(movementRequestDTO);
    }

    @PutMapping("/identifier/{identifier}")
    @ResponseStatus(HttpStatus.OK)
    public BeerControlResponse<MovementResponseDTO> update(@RequestBody final MovementRequestDTO movementRequestDTO,
                                                           @PathVariable(name = "identifier") final UUID identifier) throws Exception {
        return movementService.update(identifier, movementRequestDTO);
    }

    @DeleteMapping("/{id}/identifier/{identifier}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable(name = "id") final Long id, @PathVariable(name = "identifier") final UUID identifier) throws Exception {
        movementService.delete(identifier, id);
    }
}
