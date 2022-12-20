package ayed.parcialesGrafos.fecha1OtraVez;

import ayed.parcialesGrafos.parcial1raFecha.Estadio;
import ayed.tp02.ejercicio2.ListaEnlazadaGenerica;
import ayed.tp02.ejercicio2.ListaGenerica;
import ayed.tp06.ejercicio3.Grafo;
import ayed.tp06.ejercicio3.Vertice;

public class Parcial1raFecha {

    public ListaGenerica<String> resolver(Grafo<Estadio> estadios, String origen, int km) {
        boolean[] marca= new boolean[estadios.listaDeVertices().tamanio()+1];
        ListaGenerica<Vertice<Estadio>> vertices= estadios.listaDeVertices();
        Vertice<Estadio> vertice = null;
        boolean encontre=false;
        Max max = new Max();
        vertices.comenzar();
        while (!vertices.fin() && !encontre){
            vertice = vertices.proximo();
            if (vertice.dato().getEstadio().equals(origen)){
                encontre=true;
            }
        }
        if (encontre){
            ListaGenerica<String> actual= new ListaEnlazadaGenerica<String>();
            resolver(vertice.getPosicion(),marca,estadios,km,0,max,actual);
        }
        return max.getLista();
    }

    private void resolver(int posicion, boolean[]marca, Grafo<Estadio> estadios, int km, int maxEstadios, Max max, ListaGenerica<String> actual) {
        marca[posicion]=true;
        Vertice<Estadio> v = estadios

    }

}
