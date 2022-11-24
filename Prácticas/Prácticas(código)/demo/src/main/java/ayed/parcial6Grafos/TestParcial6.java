package ayed.parcial6Grafos;

import ayed.tp02.ejercicio2.ListaEnlazadaGenerica;
import ayed.tp02.ejercicio2.ListaGenerica;
import ayed.tp06.ejercicio3.Grafo;
import ayed.tp06.ejercicio3.GrafoImplListAdy;
import ayed.tp06.ejercicio3.VerticeImplListAdy;

public class TestParcial6 {
    public static void main(String[] args){



        Grafo<String> ciudades = new GrafoImplListAdy<String>();

        VerticeImplListAdy<String> santiago = new VerticeImplListAdy<String>("Santiago");
        VerticeImplListAdy<String> buenosAires = new VerticeImplListAdy<String>("Buenos Aires");
        VerticeImplListAdy<String> montevideo = new VerticeImplListAdy<String>("Montevideo");
        VerticeImplListAdy<String> asuncion = new VerticeImplListAdy<String>("Asunción");
        VerticeImplListAdy<String> lima = new VerticeImplListAdy<String>("Lima");
        VerticeImplListAdy<String> caracas = new VerticeImplListAdy<String>("Caracas");
        VerticeImplListAdy<String> laHabana = new VerticeImplListAdy<String>("La Habana");

        santiago.conectar(laHabana, 4);
        santiago.conectar(asuncion,500);
        
        buenosAires.conectar(santiago,3);
        buenosAires.conectar(asuncion,10);
        buenosAires.conectar(montevideo,4);
        buenosAires.conectar(lima,2);

        montevideo.conectar(asuncion,6);

        lima.conectar(asuncion,4);
        
        caracas.conectar(asuncion,11);
        caracas.conectar(laHabana,10);

        Parcial6 resolver= new Parcial6();
        ListaGenerica<ListaGenerica<String>> recorridos= resolver.caminosCosto10(ciudades);
        recorridos.comenzar();

		ListaGenerica<String> aux;
        while (!recorridos.fin()){
            aux= recorridos.proximo();
            aux.comenzar();
            while (!aux.fin()){
                System.out.println(aux.proximo());
            }
            System.out.println("--------------------------");
        }


        // ESPERO 3 CAMINOS


        




    }

    
}
