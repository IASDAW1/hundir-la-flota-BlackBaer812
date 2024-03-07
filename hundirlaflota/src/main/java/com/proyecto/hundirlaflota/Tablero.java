/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.proyecto.hundirlaflota;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;


/**
 *Guarda los datos sobre la partida, como posiciones de barcos, de tiras y de daños
 * 
 * @author Marcos
 * @version 1.0
 */
public class Tablero {
    //Atributos
    //tableros
    private char [][] tablero; //Este tablero guardara el punto de golpe concreto de cada barco
    private char [][] tableroBarcos; //Este tablero guarda el el barco en si
    private char [][] tableroJuego; //Este tablero es el que usamor para representar la partida
    
    
    private ArrayList <Barco> barcos; //Este array lo usamos para guaras los barcos
    
    //Meteremos los numeros que vayamos generando
    private int [][] gener;
    
    
    /************************************/
    /************************************/
    
    //Constructor
    public Tablero(int filas, int columnas, ArrayList<Barco> barcos){ //Debemos de iniciarlo con el numero de columnas y fiilas, asi como con los barcos con los que jugaremos
        
        //Iniciamos los tableros
        this.tablero = new char [filas][columnas];
        this.tableroBarcos =  new char [filas][columnas];
        this.tableroJuego =  new char [filas][columnas];
        
        //iniciamos el tablero de generación de posiciones iniciales
        this.gener = new int [filas][columnas];
        
        //Iniciamos el array de los barcos
        this.barcos = barcos;
    }
    
    /************************************/
    /************************************/
    
    
    //Metodos
    public void iniTablero(){ //Creamos un tablero vacio
        for (int i = 0; i < tablero.length; i++) {
            for(int j =0; j < tablero[1].length; j++){
                tablero[i][j] = 126; //Tablero lleno con ~ a signo de niebla de guerra
                tableroJuego[i][j] = 126; //Tablero lleno con ~ a signo de niebla de guerra
                tableroBarcos[i][j] = 126; //Tablero lleno con ~ a signo de niebla de guerra
            }
        }
    }
    
    /************************************/
    /************************************/
    /************************************/
    
    
    //Esta función coloca los barcos en su posición es necesaria ponerla en el main
    public void colocarBarcoAle(){
        
        //Iniciamos las variables que usaremos
        boolean puesto = false; //Para saber si lo hemos puesto
        boolean seguir = true; //Controla que no nos quedemos sin posiciones
        int fila; //La fila aleatoria
        int colum; //La columna aleatoria
        int contNums = 0; //Contador para saber cuantos numero hemos generado
        
        
        for(Barco Barco:barcos){
            
            
            while(!puesto && contNums <= tablero.length*tablero.length){
                //Genero los números aleatorios
                fila = (int) (Math.random()*tablero.length);
                colum = (int) (Math.random()*tablero.length);
                
                //Comprobar en algun momento si la matriz de generados esta llena (no hay 0) para salir del bucle de generación y señalarlo en la salida
                
                //Si esta coordenada no se ha generado antes se introduce en la tabla de generaciones
                if(gener[fila][colum] == 0){
                    gener[fila][colum] = 1;
                    contNums++;
                    //Esto nos imprimiria la tabla de numeros generados en caso de necesitarlo para revisar el codigo.
                    /*for(int i = 0; i < gener.length; i++){
                        for(int j = 0; j<gener[i].length; j++){
                            System.out.print(gener[i][j]);
                        }
                        System.out.println("");
                    }
                    System.out.println("");*/

                    //Si se puede colocar lo colocamos
                    if(poner(Barco,fila,colum).get(0) && seguir){
                        colocar(Barco,fila,colum,poner(Barco,fila,colum));
                        puesto = true;
                    }
                }               
            }
            
            //En caso de que se hayan generado tados las posiciones aleatoria posible nos saldriamos
            if(contNums == tablero.length*tablero.length){
                System.out.println("No se pueden generar más posiciones aleatorias y se dejaran de colocar barcos");
                seguir = false;
            }
            
            //Reiniciamos los valores para colocar el Barco
            puesto = false;
        }
    }
    
    /************************************/
    /************************************/
    /************************************/
    
    //Funciones de la clase
    
    
    //Esta función pinta los barcos en los correspondientes tableros para su uso posterior
    private ArrayList<Boolean> poner(Barco bar, int fila, int colum){
        
        
        //Variable para saber si se puede poner
        ArrayList <Boolean> sal = new ArrayList <> (List.of(true,true));
        
        //En caso de que el indice 1 (el que esta en la posición 1) del array sea true este barco se tendra que poner hacia abajo
        //En caso de que el indice 1 (el que esta en la posición 1) del array sea false este barco se tendra que poner hacia la derecha
        //Si los dos son false no se puede poner en ningun sitio
        
        //comprobamos si se puede poner hacia abajo en este punto
        if((bar.size() + fila) < tablero.length){
            for(int i = fila; i < bar.size()+fila && sal.get(1); i++){ //Solo cambiamos la coordenada de la fila
                if(tablero[i][colum] != '~'){ //Si hay algun sitio que no sea "niebla" deberemos de decir que no se puede poner hacia abajo
                    sal.set(1, Boolean.FALSE); 
                }
            }
        }
        else{
            sal.set(1, Boolean.FALSE); //En caso de que el tamaño del barco + la fila sea mayor o igual al tamaño del tablero, no podremos poner el barco en el
        }
        
        //Comprobamos si se puede poner hacia la derecha en este punto
        if((bar.size() + colum) < tablero.length){
            for(int i = colum; i < bar.size()+colum && sal.get(0) && !sal.get(1); i++){ //En este bucle solo entrara si no se ha podido poner hacia la derecha
                if(tablero[fila][i] != '~'){//Si hay algun sitio que no sea "niebla" deberemos de decir que no se puede poner hacia la derecha
                    sal.set(0, Boolean.FALSE);
                }
            }
        }
        else{
            sal.set(0, Boolean.FALSE);//En caso de que el tamaño del barco + la columna sea mayor o igual al tamaño del tablero, no podremos poner el barco en el
        }
        

        //salida
        return sal;
    }   
    
