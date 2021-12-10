package com.fundamentosplatzi.springboot.fundamentos.bean;

import com.fundamentosplatzi.springboot.fundamentos.configuration.MyConfigurationBean;
import com.fundamentosplatzi.springboot.fundamentos.restconsuming.RickAndMorty;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MyBeanImplement implements MyBean {

    @Autowired   
    MyConfigurationBean restTemplate;

    @Override
    public void print() {
        System.out.println("Hello World My Bean");
    }

    @Override
    public RickAndMorty consumirEndpointRickyMorty() {
        return restTemplate.getForObject(
            "https://rickandmortyapi.com/api/character", 
            RickAndMorty.class);
    }

}
