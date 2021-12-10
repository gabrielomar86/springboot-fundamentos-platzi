package com.fundamentosplatzi.springboot.fundamentos.bean;

public class MyBeanWithPropertiesImplementation implements MyBeanWithProperties{

    private String name;
    
    private String apellido;
    
    private String random;

    public MyBeanWithPropertiesImplementation(String name, String apellido, String random) {
        this.name = name;
        this.apellido = apellido;
        this.random = random;
    }

    @Override
    public void printProperty() {
        System.out.println("Name: " + name);
        System.out.println("apellido: " + apellido);
        System.out.println("random: " + random);
    }
    
}
