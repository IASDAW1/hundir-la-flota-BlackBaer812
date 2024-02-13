/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.proyecto.hundirlaflota;

/**
 *
 * @author Marcos
 */
public class cc extends Barco{
    //Crucero
    
    //Atributos
    private String tipo;
    
    
    //constructor
    public cc(String nBarco){
        super(3,nBarco);
        this.tipo = "Crucero";
    }

    @Override
    public String getTipo() {
        return tipo;
    }
    
    
}
