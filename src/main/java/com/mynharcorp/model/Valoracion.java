/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mynharcorp.model;

/**
 *
 * @author harold
 */
public enum Valoracion {
    
    UNO (Short.valueOf("1")),
    DOS(Short.valueOf("2")),
    TRES(Short.valueOf("3")),
    CUATRO(Short.valueOf("4")),
    CINCO(Short.valueOf("5"));

    
    
        //Campos tipo constante   

    private final short numero; //Color de la madera

    

 

    /**

     * Constructor. Al asignarle uno de los valores posibles a una variable del tipo enumerado el constructor asigna 

        automáticamente valores de los campos

     */ 

    Valoracion (short numero) { 

        this.numero = numero;        

    } //Cierre del constructor

 

    //Métodos de la clase tipo Enum

    public short getNumero() { return numero; }

    
}
