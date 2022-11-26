package ayed.parcial1Arboles;

import ayed.tp02.ejercicio2.ListaEnlazadaGenerica;
import ayed.tp02.ejercicio2.ListaGenerica;
import ayed.tp03.ejercicio1.ArbolBinario;

public class RecorridoPares {
    
    public RecorridoPares(){

    }


    public ListaGenerica<Integer> resolver(ArbolBinario<Integer> ab, int min){
        boolean encontre=false;
        ListaGenerica<Integer> recorrido= new ListaEnlazadaGenerica<Integer>();
        ListaGenerica<Integer> actual= new ListaEnlazadaGenerica<Integer>();
        encontre= resolver(ab,recorrido,actual,min);
        if (encontre) return recorrido;
        else return null;
    }


    private boolean resolver(ArbolBinario<Integer> ab, ListaGenerica<Integer> recorrido, ListaGenerica<Integer> actual, int min) {
        if (ab.esHoja()){
            actual.agregarFinal(ab.getDato());
            if (this.cumpleCantPares(actual,min)){
                this.clonar(actual,recorrido,min);
                return true;
            }
            else{
                actual.eliminarEn(actual.tamanio());
                return false;
            }
        }
        else{
            boolean encontre= false;
            actual.agregarFinal(ab.getDato());
            if (ab.tieneHijoIzquierdo())
                encontre= this.resolver(ab.getHijoIzquierdo(), recorrido, actual, min);
            if (ab.tieneHijoDerecho())
                encontre= encontre || this.resolver(ab.getHijoDerecho(), recorrido,actual,min);
            actual.eliminarEn(actual.tamanio());
            return encontre;
        }
    }


    private void clonar(ListaGenerica<Integer> actual, ListaGenerica<Integer> recorrido, int min) {
        actual.comenzar();
        while (!actual.fin()){
            recorrido.agregarFinal(actual.proximo());
        }
    }


    private boolean cumpleCantPares(ListaGenerica<Integer> actual, int min) {
        int aux;
        int cantPares=0;
        actual.comenzar();
        while (!actual.fin()){
            aux= actual.proximo();
            if (aux % 2 == 0)
                cantPares++;
        }        
        return cantPares >= min;
    }


}