    /************************************/
    /************************************/
    /************************************/
    
    private void colocar(Barco bar, int fila, int colum, ArrayList<Boolean> direction){ //El cuarto campo lo cogemos de la función poner
        //De Barco su nombre (que sera lo que pongamos en la matriz)
        //de direction usaremos el indice 1 ya que es el que indica la dirección

        char n = '0';
        
        if(direction.get(1)){ //En este caso pintamos hacia la derecha
            for(int i = fila; i < bar.size() + fila; i++){
                tablero[i][colum] = n; //pintamos la posición del daño del barco (desde 0 hasta barco.size())
                tableroBarcos[i][colum] = bar.getId(); //En el tablero de barcos ponemos a que barco corresponde esa casilla
                n++;
            }
        }
        else{ //En este caso pintamos hacia abajo
            for(int i = colum; i < bar.size() + colum; i++){
                tablero[fila][i] = n;
                tableroBarcos[fila][i] = bar.getId();
                n++;
            }
        }
    }
    
    /************************************/
    /************************************/
    /************************************/
    
    //Impresiones
    
    public void imprimirTablero(){
        for (int i = 0; i < tablero.length; i++) {
            for(int j =0; j < tablero[1].length; j++){
                System.out.print(tablero[i][j]);
            }
            System.out.println("");
        }
    }
    
    public void imprimirJuego(){
        for (int i = 0; i < tableroJuego.length; i++) {
            for(int j =0; j < tableroJuego[1].length; j++){
                System.out.print(tableroJuego[i][j]);
            }
            System.out.println("");
        }
    }
    
    public void imprimirTablerBarcos(){
        for (int i = 0; i < tableroBarcos.length; i++) {
            for(int j =0; j < tableroBarcos[1].length; j++){
                System.out.print(tableroBarcos[i][j]);
            }
            System.out.println("");
        }
    }
    
    
    
    /************************************/
    /************************************/
    /************************************/
    /************************************/
    /************************************/
    /************************************/
    
    //Metodo principal
    
    public void jugar(){
        //Empezamos el juego
        
        
        int nBarcos = barcos.size(); //Cuantos barcos quedan
        
        
        //Juego basico tablero 8 * 8 --> 5 barcos de tamaños(2,3,3,4,5) <-- Esto esta en el main
        
        //Iniciamos nuestro escaner
        Scanner sc = new Scanner(System.in);
        sc.useLocale(Locale.US);
        int dFila;
        int dCol;
        
        
        while(nBarcos > 0){ //bucle de juego que es mientras queden barcos
            System.out.println("Di las siguientes coordenadas (entre: "+ 1 + " y " + tablero[0].length + ")");
            System.out.print("Fila: ");
            dFila = sc.nextInt() - 1; //Le restamos 1 ya que va desde 0 a 7 realmente
            System.out.print("Columna: ");
            dCol = sc.nextInt() - 1; //Le restamos 1 ya que va desde 0 a 7 realmente
            if(dFila < tablero.length && dCol < tablero[dFila].length && dFila > 0 && dCol > 0){ //Si el punto esta dentro del tablero se comprueba si es agua o no
                if(tableroBarcos[dFila][dCol] == '~'){ //En caso de ser agua se pone 0
                    tableroJuego[dFila][dCol] = '0'; //si fallamos pintamos 0
                }else{ //Si no es agua
                    for(Barco barco:barcos){
                        if(barco.getId() == tableroBarcos[dFila][dCol]){ //Miramos a ver que barco es
                            barco.hundidoParte(tablero[dFila][dCol]-48);
                                //restamos 48 ya que es un array de chars y para pasarlo al metodo hundirParte necesitamos ponerlo en 0 para el tipo de datos int
                            tableroJuego[dFila][dCol] = 'x';//pintamos x cuando le hemos dado
                            if(barco.hundido()){ //Si el barco lo hemos hundido
                                System.out.println("Has hundido el " + barco.getTipo() + ": " + barco.getNombre());
                                System.out.println("/****************************/");
                                System.out.println("/****************************/");
                                System.out.println("/****************************/");
                                nBarcos--;
                            }
                        }
                    }
                }
            }else{
                System.out.println("Las coordenadas introducidas no son correctas");
            }

            
            //imprimimos la situación del juego
            imprimirJuego();
        }
        
        System.out.println("");
        System.out.println("/****************************/");
        System.out.println("/****************************/");
        System.out.println("/****************************/");
        System.out.println("Felicidades has ganado");
        
        sc.close();
    }
}
