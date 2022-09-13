package ayed.practica2;

import ayed.tp02.*;
import ayed.tp02.ejercicio1.ListaDeEnterosConArreglos;
public class ejercicio1_2 {
    public static void main (String[]args){

        ListaDeEnterosConArreglos lista= new ListaDeEnterosConArreglos();
        lista.agregarFinal(25);
        lista.agregarFinal(10);
        lista.agregarFinal(16);
        lista.agregarFinal(11);
        lista.comenzar();
        while (!lista.fin()){
            System.out.println(lista.proximo());
        }

    }
}
