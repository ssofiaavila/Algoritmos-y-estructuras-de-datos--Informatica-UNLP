package ayed.parcialesGrafos.parcial6Grafos;

import ayed.tp02.ejercicio2.ListaEnlazadaGenerica;
import ayed.tp02.ejercicio2.ListaGenerica;
import ayed.tp06.ejercicio3.Grafo;
import ayed.tp06.ejercicio3.GrafoImplListAdy;
import ayed.tp06.ejercicio3.Vertice;
import ayed.tp06.ejercicio3.VerticeImplListAdy;

public class TestParcial6 {
    public static void main(String[] args){



        Vertice<String> v1 = new VerticeImplListAdy<String>("Buenos Aires");
		Vertice<String> v2 = new VerticeImplListAdy<String>("Santiago");
		Vertice<String> v3 = new VerticeImplListAdy<String>("Lima");
		Vertice<String> v4 = new VerticeImplListAdy<String>("Montevideo");
		Vertice<String> v5 = new VerticeImplListAdy<String>("Asuncion");
		Vertice<String> v6 = new VerticeImplListAdy<String>("Caracas");
		Vertice<String> v7 = new VerticeImplListAdy<String>("La Habana");

		Grafo<String> ciudades = new GrafoImplListAdy<String>();
		
		ciudades.agregarVertice(v1);
		ciudades.agregarVertice(v2);
		ciudades.agregarVertice(v3);
		ciudades.agregarVertice(v4);
		ciudades.agregarVertice(v5);
		ciudades.agregarVertice(v6);
		ciudades.agregarVertice(v7);

		ciudades.conectar(v1, v2,3);
		ciudades.conectar(v1, v3,2);
		ciudades.conectar(v1, v4,4);
		ciudades.conectar(v1, v5,10);
		ciudades.conectar(v2, v5,500);
		ciudades.conectar(v2, v7,4);
		ciudades.conectar(v3, v5,4);
		ciudades.conectar(v4, v5,6);
		ciudades.conectar(v6, v5,11);
		ciudades.conectar(v6, v7,10);


       


        Parcial6 resolver= new Parcial6();
        ListaGenerica<ListaGenerica<String>> recorridos= resolver.caminosCosto10(ciudades);
        recorridos.comenzar();
		ListaGenerica<String> aux;
        while (!recorridos.fin()){
            
                System.out.println(recorridos.proximo());
         
            System.out.println("--------------------------");
   

        }
  



        // ESPERO 3 CAMINOS


        




    }

    
}
