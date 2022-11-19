package ayed.tp06.ejercicio5;

import ayed.tp02.ejercicio2.ListaEnlazadaGenerica;
import ayed.tp02.ejercicio2.ListaGenerica;
import ayed.tp06.ejercicio3.Arista;
import ayed.tp06.ejercicio3.Grafo;
import ayed.tp06.ejercicio3.Vertice;

public class Mapa {
    private Grafo<String> mapaCiudades;

    public Mapa(Grafo<String> ciudades) {
        this.mapaCiudades = ciudades;
    }


    /* ---------------------------------------------------------- DEVOLVER EL CAMINO --------------------------------------------------------------------- */
    public ListaGenerica<String> devolverCamino(String ciudad1, String ciudad2){
        boolean[]marca = new boolean[mapaCiudades.listaDeVertices().tamanio() + 1];
		ListaEnlazadaGenerica<String> lis = new ListaEnlazadaGenerica<String>();
		ListaEnlazadaGenerica<String> camino = new ListaEnlazadaGenerica<String>();
			ListaGenerica<Vertice<String>> aux = mapaCiudades.listaDeVertices();
			aux.comenzar();
			Vertice<String> vertice;
			boolean ok = false;
			int i = -1;
			while ((!aux.fin()) && (!ok)) {
				vertice = aux.proximo();
				if (vertice.dato() == ciudad1) {
					ok = true;
					i = vertice.getPosicion();
					lis.agregarFinal(vertice.dato());
				}
			}
			if (i != -1) {
				dfs (i,lis,camino,marca,ciudad2);
			}
			
		return camino;
    }

    private void dfs (int i,ListaEnlazadaGenerica<String> lis,ListaEnlazadaGenerica<String> camino,boolean[]marca,String ciudad2) {
		marca[i] = true;
		Vertice<String> v = mapaCiudades.listaDeVertices().elemento(i);
		if (v.dato() == ciudad2) {
			clonar (lis,camino);
		}
		if (camino.esVacia()){
			ListaGenerica<Arista<String>> ady = mapaCiudades.listaDeAdyacentes(v);
			ady.comenzar();
			while ((!ady.fin()) && (camino.esVacia())) {
				Vertice<String> destino = ady.proximo().verticeDestino();
				int j = destino.getPosicion();
				if (!marca[j]) {
					lis.agregarFinal(destino.dato());
					dfs(j,lis,camino,marca,ciudad2);
					lis.eliminarEn(lis.tamanio());
				}
			}
		
		}
		
		
	}





    /* ---------------------------------------------------------- DEVOLVER EL CAMINO SIN DETERMINADAS CIUDADES------------------------------------------- */

    


    public ListaGenerica<String> devolverCaminoExceptuando(String ciudad1,String ciudad2, ListaGenerica<String> ciudades){
                
        return null;
    }


    /* ---------------------------------------------------------- DEVOLVER EL CAMINO MÁS CORTO ---------------------------------------------------------- */
    public ListaGenerica<String> caminoMasCorto(String ciudad1,String ciudad2){

        return null;
    }

    /* ---------------------------------------------------------- DEVOLVER EL CAMINO SIN CARGAR COMBUSTIBLE --------------------------------------------- */
    public ListaGenerica<String> caminoSinCargarCombustible(String ciudad1,String ciudad2, int tanqueAuto){

        return null;
    }


    /* ---------------------------------------------------------- DEVOLVER EL CAMINO CON LA MENOR CARGA--------------------------------------------------- */
    public ListaGenerica<String> caminoConMenorCargaDeCombustible(String ciudad1, String ciudad2, int tanqueAuto){

        return null;
    }

    /* ---------------------------------------------------------- OTROS METODOS :P ----------------------------------------------------------------------- */
    private void clonar (ListaEnlazadaGenerica<String> lis,ListaEnlazadaGenerica<String> camino) {
		lis.comenzar();
		while(!lis.fin()) {
			camino.agregarFinal(lis.proximo());
		}
	}
}
