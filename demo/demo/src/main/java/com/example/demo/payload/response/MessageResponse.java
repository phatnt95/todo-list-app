package com.example.demo.payload.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class MessageResponse {
    private String message;

    @Override
    public String toString() {
        return "{" +
                    "message: '" + message + '\'' +
                '}';
    }
}
