package ayed.parcial2Grafos;

import ayed.tp02.ejercicio2.ListaEnlazadaGenerica;
import ayed.tp02.ejercicio2.ListaGenerica;
import ayed.tp06.ejercicio3.Arista;
import ayed.tp06.ejercicio3.Grafo;
import ayed.tp06.ejercicio3.Vertice;

public class BuscadorDeCamino {

    public ListaGenerica<String> caminoConPresupuesto(Grafo<String> ciudades, String origen, String destino, int montoMinimo){
        boolean[]marca = new boolean[ciudades.listaDeVertices().tamanio() + 1]; //arreglo para ir guardando los vertices que visité
		ListaEnlazadaGenerica<String> lis = new ListaEnlazadaGenerica<String>(); //camino auxiliar hasta que arme el camino destino
		ListaEnlazadaGenerica<String> camino = new ListaEnlazadaGenerica<String>(); //camino que me va a llevar de ciudad1 a ciudad2
		ListaGenerica<Vertice<String>> aux = ciudades.listaDeVertices(); //auxiliar con todos los vertices del G para encontrar ciudad1 (punto de inicio)
        int montoActual=0;
		aux.comenzar();
		Vertice<String> vertice; 
		boolean ok = false; //corta cuando encuentre ciudad1
		int i = -1;
		while ((!aux.fin()) && (!ok)) { //mientras que no haya revisado todos los vértices y no haya encontrado a ciudad1
		    vertice = aux.proximo();
			if (vertice.dato() == origen) {
				ok = true;
				i = vertice.getPosicion(); //me guardo de indice correspondiente a la lista de vertices
				lis.agregarFinal(vertice.dato()); //empiezo armando el camino auxiliar
			}
		}
		if (i != -1) { //o sea si tengo una posición válida= existe ciudad1 entonces hago el recorrido dfs desde ese vértice inicial
			devolverCamino(i,ciudades,lis,camino,marca,destino,montoMinimo,montoActual); //i= posición del vertice en la lista de adyacencia
		}
			
		return camino;
    }

    private void devolverCamino(int i, Grafo<String> ciudades, ListaEnlazadaGenerica<String> aux, ListaEnlazadaGenerica<String> camino, boolean[] marca, String destino, int montoMinimo, int montoActual) {
        marca[i] = true; //marco que determinado vértice ya lo visité
		Vertice<String> v = ciudades.listaDeVertices().elemento(i); //obtengo el puntero a ese vértice
		if ((v.dato() == destino) && (montoActual >= montoMinimo)) { //si encontré la ciudad destino y complí el costo mínimo
			clonar (camino,aux); //clono el camino auxiliar al camino resultado
            System.out.println(montoActual);
		}
		if (camino.esVacia()){ //corte de control si ya encontré el camino
			ListaGenerica<Arista<String>> ady = ciudades.listaDeAdyacentes(v); //me guardo los adyacentes de un vertice
			ady.comenzar();
			while ((!ady.fin()) && (camino.esVacia())) { //mientras que no haya visitado todos sus adyacentes y todavia no encontré el camino resultado
				Arista<String> arista = ady.proximo();
				int j = arista.verticeDestino().getPosicion();
                montoActual+=arista.peso();
				if (!marca[j]) { //en caso de que no esté visitado
					aux.agregarFinal(arista.verticeDestino().dato()); //agrego ese vértice al camino auxiliar
					devolverCamino(j,ciudades,aux,camino,marca,destino,montoMinimo,montoActual); //sigo recorriendo recursivamente el G
					aux.eliminarEn(aux.tamanio()); //saco el vértice recorrido para seguir por otros vértices adyacentes a v(i)
                    montoActual=-arista.peso();
				}
			}

		}
    
    
    
    }

    private void clonar(ListaEnlazadaGenerica<String> camino, ListaEnlazadaGenerica<String> aux) {
        aux.comenzar();
        while (!aux.fin()){
            camino.agregarFinal(aux.proximo());
        }
    }
    
}
