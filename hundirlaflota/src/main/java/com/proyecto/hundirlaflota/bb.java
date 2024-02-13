/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.proyecto.hundirlaflota;

/**
 *
 * @author Marcos
 */
public class bb extends Barco{
    //Acorazado
    
    //Atributos
    private String tipo;
    
    
    //constructor
    public bb(String nBarco){
        super(4, nBarco);
        this.tipo = "Acorazado";
    }

    @Override
    public String getTipo() {
        return tipo;
    }
    
    
}
