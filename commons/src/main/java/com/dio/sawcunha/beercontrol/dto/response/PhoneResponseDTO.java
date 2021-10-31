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
