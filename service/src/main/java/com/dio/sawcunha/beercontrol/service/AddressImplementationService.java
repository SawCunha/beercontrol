package com.dio.sawcunha.beercontrol.service;

import com.dio.sawcunha.beercontrol.dto.request.AddressRequestDTO;
import com.dio.sawcunha.beercontrol.dto.response.AddressResponseDTO;
import com.dio.sawcunha.beercontrol.entity.Address;
import com.dio.sawcunha.beercontrol.entity.Person;
import com.dio.sawcunha.beercontrol.exception.error.AddressNotFoundIDException;
import com.dio.sawcunha.beercontrol.exception.error.ExceptionPeopleManager;
import com.dio.sawcunha.beercontrol.exception.error.IDPathDifferentBodyException;
import com.dio.sawcunha.beercontrol.exception.error.PersonNotFoundIDException;
import com.dio.sawcunha.beercontrol.mapper.AddressMapper;
import com.dio.sawcunha.beercontrol.model.BeerControlResponse;
import com.dio.sawcunha.beercontrol.repository.AddressRepository;
import com.dio.sawcunha.beercontrol.repository.PersonRepository;
import com.dio.sawcunha.beercontrol.specification.service.AddressService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.mail.MethodNotSupportedException;
import java.util.List;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class AddressImplementationService implements AddressService {

    private final AddressRepository addressRepository;
    private final PersonRepository personRepository;
    private final AddressMapper addressMapper;

    @Transactional(readOnly = true)
    public BeerControlResponse<List<AddressResponseDTO>> findAll(){
        return addressMapper.toResponseDTOs(addressRepository.findAll());
    }

    @Override
    public BeerControlResponse<AddressResponseDTO> findById(Long id) throws Exception {
        return addressMapper.toResponseDTO(addressRepository.findById(id).orElseThrow(AddressNotFoundIDException::new));
    }

    @Override
    public BeerControlResponse<AddressResponseDTO> save(AddressRequestDTO addressRequestDTO) throws Exception {
        throw new MethodNotSupportedException();
    }

    @Override
    public BeerControlResponse<?> update(AddressRequestDTO entityRequest) throws Exception {
        throw new MethodNotSupportedException();
    }

    @Transactional(readOnly = true)
    public BeerControlResponse<AddressResponseDTO> findById(Long id, boolean inforPerson) throws AddressNotFoundIDException {
        AddressResponseDTO addressDTO;
        if(inforPerson) {
            addressDTO = addressMapper.toDTO(addressRepository.findById(id).orElseThrow(AddressNotFoundIDException::new));
        } else {
            addressDTO = addressRepository.findByIdDTO(id).orElseThrow(AddressNotFoundIDException::new);
        }
        return BeerControlResponse.<AddressResponseDTO>builder().data(addressDTO).build();
    }

    @Transactional(readOnly = true)
    public BeerControlResponse<List<AddressResponseDTO>> findByidPerson(Long idPerson) throws AddressNotFoundIDException {
        return BeerControlResponse.<List<AddressResponseDTO>>builder()
                .data(addressRepository.findByIDPersonDTO(idPerson).orElseThrow(AddressNotFoundIDException::new))
                .build();
    }

    @Transactional
    public void delete(Long id) throws AddressNotFoundIDException {
        Address address = addressRepository.findById(id).orElseThrow(AddressNotFoundIDException::new);
        addressRepository.delete(address);
    }

    @Transactional
    public BeerControlResponse<AddressResponseDTO> save(Long idPerson, AddressRequestDTO addressDTO) throws ExceptionPeopleManager {
        Person person = personRepository.findById(idPerson).orElseThrow(PersonNotFoundIDException::new);
        addressDTO.setPerson(null);
        Address address = addressMapper.toModel(addressDTO);
        address.setPerson(person);
        return addressMapper.toResponseDTO(addressRepository.save(address));
    }

    @Transactional
    public BeerControlResponse<AddressResponseDTO> update(Long id, AddressRequestDTO addressDTO) throws ExceptionPeopleManager {
        validIDPathAndBody(id,addressDTO);
        Address address = addressRepository.findById(id).orElseThrow(AddressNotFoundIDException::new);
        addressDTO.setPerson(null);
        Address addressUpdate = addressMapper.toModel(addressDTO);
        addressUpdate.setPerson(address.getPerson());
        addressUpdate.setId(address.getId());
        return addressMapper.toResponseDTO(addressRepository.save(addressUpdate));
    }


    private void validIDPathAndBody(Long idAddress, AddressRequestDTO addressDTO) throws IDPathDifferentBodyException {
        if(addressDTO.getId() == null || addressDTO.getId() == 0 ) throw new IDPathDifferentBodyException();
        if(!idAddress.equals(addressDTO.getId())) throw new IDPathDifferentBodyException();
    }
}
