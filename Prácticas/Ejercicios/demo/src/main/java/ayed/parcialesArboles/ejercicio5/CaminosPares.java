package ayed.parcialesArboles.ejercicio5;

import ayed.tp02.ejercicio2.ListaEnlazadaGenerica;
import ayed.tp02.ejercicio2.ListaGenerica;
import ayed.tp04.ejercicio1.ArbolGeneral;

public class CaminosPares {


    public ListaGenerica<ListaEnlazadaGenerica<Character>> caminosPares(ArbolGeneral<Character> ab){
        ListaGenerica<ListaEnlazadaGenerica<Character>> caminos= new ListaEnlazadaGenerica<ListaEnlazadaGenerica<Character>>();
        ListaEnlazadaGenerica<Character> caminoActual= new ListaEnlazadaGenerica<Character>();
        caminosPares(caminos,caminoActual,ab);
        return caminos;        
    }


    private void caminosPares(ListaGenerica<ListaEnlazadaGenerica<Character>> caminos, ListaEnlazadaGenerica<Character> caminoActual, ArbolGeneral<Character> ab){
        if (ab.esHoja()){
            caminoActual.agregarFinal(ab.getDato());
            if ((caminoActual.tamanio() % 2) == 0 ){
                clonar(caminos,caminoActual);   
            }
            caminoActual.eliminarEn(caminoActual.tamanio());
            
        }
        else{
            caminoActual.agregarFinal(ab.getDato()); 
            ListaGenerica<ArbolGeneral<Character>> hijos= ab.getHijos();
            hijos.comenzar();
            while (!hijos.fin()){
                caminosPares(caminos,caminoActual,hijos.proximo());
                caminoActual.eliminarEn(hijos.tamanio());
            }

        }

    }

    private void clonar(ListaGenerica<ListaEnlazadaGenerica<Character>> caminos, ListaGenerica<Character> caminoActual) {

        ListaEnlazadaGenerica<Character> nuevo= new ListaEnlazadaGenerica<Character>();
        caminoActual.comenzar();
        while (!caminoActual.fin()){
            nuevo.agregarFinal(caminoActual.proximo());
        }
        caminos.agregarFinal(nuevo);
    }
    

    
}
