package com.example.day3.exception;

import com.example.day3.dto.GreetingDto;
import com.example.day3.dto.ResponseDto;
import com.example.day3.model.Greeting;
import com.example.day3.services.GreetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public class UserException extends RuntimeException {
    @Autowired
    private GreetingService greetingService;

    public UserException(String message) {
        super(message);
    }

    @GetMapping("/getAllUser")
    public ResponseEntity<ResponseDto> getUsers(){
        List<Greeting> greeting = greetingService.getAllUsers();
        ResponseDto response = new ResponseDto("Get call Success" , greeting);
        return new ResponseEntity<ResponseDto>(response , HttpStatus.OK);
    }

    @PostMapping("/addUser")
    public ResponseEntity<ResponseDto> createContactData(@RequestParam GreetingDto greetingDto){
        Greeting contactData = greetingService.createContact(greetingDto);
        ResponseDto response = new ResponseDto("Created contact data for",contactData);
        return new ResponseEntity<ResponseDto>(response,HttpStatus.OK);
    }


}
