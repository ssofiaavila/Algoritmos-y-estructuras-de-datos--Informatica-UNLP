package ayed.parcialesGrafos.fecha1OtraVez;

import ayed.tp02.ejercicio2.ListaGenerica;

public class Max {
    private int maxCantidad;
    private ListaGenerica<String> listaEstadios;

    public Max(){
        this.maxCantidad =0;
        this.listaEstadios =null;
    }

    public void setMax(int max){
        this.maxCantidad =max;
    }
    public int getMax(){
        return this.maxCantidad;
    }

    public void setLista(ListaGenerica<String> estadios){
        this.listaEstadios=estadios;
    }

    public ListaGenerica<String> getLista(){
        return this.listaEstadios;
    }

}
