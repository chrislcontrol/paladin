package com.paladin.paladin.dtos.auth;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AuthenticationOutputDTO {
    @JsonProperty("accessToken")
    private String accessToken;
}
