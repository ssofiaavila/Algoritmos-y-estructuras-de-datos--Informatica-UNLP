package ayed.parcialesGrafos.parcial1Grafos;

import ayed.tp02.ejercicio2.ListaEnlazadaGenerica;
import ayed.tp02.ejercicio2.ListaGenerica;
import ayed.tp06.ejercicio3.Arista;
import ayed.tp06.ejercicio3.Grafo;
import ayed.tp06.ejercicio3.Vertice;

public class parcial1 {



    ListaGenerica<String> resolver(Grafo <Ciudad> ciudades, String origen, String destino){
        int distancia=0;		
		boolean[]marca = new boolean[ciudades.listaDeVertices().tamanio() + 1]; //arreglo para ir guardando los vertices que visité
		ListaEnlazadaGenerica<String> lis = new ListaEnlazadaGenerica<String>(); //camino auxiliar hasta que arme el camino destino
		ListaEnlazadaGenerica<String> camino = new ListaEnlazadaGenerica<String>(); //camino que me va a llevar de origen a destino
			ListaGenerica<Vertice<Ciudad>> aux = ciudades.listaDeVertices(); //auxiliar con todos los vertices del G para encontrar ciudad1 (punto de inicio)
			aux.comenzar();
			Vertice<Ciudad> vertice; 
			boolean ok = false; //corta cuando encuentre ciudad1
			int i = -1;
			while ((!aux.fin()) && (!ok)) { //mientras que no haya revisado todos los vértices y no haya encontrado a ciudad1
				vertice = aux.proximo();
				if (vertice.dato().getNombre() == origen) {
					ok = true;
					i = vertice.getPosicion(); //me guardo de indice correspondiente a la lista de vertices
					lis.agregarFinal(vertice.dato().getNombre()); //empiezo armando el camino auxiliar
				}
			}
			if (i != -1) { //o sea si tengo una posición válida= existe ciudad1 entonces hago el recorrido dfs desde ese vértice inicial
				caminoMasCorto(i,ciudades,lis,camino,marca,destino); //i= posición del vertice en la lista de adyacencia
			}
			
		return camino;


        
    }

    private void caminoMasCorto(int i, Grafo<Ciudad>ciudades, ListaEnlazadaGenerica<String> lis, ListaEnlazadaGenerica<String> camino, boolean[] marca, String destino) {
        marca[i] = true; //marco que determinado vértice ya lo visité
		Vertice<Ciudad> v = ciudades.listaDeVertices().elemento(i); //obtengo el puntero a ese vértice
		if ((v.dato().getNombre() == destino)){ //si encontré la ciudad destino y complí el costo mínimo
			clonar (camino,lis); //clono el camino auxiliar al camino resultado
            
		}
		if (camino.esVacia()){ //corte de control si ya encontré el camino
			ListaGenerica<Arista<Ciudad>> ady = ciudades.listaDeAdyacentes(v); //me guardo los adyacentes de un vertice
			ady.comenzar();
			while ((!ady.fin()) && (camino.esVacia())) { //mientras que no haya visitado todos sus adyacentes y todavia no encontré el camino resultado
				Arista<Ciudad> arista = ady.proximo();
				int j = arista.verticeDestino().getPosicion();
				if (!marca[j] && (ciudades.listaDeVertices().elemento(j).dato().getFase() != 1))  { //en caso de que no esté visitado
					lis.agregarFinal(arista.verticeDestino().dato().getNombre()); //agrego ese vértice al camino auxiliar
					caminoMasCorto(j,ciudades,lis,camino,marca,destino); //sigo recorriendo recursivamente el G
					lis.eliminarEn(lis.tamanio()); //saco el vértice recorrido para seguir por otros vértices adyacentes a v(i)
                    
				}
			}

		}
    }

    private void clonar(ListaEnlazadaGenerica<String> camino, ListaEnlazadaGenerica<String> lis) {
        lis.comenzar();
        while(!lis.fin()){
            camino.agregarFinal(lis.proximo());
        }
    }
}
