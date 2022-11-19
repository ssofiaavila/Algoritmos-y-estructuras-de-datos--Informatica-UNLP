package ayed.tp06.ejercicio4;

import ayed.tp02.ejercicio2.ListaGenerica;
import ayed.tp06.ejercicio3.GrafoImplListAdy;
import ayed.tp06.ejercicio3.VerticeImplListAdy;

public class DFSyBFS {
    public static void main(String[] args){
        
        GrafoImplListAdy grafo = new GrafoImplListAdy<Integer>();
        
		VerticeImplListAdy<Integer> vert1 = new VerticeImplListAdy<Integer>(1);
		VerticeImplListAdy<Integer> vert2 = new VerticeImplListAdy<Integer>(2);
		VerticeImplListAdy<Integer> vert3 = new VerticeImplListAdy<Integer>(3);
		grafo.agregarVertice(vert1);
		grafo.agregarVertice(vert2);
		grafo.agregarVertice(vert3);
		grafo.conectar(vert1, vert2);
		grafo.conectar(vert1, vert3);
		grafo.conectar(vert2, vert1);
		grafo.conectar(vert2, vert3);
		grafo.conectar(vert3, vert1);
		grafo.conectar(vert3, vert2);		
		
		Recorrido recorrido= new Recorrido(gr);
        ListaGenerica<Integer> lista_dfs= dfs(Grafo<T> grafo): ListaGenerica <T> // Retorna una lista de vértices con el recorrido en profundidad del grafo recibido como parámetro.
    }
}
