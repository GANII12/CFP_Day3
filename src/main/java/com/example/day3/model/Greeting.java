package com.example.day3.model;

import com.example.day3.dto.GreetingDto;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "greet")
public class Greeting {
    @Id
    @GeneratedValue
    private Long id;
    private String content;

    private String fName;
    private String lName;

    public Greeting(String fName, String lName) {
        this.fName = fName;
        this.lName = lName;
    }

    public void contactGreeting(GreetingDto greetingDto){
        this.fName = greetingDto.fName;
        this.lName = greetingDto.lName;
    }

    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public String getlName() {
        return lName;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }

    public Greeting(Long id, String content) {
        this.id = id;
        this.content = content;
    }

    public Greeting() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
