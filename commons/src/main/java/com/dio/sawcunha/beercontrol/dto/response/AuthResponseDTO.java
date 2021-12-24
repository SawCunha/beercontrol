package com.dio.sawcunha.beercontrol.dto.response;

import lombok.*;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class AuthResponseDTO {

    private String token;
    private LocalDateTime request;
    private Integer expiretion;
    private LocalDateTime expiretionTime;

}
