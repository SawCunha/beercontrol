package com.dio.sawcunha.beercontrol.service;

import com.dio.sawcunha.beercontrol.dto.request.PhoneRequestDTO;
import com.dio.sawcunha.beercontrol.dto.response.PhoneResponseDTO;
import com.dio.sawcunha.beercontrol.entity.Person;
import com.dio.sawcunha.beercontrol.entity.Phone;
import com.dio.sawcunha.beercontrol.exception.error.IDPathDifferentBodyException;
import com.dio.sawcunha.beercontrol.exception.error.PersonNotFoundIDException;
import com.dio.sawcunha.beercontrol.exception.error.PhoneNotFoundIDException;
import com.dio.sawcunha.beercontrol.mapper.PhoneMapper;
import com.dio.sawcunha.beercontrol.model.BeerControlResponse;
import com.dio.sawcunha.beercontrol.repository.PersonRepository;
import com.dio.sawcunha.beercontrol.repository.PhoneRepository;
import com.dio.sawcunha.beercontrol.specification.service.PhoneService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.mail.MethodNotSupportedException;
import java.util.List;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class PhoneImplementationService implements PhoneService {

    private final PhoneRepository phoneRepository;
    private final PersonRepository personRepository;
    private final PhoneMapper phoneMapper;

    @Transactional(readOnly = true)
    public BeerControlResponse<List<PhoneResponseDTO>> findAll(){
        return phoneMapper.toResponseDTOs(phoneRepository.findAll());
    }

    @Override
    public BeerControlResponse<PhoneResponseDTO> findById(Long id) throws Exception {
        return phoneMapper.toResponseDTO(phoneRepository.findById(id).orElseThrow(PhoneNotFoundIDException::new));
    }

    @Override
    public BeerControlResponse<PhoneResponseDTO> save(PhoneRequestDTO phoneRequestDTO) throws Exception {
        throw new MethodNotSupportedException();
    }

    @Override
    public BeerControlResponse<?> update(PhoneRequestDTO entityRequest) throws Exception {
        throw new MethodNotSupportedException();
    }

    @Transactional(readOnly = true)
    public BeerControlResponse<PhoneResponseDTO> findById(Long id, boolean inforPerson) throws Exception {
        PhoneResponseDTO phoneDTO;
        if(inforPerson){
            phoneDTO = phoneMapper.toDTO(phoneRepository.findById(id).orElseThrow(PhoneNotFoundIDException::new));
        } else {
            phoneDTO = phoneRepository.findByIDDTO(id).orElseThrow(PhoneNotFoundIDException::new);
        }
        return BeerControlResponse.<PhoneResponseDTO>builder().data(phoneDTO).build();
    }

    @Transactional(readOnly = true)
    public BeerControlResponse<List<PhoneResponseDTO>> findByidPerson(Long idPerson) throws Exception {
        return BeerControlResponse.<List<PhoneResponseDTO>>builder()
                .data(phoneRepository.findByIDPersonDTO(idPerson).orElseThrow(PhoneNotFoundIDException::new))
                .build();
    }

    @Transactional
    public void delete(Long id) throws PhoneNotFoundIDException {
        Phone phone = phoneRepository.findById(id).orElseThrow(PhoneNotFoundIDException::new);
        phoneRepository.delete(phone);
    }

    @Transactional
    public BeerControlResponse<PhoneResponseDTO> save(Long idPerson, PhoneRequestDTO phoneDTO) throws Exception {
        Person person = personRepository.findById(idPerson).orElseThrow(PersonNotFoundIDException::new);
        phoneDTO.setPerson(null);
        Phone phone = phoneMapper.toModel(phoneDTO);
        phone.setPerson(person);
        return phoneMapper.toResponseDTO(phoneRepository.save(phone));
    }

    @Transactional
    public BeerControlResponse<PhoneResponseDTO> update(Long id, PhoneRequestDTO phoneDTO)throws Exception {
        validIDPathAndBody(id,phoneDTO);
        Phone phone = phoneRepository.findById(id).orElseThrow(PhoneNotFoundIDException::new);
        phoneDTO.setPerson(null);
        Phone phoneUpdate = phoneMapper.toModel(phoneDTO);
        phoneUpdate.setPerson(phone.getPerson());
        phoneUpdate.setId(phone.getId());
        return phoneMapper.toResponseDTO(phoneRepository.save(phoneUpdate));
    }

    private void validIDPathAndBody(Long idPhone, PhoneRequestDTO phoneDTO) throws Exception {
        if(phoneDTO.getId() == null || phoneDTO.getId() == 0 ) throw new IDPathDifferentBodyException();
        if(!idPhone.equals(phoneDTO.getId())) throw new IDPathDifferentBodyException();
    }
}
