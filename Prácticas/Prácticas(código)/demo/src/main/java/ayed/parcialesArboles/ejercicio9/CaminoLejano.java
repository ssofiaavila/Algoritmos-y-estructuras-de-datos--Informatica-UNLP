package ayed.parcialesArboles.ejercicio9;

import ayed.tp02.ejercicio2.ListaEnlazadaGenerica;
import ayed.tp02.ejercicio2.ListaGenerica;
import ayed.tp04.ejercicio1.ArbolGeneral;

public class CaminoLejano {
    private ArbolGeneral<Integer> ab;

    public CaminoLejano(ArbolGeneral<Integer> ab){
        this.ab = ab;
    }

    public ListaGenerica<ArbolGeneral<Integer>> caminoMasLejos(){
        ListaGenerica<ArbolGeneral<Integer>> recorrido= new ListaEnlazadaGenerica<ArbolGeneral<Integer>>();
        ListaGenerica<ArbolGeneral<Integer>> actual= new ListaEnlazadaGenerica<ArbolGeneral<Integer>>();
        caminoMasLejos(this.ab,recorrido,actual);
        return recorrido;
    }

    private void caminoMasLejos(ArbolGeneral<Integer> ab, ListaGenerica<ArbolGeneral<Integer>> recorrido, ListaGenerica<ArbolGeneral<Integer>> actual) {
        if (ab.esHoja()){
            actual.agregarFinal(ab);
            if (actual.tamanio() > recorrido.tamanio()){
                clonar(recorrido,actual);                                  
            }
                      
        }
        else{            
            actual.agregarFinal(ab); 
            ListaGenerica<ArbolGeneral<Integer>> hijos= ab.getHijos();
            hijos.comenzar(); 
            ArbolGeneral<Integer> aux;
            while (!hijos.fin()){                    
                aux= hijos.proximo();  
                caminoMasLejos(aux,recorrido,actual);
                actual.eliminarEn(actual.tamanio());                              
            }            
        }
    }

    // tengo que eliminar el recorrido que ya tenía
    private void clonar(ListaGenerica<ArbolGeneral<Integer>> recorrido, ListaGenerica<ArbolGeneral<Integer>> actual) {
        actual.comenzar();  
        recorrido.comenzar();      
		while(!recorrido.fin())
			recorrido.eliminar(recorrido.proximo());		
		while(!actual.fin())
			recorrido.agregarFinal(actual.proximo());
    }
    
}
