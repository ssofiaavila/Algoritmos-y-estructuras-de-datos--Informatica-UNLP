package ayed.parcialesGrafos.parcial2Grafos;

import ayed.tp02.ejercicio2.ListaGenerica;
import ayed.tp06.ejercicio3.Grafo;
import ayed.tp06.ejercicio3.GrafoImplListAdy;
import ayed.tp06.ejercicio3.VerticeImplListAdy;

public class TestParcial {
    public static void main(String[]args){

        Grafo<String> ciudades = new GrafoImplListAdy<String>();
		
		VerticeImplListAdy<String> lincoln = new VerticeImplListAdy<String>("Lincoln");
		VerticeImplListAdy<String> chascomus = new VerticeImplListAdy<String>("Chascomus");
		VerticeImplListAdy<String> canuelas = new VerticeImplListAdy<String>("Cañuelas");
		VerticeImplListAdy<String> dolores = new VerticeImplListAdy<String>("Dolores");
		VerticeImplListAdy<String> veronica = new VerticeImplListAdy<String>("Verónica");
		VerticeImplListAdy<String> villurka = new VerticeImplListAdy<String>("Villa Urquiza");
		VerticeImplListAdy<String> ranchos = new VerticeImplListAdy<String>("Ranchos");
		VerticeImplListAdy<String> berisso = new VerticeImplListAdy<String>("Berisso");
		
		lincoln.conectar(dolores, 90);
        lincoln.conectar(chascomus, 70);
        lincoln.conectar(canuelas, 50);
        
        chascomus.conectar(lincoln, 70);
        chascomus.conectar(veronica, 80);
        chascomus.conectar(villurka, 60);
        
        canuelas.conectar(lincoln, 50);
        canuelas.conectar(veronica, 85);
        canuelas.conectar(ranchos, 90);
        
        dolores.conectar(ranchos, 70);
        dolores.conectar(lincoln, 90);
        dolores.conectar(villurka, 70);
        
        veronica.conectar(chascomus, 80);
        veronica.conectar(canuelas, 85);
        veronica.conectar(berisso, 60);
        
        villurka.conectar(chascomus, 60);
        villurka.conectar(dolores, 70);
        villurka.conectar(berisso, 90);
        
        ranchos.conectar(berisso, 75);
        ranchos.conectar(canuelas, 90);
        ranchos.conectar(dolores, 70);
        
        berisso.conectar(veronica, 60);
        berisso.conectar(villurka, 90);
        berisso.conectar(ranchos, 75);
		
        




        BuscadorDeCamino resolver= new BuscadorDeCamino();
        ListaGenerica<String> recorrido= resolver.caminoConPresupuesto(ciudades, "Lincoln" , "Berisso", 200);
        recorrido.comenzar();
        while (!recorrido.fin()){
            System.out.println(recorrido.proximo());
        }

    }
    
}
