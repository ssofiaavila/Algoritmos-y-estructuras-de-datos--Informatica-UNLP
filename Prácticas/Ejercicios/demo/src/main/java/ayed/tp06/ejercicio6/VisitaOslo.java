package ayed.tp06.ejercicio6;

import ayed.tp02.ejercicio2.ListaEnlazadaGenerica;
import ayed.tp02.ejercicio2.ListaGenerica;
import ayed.tp06.ejercicio3.Arista;
import ayed.tp06.ejercicio3.Grafo;
import ayed.tp06.ejercicio3.Vertice;

public class VisitaOslo {

/* debo retornar el primer camino desde el Ayuntamiento hasta destino en el cual no pase por determiados lugares y se lleguen en menos de X cantidad de minutos */

    public ListaGenerica<String> paseoEnBici(Grafo<String> bicisendas, String destino, int maxMinutos, ListaEnlazadaGenerica<String> lugaresRestringidos) {
        boolean[]marca = new boolean[bicisendas.listaDeVertices().tamanio() + 1];      
        ListaGenerica<String> camino= new ListaEnlazadaGenerica<String>();
        ListaGenerica<String> aux= new ListaEnlazadaGenerica<String>();
        if (!lugaresRestringidos.incluye(destino) && !lugaresRestringidos.incluye("Ayuntamiento")){
            ListaGenerica<Vertice<String>> vertices= bicisendas.listaDeVertices();
            vertices.comenzar();
            Vertice<String> vertice;
            boolean encontre=false;
            int indice=-1;       
            while (!vertices.fin() && !encontre){
                vertice=vertices.proximo();
                if (vertice.dato()== "Ayuntamiento"){
                    indice=vertice.getPosicion();
                    encontre=true;
                    aux.agregarFinal(vertice.dato());
                }
            }
        if (indice != -1){
            int tiempo=0;
            paseoEnBici(bicisendas,indice,camino,aux,marca,lugaresRestringidos,tiempo, maxMinutos, destino);
        }
        
    }
    return camino;
}

    private void paseoEnBici(Grafo<String> bicisendas,int indice, ListaGenerica<String> camino, ListaGenerica<String> aux, boolean[] marca, ListaEnlazadaGenerica<String> lugaresRestringidos, int tiempo, int maxMinutos, String destino) {
        marca[indice] = true;
		Vertice<String> v = bicisendas.listaDeVertices().elemento(indice);
		if (v.dato() == destino) {
			clonar (camino,aux);
		}
		if (camino.esVacia()){
			ListaGenerica<Arista<String>> ady = bicisendas.listaDeAdyacentes(v);
			ady.comenzar();
			while ((!ady.fin()) && (camino.esVacia())) {
				Arista<String> arista = ady.proximo();
				int j = arista.verticeDestino().getPosicion();
				if ((!marca[j]) && (!(lugaresRestringidos.incluye(arista.verticeDestino().dato())))) {
					tiempo += arista.peso();
					if (tiempo <= maxMinutos) {
						aux.agregarFinal(arista.verticeDestino().dato());
						paseoEnBici (bicisendas,j,camino,aux,marca,lugaresRestringidos,tiempo,maxMinutos,destino);
						aux.eliminarEn(aux.tamanio());
						if (camino.esVacia()) {
							marca[j] = false;
						}
					}
					tiempo-= arista.peso();
				}
			}
		}



		

    }

    private void clonar(ListaGenerica<String> camino, ListaGenerica<String> aux) {
        aux.comenzar();
        while (!aux.fin()) {
            camino.agregarFinal(aux.proximo());
        }
    }

}
