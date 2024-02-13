/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.proyecto.hundirlaflota;

import java.util.ArrayList;

/**
 *
 * @author Marcos
 */
public class Hundirlaflota {

    public static void main(String[] args) {
        
        /**********necesario*********/
        ArrayList <Barco> barcos = new ArrayList<>();
        barcos.add(new cv("USS Honolulu"));
        barcos.add(new bb("USS Ohio"));
        barcos.add(new cc("USS Pensacola"));
        barcos.add(new ss("USS Los Angeles"));
        barcos.add(new dd("USS Captain Kidd"));
        
        
        Tablero tablero = new Tablero(8, 8, barcos);
        
        tablero.iniTablero();
        
        tablero.colocarBarcoAle();
        
        tablero.jugar();
        
        /****************************/
        
        /*******no necesario*********/
        /****************************/
        /*
        System.out.println("****************************");
        System.out.println("****************************");
        System.out.println("****************************");
        
        System.out.println("");
        System.out.println("imprimirTablero:");
        tablero.imprimirTablero();
        
        
        System.out.println("");
        System.out.println("imprimirJuego:");
        tablero.imprimirJuego();
        
        System.out.println("");
        System.out.println("ImprimirTableroBarcos");
        tablero.imprimirTablerBarcos();
        */
        
        
    }
}
