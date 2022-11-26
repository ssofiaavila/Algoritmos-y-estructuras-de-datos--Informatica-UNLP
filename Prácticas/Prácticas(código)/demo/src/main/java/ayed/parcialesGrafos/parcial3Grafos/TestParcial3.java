package ayed.parcialesGrafos.parcial3Grafos;

import ayed.tp02.ejercicio2.ListaGenerica;
import ayed.tp06.ejercicio3.Grafo;
import ayed.tp06.ejercicio3.GrafoImplListAdy;
import ayed.tp06.ejercicio3.VerticeImplListAdy;

public class TestParcial3 {
    public static void main(String []args){

        Grafo<String> ciudades = new GrafoImplListAdy<String>();

        //el único valor que pueden tener las aristas es int así que si la ruta está habilitada, tiene valor 1, caso contrario vale 0 :p

        //CIUDADES
        VerticeImplListAdy<String> saladillo = new VerticeImplListAdy<String>("Saladillo");
        VerticeImplListAdy<String> lobos = new VerticeImplListAdy<String>("Lobos");
        VerticeImplListAdy<String> navarro = new VerticeImplListAdy<String>("Navarro");
        VerticeImplListAdy<String> suipacha = new VerticeImplListAdy<String>("Suipacha");
        VerticeImplListAdy<String> canuelas = new VerticeImplListAdy<String>("Cañuelas");
        VerticeImplListAdy<String> carlosKeen = new VerticeImplListAdy<String>("Carlos Keen");
        VerticeImplListAdy<String> abasto = new VerticeImplListAdy<String>("Abasto");
        VerticeImplListAdy<String> moreno = new VerticeImplListAdy<String>("Moreno");
        VerticeImplListAdy<String> quilmes = new VerticeImplListAdy<String>("Quilmes");
        VerticeImplListAdy<String> laPlata = new VerticeImplListAdy<String>("La Plata");
        VerticeImplListAdy<String> pinamar = new VerticeImplListAdy<String>("Pinamar");

        //CONECTO
        ciudades.agregarVertice(saladillo);
        ciudades.agregarVertice(lobos);
        ciudades.agregarVertice(navarro);
        ciudades.agregarVertice(suipacha);
        ciudades.agregarVertice(canuelas);
        ciudades.agregarVertice(carlosKeen);
        ciudades.agregarVertice(abasto);
        ciudades.agregarVertice(moreno);
        ciudades.agregarVertice(quilmes);
        ciudades.agregarVertice(laPlata);
        ciudades.agregarVertice(pinamar);












        ciudades.conectar(saladillo, navarro,1);

        ciudades.conectar(lobos,navarro,0);

        ciudades.conectar(navarro,canuelas,1);
        ciudades.conectar(navarro,suipacha,1);
        ciudades.conectar(navarro,saladillo,1);
        ciudades.conectar(navarro,lobos,0);

        ciudades.conectar(suipacha,navarro,1);
        ciudades.conectar(suipacha,carlosKeen,1);

        ciudades.conectar(canuelas,navarro,1);
        ciudades.conectar(canuelas,abasto,1);

        ciudades.conectar(carlosKeen,suipacha,1);
        ciudades.conectar(carlosKeen,abasto,1);
        ciudades.conectar(carlosKeen,moreno,1);

        ciudades.conectar(abasto,canuelas,1);
        ciudades.conectar(abasto,carlosKeen,1);
        ciudades.conectar(abasto,moreno,0);
        ciudades.conectar(abasto,laPlata,1);

        ciudades.conectar(moreno,carlosKeen,1);
        ciudades.conectar(moreno,quilmes,0);
        ciudades.conectar(moreno,abasto,0);
        
        ciudades.conectar(quilmes,moreno,0);
        ciudades.conectar(quilmes,laPlata,1);

        ciudades.conectar(laPlata,abasto,1);
        ciudades.conectar(laPlata,quilmes,1);
        ciudades.conectar(laPlata,pinamar,1);

        ciudades.conectar(laPlata,pinamar,1);

        Parcial3 resolver= new Parcial3();
        ListaGenerica<ListaGenerica<String>> recorridos= resolver.resolver(ciudades,"La Plata", "Suipacha", "Abasto");
        recorridos.comenzar();
      
        while (!recorridos.fin()){
            System.out.println(recorridos.proximo());
        }




    }
    
}
