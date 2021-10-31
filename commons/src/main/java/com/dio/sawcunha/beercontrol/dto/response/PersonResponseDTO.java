package com.dio.sawcunha.beercontrol.dto.response;

import com.dio.sawcunha.beercontrol.enums.eSex;
import lombok.*;
import org.hibernate.validator.constraints.br.CPF;

import javax.validation.Valid;
import javax.validation.constraints.*;
import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class PersonResponseDTO {
    private Long id;

    @NotNull
    @NotEmpty
    private String name;
    @NotNull
    @NotEmpty
    private String surname;
    @NotEmpty
    @CPF(message = "The CPF informed must be valid")
    private String cpf;
    @NotNull
    private LocalDate birthday;
    @NotNull
    @NotEmpty
    @Email(message = "The e-mail informed must be valid")
    private String email;
    @NotNull
    @NotEmpty
    private String description;
    @NotNull
    private eSex sex;

    @Valid
    List<PersonAddressDTO> addresses;
    @Valid
    List<PersonPhoneDTO> phones;

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    public static class PersonAddressDTO {
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
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    public static class PersonPhoneDTO {
        private Long id;

        @NotNull(message = "The international prefix must be between 1 to 999")
        @Positive(message = "The international prefix must be between 1 to 999")
        @Max(value = 999, message = "The international prefix must be between 1 to 999")
        private Integer prefixInternattional;

        @Positive
        @Max(value = 99,message = "The national prefix must be between 1 to 99")
        private Integer prefixNational;
        @NotNull(message = "The phone number must be entered")
        @NotEmpty(message = "The phone number must be entered")
        private String number;
    }
}
