package com.dio.sawcunha.beercontrol.dto.request;

import com.dio.sawcunha.beercontrol.enums.eSex;
import lombok.*;

import javax.validation.Valid;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class PersonRequestDTO {
    private Long id;

    @NotNull
    @NotEmpty
    private String name;
    @NotNull
    @NotEmpty
    private String surname;
    @NotEmpty
    @NotNull(message = "BICV-007")
    private String taxIdentifier;
    @NotNull
    private LocalDate birthday;
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
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    public static class PersonPhoneDTO {
        private Long id;

        @NotNull(message = "BICV-009")
        @Positive(message = "BICV-009")
        @Max(value = 999, message = "BICV-009")
        private Integer prefixInternattional;

        @Positive
        @Max(value = 99,message = "BICV-010")
        private Integer prefixNational;
        @NotNull(message = "BICV-011")
        @NotEmpty(message = "BICV-011")
        private String number;
    }
}
