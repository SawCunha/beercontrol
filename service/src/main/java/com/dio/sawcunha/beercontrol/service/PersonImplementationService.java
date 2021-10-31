package com.dio.sawcunha.beercontrol.service;


import com.dio.sawcunha.beercontrol.dto.request.AddressRequestDTO;
import com.dio.sawcunha.beercontrol.dto.request.PersonRequestDTO;
import com.dio.sawcunha.beercontrol.dto.response.BeerResponseDTO;
import com.dio.sawcunha.beercontrol.dto.response.PersonResponseDTO;
import com.dio.sawcunha.beercontrol.entity.Person;
import com.dio.sawcunha.beercontrol.exception.error.*;
import com.dio.sawcunha.beercontrol.mapper.PersonMapper;
import com.dio.sawcunha.beercontrol.model.BeerControlResponse;
import com.dio.sawcunha.beercontrol.repository.PersonRepository;
import com.dio.sawcunha.beercontrol.specification.service.PersonService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class PersonImplementationService implements PersonService {

    private final PersonRepository personRepository;
    private final PersonMapper personMapper;

    @Transactional(readOnly = true)
    public BeerControlResponse<List<PersonResponseDTO>> findAll(){
            List<Person> personList = personRepository.findAll();

            return personMapper.toResponseDTOs(personList);
    }

    @Transactional(readOnly = true)
    public BeerControlResponse<PersonResponseDTO> findByCpf(String cpf) throws PersonNotFoundCPFException {
        Person person = personRepository.findByCpf(cpf).orElseThrow(PersonNotFoundCPFException::new);
        return personMapper.toResponseDTO(person);
    }

    @Transactional(readOnly = true)
    public BeerControlResponse<PersonResponseDTO> findById(Long id) throws PersonNotFoundIDException {
        Person person = personRepository.findById(id).orElseThrow(PersonNotFoundIDException::new);
        return personMapper.toResponseDTO(person);
    }

    @Transactional
    public BeerControlResponse<PersonResponseDTO> save(PersonRequestDTO personDTO) throws PersonAlreadyRegistersCpfException {
        Optional<Person> personOptional = personRepository.findByCpf(personDTO.getCpf());
        if(personOptional.isPresent()){
            throw new PersonAlreadyRegistersCpfException();
        }
        Person person = personMapper.toModel(personDTO);
        person.getAddresses().forEach(address -> address.setPerson(person));
        person.getPhones().forEach(phone -> phone.setPerson(person));
        return personMapper.toResponseDTO(personRepository.save(person));
    }

    @Override
    public BeerControlResponse<?> update(PersonRequestDTO personRequestDTOTO) throws Exception {
        if(personRepository.existsById(personRequestDTOTO.getId())) throw new PersonNotFoundIDException();
        Person person = personMapper.toModel(personRequestDTOTO);
        person.getAddresses().forEach(address -> address.setPerson(person));
        person.getPhones().forEach(phone -> phone.setPerson(person));
        return personMapper.toResponseDTO(personRepository.save(person));
    }

    @Transactional
    public BeerControlResponse<PersonResponseDTO> update(Long id, PersonRequestDTO personDTO) throws ExceptionPeopleManager {
        validIDPathAndBody(id,personDTO);
        if(personRepository.existsById(id)) throw new PersonNotFoundIDException();
        personDTO.setId(id);
        Person person = personMapper.toModel(personDTO);
        person.getAddresses().forEach(address -> address.setPerson(person));
        person.getPhones().forEach(phone -> phone.setPerson(person));
        return personMapper.toResponseDTO(personRepository.save(person));
    }

    @Transactional
    public void delete(Long id) throws PersonNotFoundIDException {
        Person person = personRepository.findById(id).orElseThrow(PersonNotFoundIDException::new);
        personRepository.delete(person);
    }

    private void validIDPathAndBody(Long idPhone, PersonRequestDTO personDTO) throws IDPathDifferentBodyException {
        if(personDTO.getId() == null || personDTO.getId() == 0 ) throw new IDPathDifferentBodyException();
        if(!idPhone.equals(personDTO.getId())) throw new IDPathDifferentBodyException();
    }
}
