package com.dio.sawcunha.beercontrol.repository;

import com.dio.sawcunha.beercontrol.dto.response.PhoneResponseDTO;
import com.dio.sawcunha.beercontrol.entity.Phone;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PhoneRepository extends JpaRepository<Phone, Long> {

    @Query("SELECT NEW com.dio.sawcunha.beercontrol.dto.response.PhoneResponseDTO(p.id,p.prefixInternattional,p.prefixNational,p.numberPhone) FROM Phone p WHERE p.person.id = :idPerson")
    Optional<List<PhoneResponseDTO>> findByIDPersonDTO(Long idPerson);

    @Query("SELECT NEW com.dio.sawcunha.beercontrol.dto.response.PhoneResponseDTO(p.id,p.prefixInternattional,p.prefixNational,p.numberPhone) FROM Phone p WHERE p.id = :id")
    Optional<PhoneResponseDTO> findByIDDTO(Long id);

    @Query("SELECT p FROM Phone p WHERE p.person.id = :idPerson")
    Optional<Phone> findByIDPerson(Long idPerson);

}
