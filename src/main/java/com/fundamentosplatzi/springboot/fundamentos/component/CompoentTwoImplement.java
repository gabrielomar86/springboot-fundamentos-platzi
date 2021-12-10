package com.fundamentosplatzi.springboot.fundamentos.component;

import org.springframework.stereotype.Component;

@Component
public class CompoentTwoImplement implements ComponentDependency {

    @Override
    public void Saludar() {
        System.out.println("Hola desde Componente 2");
    }
}
