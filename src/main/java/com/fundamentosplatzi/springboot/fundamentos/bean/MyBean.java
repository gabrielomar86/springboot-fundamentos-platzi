package com.fundamentosplatzi.springboot.fundamentos.bean;

import com.fundamentosplatzi.springboot.fundamentos.restconsuming.RickAndMorty;

public interface MyBean {
    void print();
    RickAndMorty consumirEndpointRickyMorty();
}
