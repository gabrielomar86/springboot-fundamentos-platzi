package com.fundamentosplatzi.springboot.fundamentos.restconsuming;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Result {
    public Integer id;    
    public String name;
    public String status;
    public String species;
    public String gender;
}
