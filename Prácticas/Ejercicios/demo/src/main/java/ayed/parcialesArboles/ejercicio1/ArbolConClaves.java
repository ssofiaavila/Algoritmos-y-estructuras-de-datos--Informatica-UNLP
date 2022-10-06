package ayed.parcialesArboles.ejercicio1;

import ayed.tp02.ejercicio2.ListaEnlazadaGenerica;
import ayed.tp02.ejercicio2.ListaGenerica;
import ayed.tp04.ejercicio1.ArbolGeneral;

public class ArbolConClaves {
    private ArbolGeneral<Integer> ab;

    public ArbolConClaves(ArbolGeneral<Integer> ab){
        this.ab = ab;
    }



    public ListaGenerica<Integer> recorridoPorClaves() {
        ListaGenerica<Integer> recorrido= new ListaEnlazadaGenerica<Integer>();
        recorridoPorClaves(this.ab,recorrido);
        return recorrido;
    }



    private void recorridoPorClaves(ArbolGeneral<Integer> ab, ListaGenerica<Integer> recorrido) {
        recorrido.agregarFinal(ab.getDato());
        if (ab.tieneHijos()){
            ListaGenerica<ArbolGeneral<Integer>> hijos= ab.getHijos();
            hijos.comenzar();
            int cant=0;
            ArbolGeneral<Integer> aux;
            while (!hijos.fin()){
                aux=hijos.proximo();
                cant++;
                if (cant== ab.getDato()){
                    recorridoPorClaves(aux,recorrido);
                }
            }
            
        }




    }
}


