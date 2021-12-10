package com.fundamentosplatzi.springboot.fundamentos.restconsuming;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class RickAndMorty {
    public Info info;
    public Result[] results;
}
