package ayed.tp02.ejercicio3;

import ayed.tp02.ejercicio2.ListaGenerica;

public class PilaGenerica<T> {
    private ListaGenerica<T> datos;

    public void apilar(T elem){
        this.datos.agregarFinal(elem);
    }

    public T desapilar(){
        T elem= datos.elemento(this.datos.tamanio());
        this.datos.eliminarEn(this.datos.tamanio());
        return elem;
    }

    public T tope(){
        return this.datos.elemento(this.datos.tamanio());
    }

    public boolean esVacia(){
        return this.datos.esVacia();
    }

}
