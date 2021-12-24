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
    @NotEmpty(message = "It is mandatory to inform the Zip Code")
    private String zipCode;
    @NotEmpty(message = "It is mandatory to inform the City")
    private String city;
    @NotEmpty(message = "It is mandatory to inform the name the Address")
    private String addressName;
    @NotEmpty(message = "It is mandatory to inform the State")
    private String state;
    @NotEmpty(message = "It is mandatory to inform the Street")
    private String street;
    @NotEmpty(message = "It is mandatory to inform the Country")
    private String country;
    @NotNull(message = "The house number must be greater than 1.")
    @Positive(message = "The house number must be greater than 1.")
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
