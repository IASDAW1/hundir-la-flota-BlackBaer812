/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.proyecto.hundirlaflota;

/**
 *
 * @author Marcos
 */
public class dd extends Barco{
    //Destructor
    
    //Atributos
    private String tipo;
    
    
    //constructor
    public dd(String nBarco){
        super(2,nBarco);
        this.tipo = "Destructor";
    }

    @Override
    public String getTipo() {
        return tipo;
    }
}
