package ayed.parcialesGrafos.parcial1Grafos;

import javax.swing.text.DefaultStyledDocument.ElementSpec;

import ayed.tp02.ejercicio2.ListaEnlazadaGenerica;
import ayed.tp02.ejercicio2.ListaGenerica;
import ayed.tp06.ejercicio3.Arista;
import ayed.tp06.ejercicio3.Grafo;
import ayed.tp06.ejercicio3.Vertice;
import ayed.tp06.ejercicio3.VerticeImplListAdy;

public class parcial1 {



    public ListaGenerica<String> resolver(Grafo <Ciudad> ciudades, String origen, String destino){
    		boolean []marca= new boolean[ciudades.listaDeVertices().tamanio() + 1];
			ListaGenerica<String> camino= new ListaEnlazadaGenerica<String>();
			ListaGenerica<String> aux= new ListaEnlazadaGenerica<String>();			
			int posicion= buscarOrigen(ciudades,origen,destino);
			if (posicion != -1){
				aux.agregarFinal(ciudades.listaDeVertices().elemento(posicion).dato().getNombre());
				buscarCamino(posicion,ciudades,camino,aux,destino,marca);
			}
			return camino;

	}

	private void buscarCamino(int posicion, Grafo<Ciudad> ciudades, ListaGenerica<String> camino, ListaGenerica<String> aux, String destino, boolean[] marca) {
		marca[posicion]=true;
		Vertice<Ciudad> v= ciudades.listaDeVertices().elemento(posicion);
		if (v.dato().getNombre().equals(destino)){
			clonar(camino,aux);
		}
		if (camino.esVacia()){
			ListaGenerica<Arista<Ciudad>> ady= ciudades.listaDeAdyacentes(v);
			ady.comenzar();
			while (!ady.fin() && camino.esVacia()){
				Arista<Ciudad> arista=ady.proximo();
				int j= arista.verticeDestino().getPosicion();
				Vertice<Ciudad> vertice= ciudades.listaDeVertices().elemento(j);
				if (!marca[j] && vertice.dato().getFase() != 1){
					aux.agregarFinal(vertice.dato().getNombre());
					buscarCamino(j,ciudades,camino,aux,destino,marca);
					aux.eliminarEn(aux.tamanio());
					
				}

			}
		}
	}

	private void clonar(ListaGenerica<String> camino, ListaGenerica<String> aux) {
		aux.comenzar();
		while (!aux.fin()){
			camino.agregarFinal(aux.proximo());
		}
	}

	private int buscarOrigen(Grafo<Ciudad> ciudades, String origen, String destino) {
		ListaGenerica<Vertice<Ciudad>> vertices = ciudades.listaDeVertices();
		boolean origenE=false,destinoE=false;
		Vertice<Ciudad> aux;
		int posicion=-1;
		vertices.comenzar();
		while (!vertices.fin()){
			aux=vertices.proximo();
			if (aux.dato().getNombre().equals(origen)){
				posicion=aux.getPosicion();
				origenE=true;
			}
			else{
				if (aux.dato().getNombre().equals(destino)){
					destinoE=true;
				}
			}
		}
		return posicion;
	}
		
}
