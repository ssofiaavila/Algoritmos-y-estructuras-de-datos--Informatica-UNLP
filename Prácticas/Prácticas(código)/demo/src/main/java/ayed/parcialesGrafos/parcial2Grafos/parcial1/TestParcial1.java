package ayed.parcial2Grafos.parcial1;

import ayed.tp02.ejercicio2.ListaGenerica;
import ayed.tp06.ejercicio3.Grafo;
import ayed.tp06.ejercicio3.GrafoImplListAdy;
import ayed.tp06.ejercicio3.VerticeImplListAdy;

public class TestParcial1 {
    public static void main(String[] args){
        Grafo<Ciudad> ciudades = new GrafoImplListAdy<Ciudad>();

		VerticeImplListAdy<Ciudad> quilmes = new VerticeImplListAdy<Ciudad>(new Ciudad("Quilmes", 1));
		VerticeImplListAdy<Ciudad> moreno = new VerticeImplListAdy<Ciudad>(new Ciudad("Moreno", 1));
		VerticeImplListAdy<Ciudad> carloskeen = new VerticeImplListAdy<Ciudad>(new Ciudad("Carlos Keen", 3));
		VerticeImplListAdy<Ciudad> suipacha = new VerticeImplListAdy<Ciudad>(new Ciudad("Suipacha", 5));
		VerticeImplListAdy<Ciudad> laplata = new VerticeImplListAdy<Ciudad>(new Ciudad("La Plata", 2));
		VerticeImplListAdy<Ciudad> abasto = new VerticeImplListAdy<Ciudad>(new Ciudad("Abasto", 2));
		VerticeImplListAdy<Ciudad> canuelas = new VerticeImplListAdy<Ciudad>(new Ciudad("Cañuelas", 3));
		VerticeImplListAdy<Ciudad> navarro = new VerticeImplListAdy<Ciudad>(new Ciudad("Navarro", 4));
		VerticeImplListAdy<Ciudad> pinamar = new VerticeImplListAdy<Ciudad>(new Ciudad("Pinamar", 3));
		VerticeImplListAdy<Ciudad> lobos = new VerticeImplListAdy<Ciudad>(new Ciudad("Lobos", 3));
		VerticeImplListAdy<Ciudad> saladillo = new VerticeImplListAdy<Ciudad>(new Ciudad("Saladillo", 4));
		
		quilmes.conectar(moreno);
		quilmes.conectar(laplata);
		
		moreno.conectar(quilmes);
		moreno.conectar(abasto);
		moreno.conectar(carloskeen);
		
		carloskeen.conectar(moreno);
		carloskeen.conectar(suipacha);
		
		suipacha.conectar(carloskeen);
		suipacha.conectar(navarro);
		
		laplata.conectar(quilmes);
		laplata.conectar(pinamar);
		laplata.conectar(abasto);
		
		abasto.conectar(laplata);
		abasto.conectar(moreno);
		abasto.conectar(canuelas);
		
		canuelas.conectar(abasto);
		canuelas.conectar(navarro);
		
		navarro.conectar(canuelas);
		navarro.conectar(suipacha);
		navarro.conectar(lobos);
		navarro.conectar(saladillo);
		
		pinamar.conectar(laplata);
		
		lobos.conectar(navarro);
		
		saladillo.conectar(navarro);
		
		ciudades.agregarVertice(quilmes);
		ciudades.agregarVertice(moreno);
		ciudades.agregarVertice(carloskeen);
		ciudades.agregarVertice(suipacha);
		ciudades.agregarVertice(laplata);
		ciudades.agregarVertice(abasto);
		ciudades.agregarVertice(canuelas);
		ciudades.agregarVertice(navarro);
		ciudades.agregarVertice(pinamar);
		ciudades.agregarVertice(lobos);
		ciudades.agregarVertice(saladillo);
		
		parcial1 parcial = new parcial1();
		
		ListaGenerica<String> camino = parcial.resolver(ciudades, "La Plata", "Suipacha");
		System.out.println(camino.tamanio());
		camino.comenzar();
		while(!camino.fin()) {
			System.out.println(camino.proximo());
		}




    }
}
