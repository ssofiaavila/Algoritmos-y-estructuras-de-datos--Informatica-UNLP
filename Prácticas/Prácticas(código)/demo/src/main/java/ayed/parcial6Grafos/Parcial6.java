package ayed.parcial6Grafos;

import ayed.tp02.ejercicio2.ListaEnlazadaGenerica;
import ayed.tp02.ejercicio2.ListaGenerica;
import ayed.tp06.ejercicio3.Arista;
import ayed.tp06.ejercicio3.Grafo;
import ayed.tp06.ejercicio3.Vertice;

public class Parcial6 {

    public ListaGenerica<ListaGenerica<String>> caminosCosto10(Grafo<String> ciudades) {
        boolean[]marca = new boolean[ciudades.listaDeVertices().tamanio() + 1]; //arreglo para ir guardando los vertices que visité
		ListaGenerica<ListaGenerica<String>> caminos = new ListaEnlazadaGenerica<ListaGenerica<String>>(); //caminos con costo= 10
		ListaGenerica<String> caminoActual = new ListaEnlazadaGenerica<String>(); //camino que vaya a encontrar con costo 10
        int costo;
        for (int i=1; i <= ciudades.listaDeVertices().tamanio();i++){
            costo=0;
            caminosCosto10(i,ciudades,caminoActual,marca,caminos,costo); //i= posición del vertice en la lista de adyacencia			
            marca[1]=false;
            caminoActual.eliminarEn(caminoActual.tamanio());
        }
		return caminos;
        
    }

    private void caminosCosto10(int i, Grafo<String> ciudades, ListaGenerica<String> caminoActual, boolean[] marca, ListaGenerica<ListaGenerica<String>> caminos, int costo) {
        marca[i] = true; //marco que determinado vértice ya lo visité
		Vertice<String> v = ciudades.listaDeVertices().elemento(i); //obtengo el puntero a ese vértice
        caminoActual.agregarFinal(v.dato());
		if (costo==10) { //si encontré la ciudad destino y complí el costo mínimo
            caminos.agregarFinal(caminoActual.clonar());            
		}
        else{ 
                ListaGenerica<Arista<String>> ady = ciudades.listaDeAdyacentes(v); //me guardo los adyacentes de un vertice              
                ady.comenzar();
                System.out.println("ZZZ");
                while ((!ady.fin())) { //mientras que no haya visitado todos sus adyacentes 
                    Arista<String> arista = ady.proximo();
                    int j = arista.verticeDestino().getPosicion();
                    if ((!marca[j]) && (costo + arista.peso() <= 10)) { //en caso de que no esté visitado
                        caminosCosto10(j,ciudades,caminoActual,marca,caminos,costo+arista.peso());
                        marca[j] = false;
                        caminoActual.eliminarEn(caminoActual.tamanio());
                    }
                }
            }
            
    
            }
        }
		
    
    
    
    
    
    

    
