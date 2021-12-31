package com.dio.sawcunha.beercontrol.dto.response;

import com.dio.sawcunha.beercontrol.enums.eSex;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PhoneResponseDTO {

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

    private PhonePersonDTO person;

    public PhoneResponseDTO(Long id, Integer prefixInternattional, Integer prefixNational, String number) {
        this.id = id;
        this.prefixInternattional = prefixInternattional;
        this.prefixNational = prefixNational;
        this.number = number;
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    public static class PhonePersonDTO {
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
