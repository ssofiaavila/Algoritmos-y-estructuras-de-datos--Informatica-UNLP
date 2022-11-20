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
        boolean[]marca = new boolean[mapaCiudades.listaDeVertices().tamanio() + 1]; //arreglo para ir guardando los vertices que visité
		ListaEnlazadaGenerica<String> lis = new ListaEnlazadaGenerica<String>(); //camino auxiliar hasta que arme el camino destino
		ListaEnlazadaGenerica<String> camino = new ListaEnlazadaGenerica<String>(); //camino que me va a llevar de ciudad1 a ciudad2
			ListaGenerica<Vertice<String>> aux = mapaCiudades.listaDeVertices(); //auxiliar con todos los vertices del G para encontrar ciudad1 (punto de inicio)
			aux.comenzar();
			Vertice<String> vertice; 
			boolean ok = false; //corta cuando encuentre ciudad1
			int i = -1;
			while ((!aux.fin()) && (!ok)) { //mientras que no haya revisado todos los vértices y no haya encontrado a ciudad1
				vertice = aux.proximo();
				if (vertice.dato() == ciudad1) {
					ok = true;
					i = vertice.getPosicion(); //me guardo de indice correspondiente a la lista de vertices
					lis.agregarFinal(vertice.dato()); //empiezo armando el camino auxiliar
				}
			}
			if (i != -1) { //o sea si tengo una posición válida= existe ciudad1 entonces hago el recorrido dfs desde ese vértice inicial
				dfs (i,lis,camino,marca,ciudad2); //i= posición del vertice en la lista de adyacencia
			}
			
		return camino;
    }

    private void dfs (int i,ListaEnlazadaGenerica<String> lis,ListaEnlazadaGenerica<String> camino,boolean[]marca,String ciudad2) {
		marca[i] = true; //marco que determinado vértice ya lo visité
		Vertice<String> v = mapaCiudades.listaDeVertices().elemento(i); //obtengo el puntero a ese vértice
		if (v.dato() == ciudad2) { //si encontré la ciudad destino
			clonar (lis,camino); //clono el camino auxiliar al camino resultado
		}
		if (camino.esVacia()){ //corte de control si ya encontré el camino
			ListaGenerica<Arista<String>> ady = mapaCiudades.listaDeAdyacentes(v); //me guardo los adyacentes de un vertice
			ady.comenzar();
			while ((!ady.fin()) && (camino.esVacia())) { //mientras que no haya visitado todos sus adyacentes y todavia no encontré el camino resultado
				Vertice<String> destino = ady.proximo().verticeDestino();
				int j = destino.getPosicion();
				if (!marca[j]) { //en caso de que no esté visitado
					lis.agregarFinal(destino.dato()); //agrego ese vértice al camino auxiliar
					dfs(j,lis,camino,marca,ciudad2); //sigo recorriendo recursivamente el G
					lis.eliminarEn(lis.tamanio()); //saco el vértice recorrido para seguir por otros vértices adyacentes a v(i)
				}
			}
		
		}
		
		
	}





    /* ---------------------------------------------------------- DEVOLVER EL CAMINO SIN DETERMINADAS CIUDADES------------------------------------------- */

    public ListaGenerica<String> devolverCaminoExceptuando(String ciudad1,String ciudad2, ListaGenerica<String> ciudades){
        boolean[]marca = new boolean[mapaCiudades.listaDeVertices().tamanio() + 1]; //arreglo para ir guardando los vertices que visité
		ListaEnlazadaGenerica<String> lis = new ListaEnlazadaGenerica<String>(); //camino auxiliar hasta que arme el camino destino
		ListaEnlazadaGenerica<String> camino = new ListaEnlazadaGenerica<String>(); //camino que me va a llevar de ciudad1 a ciudad2
			ListaGenerica<Vertice<String>> aux = mapaCiudades.listaDeVertices(); //auxiliar con todos los vertices del G para encontrar ciudad1 (punto de inicio)
			aux.comenzar();
			Vertice<String> vertice; 
			boolean ok = false; //corta cuando encuentre ciudad1
			int i = -1;
			while ((!aux.fin()) && (!ok)) { //mientras que no haya revisado todos los vértices y no haya encontrado a ciudad1
				vertice = aux.proximo();
				if (vertice.dato() == ciudad1) {
					ok = true;
					i = vertice.getPosicion(); //me guardo de indice correspondiente a la lista de vertices
					lis.agregarFinal(vertice.dato()); //empiezo armando el camino auxiliar
				}
			}
			if (i != -1) { //o sea si tengo una posición válida= existe ciudad1 entonces hago el recorrido dfs desde ese vértice inicial
				dfs (i,lis,camino,marca,ciudad2); //i= posición del vertice en la lista de adyacencia
			}
			
		return camino;
		


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
