package ayed.parcialesGrafos.parcial4Grafos;

import ayed.tp06.ejercicio3.Grafo;
import ayed.tp06.ejercicio3.GrafoImplListAdy;
import ayed.tp06.ejercicio3.Vertice;
import ayed.tp06.ejercicio3.VerticeImplListAdy;

public class TestParcial4 {
    public static void main(String[] args) {
		/*1*/	Vertice<String> Jorge = new VerticeImplListAdy<String>("Jorge");
		/*2*/	Vertice<String> Ariel = new VerticeImplListAdy<String>("Ariel");
		/*3*/	Vertice<String> Juan = new VerticeImplListAdy<String>("Juan");
		/*4*/	Vertice<String> Matias = new VerticeImplListAdy<String>("Matias");
		
		Grafo<String> personas = new GrafoImplListAdy<String>();
		
		personas.agregarVertice(Jorge);
		personas.agregarVertice(Matias);
		personas.agregarVertice(Juan);
		personas.agregarVertice(Ariel);
		
	/*	personas.conectar(Jorge, Matias);
		personas.conectar(Matias, Jorge);
		personas.conectar(Matias, Ariel);
		personas.conectar(Ariel, Matias);
		personas.conectar(Juan, Matias);
		personas.conectar(Matias, Juan);
		personas.conectar(Ariel, Juan);
		personas.conectar(Juan, Ariel); */
		
		personas.conectar(Jorge, Juan);
		personas.conectar(Juan, Jorge);
		
		personas.conectar(Matias, Ariel);
		personas.conectar(Ariel, Matias);
		
		gradosDeSeparacion parcial = new gradosDeSeparacion();
		
		System.out.println("MAXIMO GRADO DE SEPARACION: " + parcial.maximoGradoDeSeparacion(personas));
		
		
		

	}

}
