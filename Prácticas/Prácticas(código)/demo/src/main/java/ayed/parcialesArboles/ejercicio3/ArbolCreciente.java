package ayed.parcialesArboles.ejercicio3;

import ayed.tp02.ejercicio2.ListaGenerica;
import ayed.tp02.ejercicio3.ColaGenerica;
import ayed.tp04.ejercicio1.ArbolGeneral;

public class ArbolCreciente {
    private ArbolGeneral<Integer> ab;
    
    public ArbolCreciente(ArbolGeneral<Integer> ab){
        this.ab=ab;
    }

    public ArbolGeneral<Integer> esCreciente() {
        ArbolGeneral<Integer> mayorNodo= esCreciente(this.ab);
        return mayorNodo;
    }

    private ArbolGeneral<Integer> esCreciente(ArbolGeneral<Integer> ab){

        boolean resultado= true; //si llego a verificar que no es creciente, corto el recorrido haciendolo falso
        ArbolGeneral<Integer> mayorNodo=null; //para guardar el nodo con mayor cantidad de hijos
        ArbolGeneral<Integer> aux; //donde iré desencolando los elementos de la cola
        int nivel=1; // arranco desde uno porque evaluo a partir del nodo padre
        int maxHijos=-1; //para ir guardando la cantidad de hijos del nodo con mayor cantidad de hijos y lo voy a ir actualizando
        int cantHijos=0;

        ColaGenerica<ArbolGeneral<Integer>> cola= new ColaGenerica<ArbolGeneral<Integer>>();
        cola.encolar(ab); //encolo la raíz
        cola.encolar(null); //encolo null para pasar a otro nivel

        while ((!cola.esVacia()) && (resultado)){ //mientras que haya elementos en la cola y no haya verificado que un nivel NO es creciente
            aux=cola.desencolar(); //desencolo
            if (aux!= null){
                if (aux.tieneHijos()){
                    ListaGenerica<ArbolGeneral<Integer>> hijos= aux.getHijos();
                    
                    if (hijos.tamanio() > maxHijos){
                        maxHijos= hijos.tamanio();
                        mayorNodo= aux;
                    }
                    hijos.comenzar();
					while (!hijos.fin()){
						cola.encolar(hijos.proximo());
                        cantHijos++;
					}
                }
            }
            else{
                if (!cola.esVacia()){
                    cola.encolar(null);                    
                    if (cantHijos != (nivel+1)){
                        resultado=false;                        
                    }
                    nivel++;
                    cantHijos=0;
                }
            }         

        }
        if (resultado){
            return mayorNodo;
        }
        else return null;

    }

    
}
