package com.example.day3.dto;

import lombok.ToString;

@ToString
public class GreetingDto {
    public String fName;
    public String lName;

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
}
