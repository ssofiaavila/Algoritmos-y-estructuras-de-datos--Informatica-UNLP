package ayed.parcialesGrafos.parcial2Grafos;

import ayed.tp02.ejercicio2.ListaEnlazadaGenerica;
import ayed.tp02.ejercicio2.ListaGenerica;
import ayed.tp06.ejercicio3.Arista;
import ayed.tp06.ejercicio3.Grafo;
import ayed.tp06.ejercicio3.Vertice;

public class BuscadorDeCamino {

    public ListaGenerica<String> resolver(Grafo<String> ciudades, String origen, String destino, ListaGenerica<String> pasandoPor){
        boolean[]marca= new boolean[ciudades.listaDeVertices().tamanio() + 1];
		ListaGenerica<String> camino= new ListaEnlazadaGenerica<String>();
		ListaGenerica<Vertice<String>> vertices= ciudades.listaDeVertices();
		int posicion=-1;
		boolean encontre=false, origenE=false, destinoE=false;
		Vertice<String> aux;
		vertices.comenzar();
		while (!vertices.fin() && (!encontre)){
			aux=vertices.proximo();
			if (aux.dato().equals(origen)){
				origenE=true;
				posicion= aux.getPosicion();
			}
			destinoE=aux.dato().equals(destino);
			encontre= origenE && destinoE;
		}
		if (posicion != -1){
			devolverCamino(posicion,ciudades,camino,marca,destino,pasandoPor);
		}
		if (encontre){
			return camino;
		}
		else
			return null;
    }


    private boolean devolverCamino(int posicion, Grafo<String> ciudades, ListaGenerica<String> camino, boolean[] marca, String destino, ListaGenerica<String> pasandoPor) {
		boolean encontre=false;
		marca[posicion]=true;
		Vertice<String> v= ciudades.listaDeVertices().elemento(posicion);
		camino.agregarFinal(v.dato());
		if (v.dato().equals(destino)){
			encontre=true;	
			boolean cumple=true;
			pasandoPor.comenzar();
			while (!pasandoPor.fin()&& cumple ){
				cumple=camino.incluye(pasandoPor.proximo());
			}
					
		}
		else{			
				ListaGenerica<Arista<String>> aristas= ciudades.listaDeAdyacentes(v);
				aristas.comenzar();
				while (!aristas.fin() && !encontre){
					Arista<String> arista= aristas.proximo();
					int j=arista.verticeDestino().getPosicion();
					if (!marca[j]){
						encontre=devolverCamino(j,ciudades,camino,marca,destino,pasandoPor);					
						if (!encontre){
							marca[j]=true;
							camino.eliminarEn(camino.tamanio());
						}
					}		
			
				}

		
	}
	return encontre;
	}
}

	

