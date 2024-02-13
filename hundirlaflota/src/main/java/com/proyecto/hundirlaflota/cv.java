/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.proyecto.hundirlaflota;

/**
 *
 * @author Marcos
 */
public class cv extends Barco {
    //Portaaviones
    
    //Atributos
    private String tipo;
    
    
    //constructor
    public cv(String nBarco){
        super(5,nBarco);
        this.tipo = "Portaaviones";
    }
    
    @Override
    public String getTipo() {
        return tipo;
    }
    
    
}
