package com.dio.sawcunha.beercontrol.dto.response;

import com.dio.sawcunha.beercontrol.enums.eSex;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AddressResponseDTO {

    private Long id;
    @NotEmpty(message = "BICV-003")
    private String zipCode;
    @NotEmpty(message = "BICV-003")
    private String city;
    @NotEmpty(message = "BICV-003")
    private String addressName;
    @NotEmpty(message = "BICV-003")
    private String state;
    @NotEmpty(message = "BICV-003")
    private String street;
    @NotEmpty(message = "BICV-003")
    private String country;
    @NotNull(message = "BICV-004")
    @Positive(message = "BICV-004")
    private Integer number;
    private String block;
    private String complement;
    private String reference;

    public AddressResponseDTO(Long id, String zipCode, String city, String addressName, String state, String street, String country, Integer number, String block, String complement, String reference) {
        this.id = id;
        this.zipCode = zipCode;
        this.city = city;
        this.addressName = addressName;
        this.state = state;
        this.street = street;
        this.country = country;
        this.number = number;
        this.block = block;
        this.complement = complement;
        this.reference = reference;
    }

    private AddressPersonDTO person;

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    public static class AddressPersonDTO {
        private Long id;
        private String name;
        private String surname;
        private String cpf;
        private LocalDate birthday;
        private String email;
        private String description;
        private eSex sex;
    }

}
