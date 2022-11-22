package ayed.tp02.ejercicio3;

import ayed.tp02.ejercicio2.ListaEnlazadaGenerica;
import ayed.tp02.ejercicio2.ListaGenerica;

public class ColaGenerica<T> {
    private ListaGenerica<T> datos= new ListaEnlazadaGenerica<T>();  

    public void encolar(T elem){
        this.datos.agregarFinal(elem);        
    }

    public T desencolar(){
        T elem= datos.elemento(1);
        this.datos.eliminarEn(1);
        return elem;
    }

    public T tope(){
        T elem= this.datos.elemento(1);
        return elem;
    }
    public boolean esVacia(){
        return this.datos.esVacia();
    }

}

