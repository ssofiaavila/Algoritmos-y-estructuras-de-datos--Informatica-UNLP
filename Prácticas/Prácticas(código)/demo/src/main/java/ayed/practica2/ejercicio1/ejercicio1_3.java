package ayed.practica2.ejercicio1;

import ayed.tp02.ejercicio1.ListaDeEnterosEnlazada;

public class ejercicio1_3 {
    public static void main (String[]args){

        ListaDeEnterosEnlazada lista= new ListaDeEnterosEnlazada();
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
