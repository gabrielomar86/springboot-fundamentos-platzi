package com.fundamentosplatzi.springboot.fundamentos.component;

import org.springframework.stereotype.Component;

@Component
public class ComponentImplementation implements ComponentDependency{

    @Override
    public void Saludar() {
        System.out.println("Hola desde ComponentImplementation");
    }
    

}

