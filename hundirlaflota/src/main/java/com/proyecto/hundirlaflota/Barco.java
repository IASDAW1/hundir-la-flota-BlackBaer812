/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.proyecto.hundirlaflota;

import java.util.ArrayList;

/**
 *
 * @author Marcos
 */
public abstract class Barco {
    //Atributos
    protected int longitud; //logitud del barco
    protected String nombre; //Nombre del barco
    protected char id; //id inequivoco para luego contar daños
    protected ArrayList<Boolean> danos = new ArrayList<>(); //Array de los golpes que puede recivir
    protected static char cuenta = '1'; //cuenta completamente automática
    
    //Constructores
    /**
     * Constructor vacio
     */
    public Barco(){ //constructor vacio (No lo usaremos)
        this.longitud = 0;
        this.nombre = "";
        this.id = cuenta;
        cuenta++;
        for(int i=0; i < this.longitud; i++){
            this.danos.add(Boolean.FALSE);
        }
    }
    
    /**
     * Constructor de la clase barco
     * @param lon Indica longitud
     * @param nBarco Indica el nombre del barco
     */
    public Barco(int lon, String nBarco){ //Constructor básico
        this.longitud = lon;
        this.nombre = nBarco;
        this.id = cuenta;
        cuenta++;
        for(int i=0; i < this.longitud; i++){ //Iniciamos el array de daños con todos falsos
            this.danos.add(Boolean.FALSE);
        }
    }
    
    //metodos
    public boolean hundido(){
        //Iniciamos las variables
        boolean hundido=false;
        int dano = 0;
        //Comprobamos si todos sus puntos de daños son verdaderos
        for(int i=0;i < this.danos.size(); i++){
            if(danos.get(i)){
                dano++;
            }
            //System.out.println(danos.get(i));
        }
        //Si todos son verdaderos devolveremos true
        if(dano == this.longitud){
            hundido = true;
        }
        return hundido;
    }
    
    
    public void hundidoParte(int parte){ //parte solo puede ir desde 0 hasta la logitud menos 1
        if(0 <= parte || parte < this.longitud){ //Si la parte es correcta cambiaremos la parte a verdadera
            this.danos.set(parte, true);
        }
        else{
            System.out.println("Error"); //Si no dara un error
        }
    }
    
    
    public int size(){
        return this.longitud;
    }
    
    public String getNombre(){
        return this.nombre;
    }

    public char getId() {
        return id;
    }
    
    abstract String getTipo(); //metodo para los tipos derivados
}
