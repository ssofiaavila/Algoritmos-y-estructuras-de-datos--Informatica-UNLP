package ayed.tp06.ejercicio5;

import ayed.tp02.ejercicio2.ListaGenerica;
import ayed.tp06.ejercicio3.Grafo;

public class Mapa {
    private Grafo<String> mapaCiudades;

    public Mapa(Grafo<String> ciudades) {
        this.mapaCiudades = ciudades;
    }



    public ListaGenerica<String> devolverCamino(String ciudad1, String ciudad2){

        return null;
    }



    public ListaGenerica<String> devolverCaminoExceptuando(String ciudad1,String ciudad2, ListaGenerica<String> ciudades){
                
        return null;
    }


    public ListaGenerica<String> caminoMasCorto(String ciudad1,String ciudad2){

        return null;
    }

    public ListaGenerica<String> caminoSinCargarCombustible(String ciudad1,String ciudad2, int tanqueAuto){

        return null;
    }

    public ListaGenerica<String> caminoConMenorCargaDeCombustible(String ciudad1, String ciudad2, int tanqueAuto){

        return null;
    }

}
