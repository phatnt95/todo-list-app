package com.example.demo.payload.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class JwtAuthenticationResponse {
    private String jwt;

    @Override
    public String toString() {
        return "{" +
                "jwt='" + jwt + '\'' +
                '}';
    }
}
