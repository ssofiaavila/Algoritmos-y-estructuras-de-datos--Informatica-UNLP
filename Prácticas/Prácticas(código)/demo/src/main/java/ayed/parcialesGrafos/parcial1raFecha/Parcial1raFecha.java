package ayed.parcialesGrafos.parcial1raFecha;

import ayed.parcialesGrafos.parcial9Grafos.Max;
import ayed.tp02.ejercicio2.ListaEnlazadaGenerica;
import ayed.tp02.ejercicio2.ListaGenerica;
import ayed.tp06.ejercicio3.Arista;
import ayed.tp06.ejercicio3.Grafo;
import ayed.tp06.ejercicio3.Vertice;
import ayed.tp06.ejercicio6.ListaGenericaEnlazada;

public class Parcial1raFecha {

    public ListaGenerica<String> resolver(Grafo<Estadio> estadios, String origen, int kilometros) {
        ListaGenerica<String> actual = new ListaEnlazadaGenerica<String>();
        boolean[] marca = new boolean[estadios.listaDeVertices().tamanio() + 1];
        Max max = new Max();
        boolean encontre = false;
        ListaGenerica<Vertice<Estadio>> vertices = estadios.listaDeVertices();
        Vertice<Estadio> aux = null;
        vertices.comenzar();
        while (!vertices.fin() && !encontre) {
            aux = vertices.proximo();
            if (aux.dato().getEstadio().equals("Al Bayt Stadium")) {
                encontre = true;
            }
        }
        if (aux != null) {
            resolver(aux.getPosicion(), estadios, actual, kilometros, marca, max, 0);
        }
        return max.getCamino();
    }

    // lista con la mayor cantidad de estadios que puedo recorrer con determinada cant de km

    private void resolver(int posicion, Grafo<Estadio> estadios, ListaGenerica<String> actual, int kilometros, boolean[] marca, Max max, int cantActual) {
        marca[posicion] = true;
        Vertice<Estadio> v = estadios.listaDeVertices().elemento(posicion);
        actual.agregarFinal(v.dato().getEstadio());
        cantActual++;
        ListaGenerica<Arista<Estadio>> ady = estadios.listaDeAdyacentes(v);
        ady.comenzar();
        while (!ady.fin()) {
            Arista<Estadio> arista = ady.proximo();
            int j = arista.verticeDestino().getPosicion();
            if (!marca[j] && arista.peso() <= kilometros) {
                resolver(j, estadios, actual, kilometros - arista.peso(), marca, max, cantActual);
                marca[j] = false;
                actual.eliminarEn(actual.tamanio());
            } else {
                if (arista.peso() >= kilometros) {
                    if (cantActual > max.getMax()) {
                        max.setMax(cantActual);
                        max.setCamino(actual.clonar());
                    }
                }
            }                        
        }

    }

}
