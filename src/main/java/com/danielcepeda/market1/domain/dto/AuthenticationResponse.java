package com.danielcepeda.market1.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AuthenticationResponse {
    private String jwt;

}
