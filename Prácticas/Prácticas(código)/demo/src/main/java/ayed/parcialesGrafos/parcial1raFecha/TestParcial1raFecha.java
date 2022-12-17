package ayed.parcialesGrafos.parcial1raFecha;

import ayed.tp02.ejercicio2.ListaGenerica;
import ayed.tp06.ejercicio3.Grafo;
import ayed.tp06.ejercicio3.GrafoImplListAdy;
import ayed.tp06.ejercicio3.Vertice;
import ayed.tp06.ejercicio3.VerticeImplListAdy;

public class TestParcial1raFecha {
    public static void main(String[] args) {
        /* 1 */Estadio e1 = new Estadio("Al Bayt Stadium", "Jor");
        Vertice<Estadio> estadio1 = new VerticeImplListAdy<Estadio>(e1);


        /* 2 */Estadio e2 = new Estadio("Lusail Stadium", "Lusail");
        Vertice<Estadio> estadio2 = new VerticeImplListAdy<Estadio>(e2);

        /* 3 */Estadio e3 = new Estadio("Education City Staium", "Rayan");
        Vertice<Estadio> estadio3= new VerticeImplListAdy<Estadio>(e3);


        /* 4 */Estadio e4 = new Estadio("Al Rayyan Stadium", "Rayan");
        Vertice<Estadio> estadio4 = new VerticeImplListAdy<Estadio>(e4);

        /* 5 */Estadio e5 = new Estadio("Khalifa International Stadium", "Doha");
        Vertice<Estadio> estadio5 = new VerticeImplListAdy<Estadio>(e5);

        /* 6 */Estadio e6 = new Estadio("Al Thumama Stadium", "Doha");
        Vertice<Estadio> estadio6 = new VerticeImplListAdy<Estadio>(e6);

        /* 7 */Estadio e7 = new Estadio("Al Janoub Stadium", "Wakrah");
        Vertice<Estadio> estadio7 = new VerticeImplListAdy<Estadio>(e7);

        /* 8 */Estadio e8 = new Estadio("Stadium 947", "Doha");
        Vertice<Estadio> estadio8 = new VerticeImplListAdy<Estadio>(e8);
       

        Grafo<Estadio> estadios = new GrafoImplListAdy<Estadio>();

        estadios.agregarVertice(estadio1);
        estadios.agregarVertice(estadio2);
        estadios.agregarVertice(estadio3);
        estadios.agregarVertice(estadio4);
        estadios.agregarVertice(estadio5);
        estadios.agregarVertice(estadio6);
        estadios.agregarVertice(estadio7);
        estadios.agregarVertice(estadio8);


        estadios.conectar(estadio1, estadio2, 42);
        estadios.conectar(estadio2, estadio1, 42);

        estadios.conectar(estadio2, estadio3, 24);
        estadios.conectar(estadio3, estadio2, 24);

        estadios.conectar(estadio3, estadio4, 11);
        estadios.conectar(estadio4, estadio3, 11);

        estadios.conectar(estadio4, estadio5, 8);
        estadios.conectar(estadio5, estadio4, 8);

        estadios.conectar(estadio5, estadio6, 12);
        estadios.conectar(estadio6, estadio5, 12);

        estadios.conectar(estadio6, estadio7, 12);
        estadios.conectar(estadio7, estadio6, 12);

        estadios.conectar(estadio7, estadio8, 19);
        estadios.conectar(estadio8, estadio7, 19);

        estadios.conectar(estadio8, estadio2, 52);
        estadios.conectar(estadio2, estadio8, 52);

        

        Parcial1raFecha parcial= new Parcial1raFecha();
        ListaGenerica<String> listado =parcial.resolver(estadios, "Al Bayt Stadium", 100);
        System.out.println(listado);
        

        /*
         * imprime
         * Al Bayt Stadium
         * Lusail Stadium
         * Education City Stadium
         * Al Rayyan Stadium
         * Khalifa International Stadium
         * Al Thunama Staium
         * Total = 6 estadios
         */

    }

}
