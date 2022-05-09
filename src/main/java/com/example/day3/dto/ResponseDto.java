package com.example.day3.dto;

import com.example.day3.model.Greeting;

import java.util.List;

public class ResponseDto {
    public ResponseDto(String message, List<Greeting> greeting) {
    }

    public ResponseDto(String message, Greeting contactData) {
    }
}
