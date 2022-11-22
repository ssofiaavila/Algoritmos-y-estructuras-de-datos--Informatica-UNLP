
/*Implemente una clase Java llamada ProfundidadDeArbolBinario que tiene como variable de instancia un árbol binario de 
números enteros y un método de instancia sumaElementosProfundidad(int p):int el cuál devuelve la suma de todos los nodos 
del árbol que se encuentren a la profundidad pasada como argumento*/ 
/* DEFINICION DE PROFUNDIDAD: de n_i  es la longitud del único camino desde la raíz hasta n_i
la raíz tiene profundidad 0*/ 


package ayed.tp03.ejercicio5;

import ayed.tp02.ejercicio3.ColaGenerica;
import ayed.tp03.ejercicio1.ArbolBinario;

public class ProfundidadDeArbolBinario {
    ArbolBinario<Integer> abb= new ArbolBinario<Integer>();

    public ProfundidadDeArbolBinario(ArbolBinario<Integer> ab){
        this.abb=ab;
    }

    public int sumaElementosProfundidad(int p){
        int act=0;
        return this.sumaElementosProfundidad(this.abb,p, act);
    }

    public int sumaElementosProfundidad(ArbolBinario<Integer> ab, int p, int act){
        int suma=0;
        ArbolBinario<Integer> arbol= null;
        ColaGenerica<ArbolBinario<Integer>> cola= new ColaGenerica<ArbolBinario<Integer>>();
        cola.encolar(ab);
        cola.encolar(null);
        while (!cola.esVacia() && act <=p){ //mientras que tenga elementos y no haya llegado a la profundidad 
            arbol= cola.desencolar();
            if (arbol != null){
                suma+=arbol.getDato();
                if (arbol.tieneHijoIzquierdo())
                    cola.encolar(arbol.getHijoIzquierdo());
                if (arbol.tieneHijoDerecho())
                    cola.encolar(arbol.getHijoDerecho());
            }
            else if (!cola.esVacia()){                
                cola.encolar(null);
                act++;
            }
            
        }
        return suma;


    }
}
