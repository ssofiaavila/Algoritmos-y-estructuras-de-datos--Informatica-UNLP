package ayed.parcialesArboles.ejercicio6;

import ayed.tp02.ejercicio2.ListaEnlazadaGenerica;
import ayed.tp02.ejercicio2.ListaGenerica;
import ayed.tp02.ejercicio3.ColaGenerica;
import ayed.tp03.ejercicio1.ArbolBinario;

public class NivelArbol {
    private ArbolBinario<Integer> ab;

    public NivelArbol(ArbolBinario<Integer> ab){
        this.ab = ab;
    }

    public ArbolBinario<Integer> minEnNivelAB(int nivel){
        int nivelAct=0;
        boolean encontrado=false;

        ListaEnlazadaGenerica<ArbolBinario<Integer>> nodosNivel= new ListaEnlazadaGenerica<ArbolBinario<Integer>>();
        ArbolBinario<Integer> aux= null;
        ArbolBinario<Integer> menor= null;
        ColaGenerica<ArbolBinario<Integer>> cola= new ColaGenerica<ArbolBinario<Integer>>();
        int minValor= 10000;

        cola.encolar(this.ab);
        cola.encolar(null);

        while ((!cola.esVacia()) && (!encontrado)){
            aux= cola.desencolar();
            if (aux !=null){
                if ((nivelAct == nivel)&& (aux.esHoja()) && (aux.getDato()< minValor)){
                    menor=aux;
                    minValor= aux.getDato();
                }
                if (aux.tieneHijoIzquierdo()){
                    cola.encolar(aux.getHijoIzquierdo());                    
                }
                if (aux.tieneHijoDerecho()){
                    cola.encolar(aux.getHijoDerecho());
                }                
            }
            else{
                if (!cola.esVacia()){
                    cola.encolar(null);
                    if (nivelAct== nivel){
                        encontrado= true;
                    }
                    nivelAct++;

                }
            }
        }

        return menor;
    }

    



}
