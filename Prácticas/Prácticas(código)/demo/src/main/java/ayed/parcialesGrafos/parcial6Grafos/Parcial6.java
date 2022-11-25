package ayed.parcial6Grafos;

import ayed.tp02.ejercicio2.ListaEnlazadaGenerica;
import ayed.tp02.ejercicio2.ListaGenerica;
import ayed.tp06.ejercicio3.Arista;
import ayed.tp06.ejercicio3.Grafo;
import ayed.tp06.ejercicio3.Vertice;

public class Parcial6 {

    public ListaGenerica<ListaGenerica<String>> caminosCosto10(Grafo<String> ciudades) {
		ListaGenerica<String> aux = new ListaEnlazadaGenerica<String>();
        ListaGenerica<ListaGenerica<String>> caminos= new ListaEnlazadaGenerica<ListaGenerica<String>>();
        int costo;
        //LLEGA

		for (int i=1; i <=ciudades.listaDeVertices().tamanio(); i++) {
            costo=0;
			caminosCosto10(i,ciudades,caminos,aux,costo);
            aux.eliminarEn(aux.tamanio()); //elimina ese vertice de la lista auxiliar
		}
		return caminos; 
        
    }

    private void caminosCosto10(int i, Grafo<String> ciudades, ListaGenerica<ListaGenerica<String>> caminos, ListaGenerica<String> aux, int costo) {
        
		Vertice<String> v = ciudades.listaDeVertices().elemento(i);
        aux.agregarFinal(v.dato());
        if (costo ==10){
            caminos.agregarFinal(aux.clonar());
        }
        else{            
            ListaGenerica<Arista<String>> ady = ciudades.listaDeAdyacentes(v);
            ady.comenzar();
            while (!ady.fin()) {
                Arista<String> arista= ady.proximo();
                int j = arista.verticeDestino().getPosicion();
                costo+=arista.peso();                
                caminosCosto10(j,ciudades,caminos,aux,costo);
                costo-= arista.peso();
                
                aux.eliminarEn(aux.tamanio());                
            }
        }
		


    }
}
		
    
    
    
    
    
    

    
