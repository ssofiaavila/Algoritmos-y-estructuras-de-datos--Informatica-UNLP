package ayed.parcialesArboles.ejercicio8;

import ayed.tp02.ejercicio2.ListaEnlazadaGenerica;
import ayed.tp02.ejercicio2.ListaGenerica;
import ayed.tp04.ejercicio1.ArbolGeneral;

public class SumaNodos {
    private ArbolGeneral<Integer> ab;

    public SumaNodos(ArbolGeneral<Integer> ab){
        this.ab = ab;
    }

    public ListaGenerica<Integer> resolver(){
        ListaGenerica<Integer> lista= new ListaEnlazadaGenerica<Integer>();
        this.resolver(ab,lista);
        return lista;
    }

    //en post orden, proceso hijos y dsp nodo
    private int resolver(ArbolGeneral<Integer> ab, ListaGenerica<Integer> lista) {
        if (ab.esHoja()){
            return ab.getDato();
        }

        else{ 
            int suma=0;
            ListaGenerica<ArbolGeneral<Integer>> hijos= ab.getHijos();
            hijos.comenzar();            
            while (!hijos.fin()){
                suma+=resolver(hijos.proximo(), lista);
            }
            if (hijos.tamanio() % 2 == 1) lista.agregarFinal(suma);
            
            return ab.getDato();
        }
    }

    
    
}
