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
				devolverCamino(i,lis,camino,marca,ciudad2); //i= posición del vertice en la lista de adyacencia
			}
			
		return camino;
    }

    private void devolverCamino (int i,ListaEnlazadaGenerica<String> lis,ListaEnlazadaGenerica<String> camino,boolean[]marca,String ciudad2) {
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
					devolverCamino(j,lis,camino,marca,ciudad2); //sigo recorriendo recursivamente el G
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
				devolverCaminoExceptuando (i,lis,camino,marca,ciudad2, ciudades); //i= posición del vertice en la lista de adyacencia
			}
			
		return camino;
    }

	private void devolverCaminoExceptuando(int i,ListaEnlazadaGenerica<String> lis,ListaEnlazadaGenerica<String> camino,boolean[]marca,String ciudad2, ListaGenerica<String> ciudades ){
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
				if ((!marca[j]) && (!ciudades.incluye(destino.dato()))) { //en caso de que no esté visitado
					lis.agregarFinal(destino.dato()); //agrego ese vértice al camino auxiliar
					devolverCamino(j,lis,camino,marca,ciudad2); //sigo recorriendo recursivamente el G
					lis.eliminarEn(lis.tamanio()); //saco el vértice recorrido para seguir por otros vértices adyacentes a v(i)
				}
			}
		
		}


		
	}


    /* ---------------------------------------------------------- DEVOLVER EL CAMINO MÁS CORTO ---------------------------------------------------------- */
    public ListaGenerica<String> caminoMasCorto(String ciudad1,String ciudad2){
		int distancia=0;
		Minimo min= new Minimo(9999); //clase porque voy a necesitar una referencia a un objeto que me guarde el valor minimo del viaje, no uso por parámetro por valor porque voy a perder actualizaciones
		
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
				caminoMasCorto(i,lis,camino,marca,ciudad2,min,distancia); //i= posición del vertice en la lista de adyacencia
			}
			
		return camino;
    }

	private void caminoMasCorto(int i, ListaEnlazadaGenerica<String> lis, ListaEnlazadaGenerica<String> camino, boolean[]marca,String ciudad2, Minimo min, int distancia){
		marca[i] = true; //marco que determinado vértice ya lo visité
		Vertice<String> v = mapaCiudades.listaDeVertices().elemento(i); //obtengo el puntero a ese vértice
		if (v.dato() == ciudad2 && (distancia < min.getMinimo())) { //si encontré la ciudad destino
			clonar2 (lis,camino); //clono el camino auxiliar al camino resultado
			marca[i]=false;
		}
		else{
			ListaGenerica<Arista<String>> ady = mapaCiudades.listaDeAdyacentes(v); //me guardo los adyacentes de un vertice
			ady.comenzar();
			while (!ady.fin()) { //mientras que no haya visitado todos sus adyacentes y todavia no encontré el camino resultado
				Arista<String> arista = ady.proximo();
				int j = arista.verticeDestino().getPosicion();
				distancia+=arista.peso();
				if (!marca[j]) { //en caso de que no esté visitado
					lis.agregarFinal(arista.verticeDestino().dato()); //agrego ese vértice al camino auxiliar
					caminoMasCorto(j,lis,camino,marca,ciudad2,min,distancia); //sigo recorriendo recursivamente el G
					lis.eliminarEn(lis.tamanio()); //saco el vértice recorrido para seguir por otros vértices adyacentes a v(i)
					distancia=- arista.peso();
				}
			}
		
		}
	}
	
	
	private void clonar2(ListaEnlazadaGenerica<String> lis, ListaEnlazadaGenerica<String> camino) {
		camino.comenzar();
		while (!camino.fin()){
			camino.eliminar(camino.proximo());
		}
		lis.comenzar();
		while (!lis.fin()){
			camino.agregarFinal(lis.proximo());
		}

	}


	/* ---------------------------------------------------------- DEVOLVER EL CAMINO SIN CARGAR COMBUSTIBLE --------------------------------------------- */
    public ListaGenerica<String> caminoSinCargarCombustible(String ciudad1,String ciudad2, int tanqueAuto){
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
			caminoSinCargarCombustible(i,lis,camino,marca,ciudad2,tanqueAuto); //i= posición del vertice en la lista de adyacencia
		}
			
		return camino;
    }


    private void caminoSinCargarCombustible(int i, ListaEnlazadaGenerica<String> lis, ListaEnlazadaGenerica<String> camino, boolean[] marca, String ciudad2, int tanqueAuto) {
		marca[i] = true; //marco que determinado vértice ya lo visité
		Vertice<String> v = mapaCiudades.listaDeVertices().elemento(i); //obtengo el puntero a ese vértice
		if (v.dato() == ciudad2) { //si encontré la ciudad destino
			clonar (lis,camino); //clono el camino auxiliar al camino resultado
		}
		if (camino.esVacia()){ //corte de control si ya encontré el camino
			ListaGenerica<Arista<String>> ady = mapaCiudades.listaDeAdyacentes(v); //me guardo los adyacentes de un vertice
			ady.comenzar();
			while ((!ady.fin()) && (tanqueAuto !=0)) { //mientras que no haya visitado todos sus adyacentes y todavia no encontré el camino resultado
				Arista<String> arista = ady.proximo();
				int j = arista.verticeDestino().getPosicion();
				if (!marca[j]) { //en caso de que no esté visitado
					tanqueAuto=- arista.peso();
					if (tanqueAuto != 0){
						lis.agregarFinal(arista.verticeDestino().dato()); //agrego ese vértice al camino auxiliar
						devolverCamino(j,lis,camino,marca,ciudad2); //sigo recorriendo recursivamente el G
						lis.eliminarEn(lis.tamanio()); //saco el vértice recorrido para seguir por otros vértices adyacentes a v(i)
					}
					tanqueAuto+=arista.peso();
					
				}
			}
		
		}
	}


	/* ---------------------------------------------------------- DEVOLVER EL CAMINO CON LA MENOR CARGA--------------------------------------------------- */
    public ListaGenerica<String> caminoConMenorCargaDeCombustible(String ciudad1, String ciudad2, int tanqueAuto){
		Minimo minimo = new Minimo (9999);
		boolean[]marca = new boolean[mapaCiudades.listaDeVertices().tamanio() + 1];
		ListaEnlazadaGenerica<String> lis = new ListaEnlazadaGenerica<String>();
		ListaEnlazadaGenerica<String> camino = new ListaEnlazadaGenerica<String>();
		if (tanqueAuto != 0) {
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
				int carga = tanqueAuto;
				int cant = 0;
				menorCarga (i,lis,camino,marca,ciudad2,tanqueAuto,carga,cant,minimo);
			}
		}
		return camino;
    }

    private void menorCarga(int i, ListaEnlazadaGenerica<String> lis, ListaEnlazadaGenerica<String> camino,
			boolean[] marca, String ciudad2, int tanqueAuto, int carga, int cant, Minimo minimo) {
				Vertice<String> v = mapaCiudades.listaDeVertices().elemento(i);
		if (v.dato() == ciudad2) {
			if (cant < minimo.getMinimo()) { //SI ES EL MINIMO DE CARGAS CLONO EL CAMINO Y AHORA PASA A SER EL MINIMO
				clonar2 (lis,camino);
				minimo.setMinimo(cant);
			}
		}
		else {
			if (tanqueAuto == 0) { //SI LLEGO A CIUDAD Y ME QUEDE SIN COMBUSTIBLE CARGO
				tanqueAuto+= carga - tanqueAuto;
				cant++; //INCREMENTO CONTADOR DE CARGAS
			}
			marca[i] = true;
			ListaGenerica<Arista<String>> ady = mapaCiudades.listaDeAdyacentes(v);
			ady.comenzar();
			while (!ady.fin()){
				Arista<String> arista = ady.proximo();
				int j = arista.verticeDestino().getPosicion();
				if (!marca[j]) {
					tanqueAuto-= arista.peso(); //RESTO LO QUE VOY A GASTAR DE COMBUSTIBLE
					if (tanqueAuto >= 0) { //VERIFICO QUE NO ME VOY A QUEDAR SIN COMBUSTIBLE EN EL MEDIO DE LA RUTA
						lis.agregarFinal(arista.verticeDestino().dato());
						menorCarga(j,lis,camino,marca,ciudad2,tanqueAuto,carga,cant,minimo);
						lis.eliminarEn(lis.tamanio());
					}
					tanqueAuto+=arista.peso(); //SUMO LO QUE LE RESTE PARA PODER CAMBIAR DE CAMINO Y SEGUIR CON LA SUMA
				}
			}
		}
	}


	/* ---------------------------------------------------------- OTROS METODOS :P ----------------------------------------------------------------------- */
    private void clonar (ListaEnlazadaGenerica<String> lis,ListaEnlazadaGenerica<String> camino) {
		lis.comenzar();
		while(!lis.fin()) {
			camino.agregarFinal(lis.proximo());
		}
	}
}
