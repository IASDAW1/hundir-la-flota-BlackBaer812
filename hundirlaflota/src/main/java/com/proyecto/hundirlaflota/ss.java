/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.proyecto.hundirlaflota;

/**
 *
 * @author Marcos
 */
public class ss extends Barco{
    //Submarino
    
    //Atributos
    private String tipo;
    
    
    //constructor
    public ss(String nBarco){
        super(3,nBarco);
        this.tipo = "Submarino";
    }

    @Override
    public String getTipo() {
        return tipo;
    }
    
    
}
