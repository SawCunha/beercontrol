package com.dio.sawcunha.beercontrol.service;

import com.dio.sawcunha.beercontrol.entity.Person;
import com.dio.sawcunha.beercontrol.entity.Phone;
import com.dio.sawcunha.beercontrol.exception.error.ExceptionPeopleManager;
import com.dio.sawcunha.beercontrol.exception.error.IDPathDifferentBodyException;
import com.dio.sawcunha.beercontrol.exception.error.PersonNotFoundIDException;
import com.dio.sawcunha.beercontrol.exception.error.PhoneNotFoundIDException;
import com.dio.sawcunha.beercontrol.mapper.PhoneMapper;
import com.dio.sawcunha.beercontrol.repository.PersonRepository;
import com.dio.sawcunha.beercontrol.repository.PhoneRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class PhoneImplementationService {

    private final PhoneRepository phoneRepository;
    private final PersonRepository personRepository;
    private final PhoneMapper phoneMapper;

    @Transactional(readOnly = true)
    public List<PhoneDTO> findAll(){
        return phoneMapper.toDTOs(phoneRepository.findAll());
    }

    @Transactional(readOnly = true)
    public PhoneDTO findById(Long id, boolean inforPerson) throws PhoneNotFoundIDException {
        PhoneDTO phoneDTO;
        if(inforPerson){
            phoneDTO = phoneMapper.toDTO(phoneRepository.findById(id).orElseThrow(PhoneNotFoundIDException::new));
        } else {
            phoneDTO = phoneRepository.findByIDDTO(id).orElseThrow(PhoneNotFoundIDException::new);
        }
        return phoneDTO;
    }

    @Transactional(readOnly = true)
    public List<PhoneDTO> findByidPerson(Long idPerson) throws PhoneNotFoundIDException {
        return phoneRepository.findByIDPersonDTO(idPerson).orElseThrow(PhoneNotFoundIDException::new);
    }

    @Transactional
    public void delete(Long id) throws PhoneNotFoundIDException {
        Phone phone = phoneRepository.findById(id).orElseThrow(PhoneNotFoundIDException::new);
        phoneRepository.delete(phone);
    }

    @Transactional
    public PhoneDTO createPhonePerson(Long idPerson, PhoneDTO phoneDTO) throws ExceptionPeopleManager {
        Person person = personRepository.findById(idPerson).orElseThrow(PersonNotFoundIDException::new);
        phoneDTO.setPerson(null);
        Phone phone = phoneMapper.toModel(phoneDTO);
        phone.setPerson(person);
        return phoneMapper.toDTO(phoneRepository.save(phone));
    }

    @Transactional
    public PhoneDTO updatePhonePerson(Long id, PhoneDTO phoneDTO)throws ExceptionPeopleManager {
        validIDPathAndBody(id,phoneDTO);
        Phone phone = phoneRepository.findById(id).orElseThrow(PhoneNotFoundIDException::new);
        phoneDTO.setPerson(null);
        Phone phoneUpdate = phoneMapper.toModel(phoneDTO);
        phoneUpdate.setPerson(phone.getPerson());
        phoneUpdate.setId(phone.getId());
        return phoneMapper.toDTO(phoneRepository.save(phoneUpdate));
    }

    private void validIDPathAndBody(Long idPhone, PhoneDTO phoneDTO) throws IDPathDifferentBodyException {
        if(phoneDTO.getId() == null || phoneDTO.getId() == 0 ) throw new IDPathDifferentBodyException();
        if(!idPhone.equals(phoneDTO.getId())) throw new IDPathDifferentBodyException();
    }
}
