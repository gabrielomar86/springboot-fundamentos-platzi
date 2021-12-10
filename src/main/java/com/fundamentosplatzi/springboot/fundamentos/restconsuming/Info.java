package com.fundamentosplatzi.springboot.fundamentos.restconsuming;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Info {
    public Integer count;
    public Integer pages;
    public String next;
    public Integer prev;
}
