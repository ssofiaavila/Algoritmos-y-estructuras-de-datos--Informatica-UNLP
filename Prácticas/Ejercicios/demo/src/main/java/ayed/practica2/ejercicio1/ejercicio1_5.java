package ayed.practica2.ejercicio1;

import ayed.tp02.ejercicio1.ListaDeEnterosEnlazada;

public class ejercicio1_5 {
   public static void main(String[] args){
    ListaDeEnterosEnlazada lista= new ListaDeEnterosEnlazada();
    lista.agregarFinal(25);
    lista.agregarFinal(10);
    lista.agregarFinal(16);
    lista.agregarFinal(11);
    lista.comenzar();
    int indice=0;
    ejercicio1_5.imprimirInverso(lista,indice);

   }

private static void imprimirInverso(ListaDeEnterosEnlazada lista, int indice) {

    if (indice <= lista.tamanio()){        
        ejercicio1_5.imprimirInverso(lista,indice+1);    
        System.out.println(lista.elemento(indice));   
    }
    

} 
}
