package ayed.parcialesGrafos.parcial9Grafos;

import ayed.tp02.ejercicio2.ListaEnlazadaGenerica;
import ayed.tp02.ejercicio2.ListaGenerica;

public class Max {
    int max;
    ListaGenerica<String> estadios;

    public Max(){
        this.max=0;
        this.estadios= new ListaEnlazadaGenerica<String>();
    }

    public void setMax(int max){
        this.max = max;
    }

    public int getMax() {
        return max;
    }

    public void setCamino(ListaGenerica<String> estadios){
        this.estadios=estadios;
    }

    public ListaGenerica<String> getCamino() {
        return this.estadios;
    }

}
