package ayed.parcialesGrafos.parcial8Grafos;

import ayed.tp02.ejercicio2.ListaEnlazadaGenerica;
import ayed.tp02.ejercicio2.ListaGenerica;
import ayed.tp06.ejercicio3.Arista;
import ayed.tp06.ejercicio3.Grafo;
import ayed.tp06.ejercicio3.Vertice;
import ayed.tp06.ejercicio6.ListaGenericaEnlazada;

public class BuscadorDeCaminos {
    private Grafo<String> bosque;

    public BuscadorDeCaminos(Grafo<String> bosque) {
        this.bosque = bosque;
    }

    public ListaGenerica<ListaGenerica<String>> recorridosMasSeguro() {
        ListaGenerica<ListaGenerica<String>> caminos = new ListaEnlazadaGenerica<ListaGenerica<String>>();
        ListaGenerica<String> actual = new ListaEnlazadaGenerica<String>();
        boolean[] marca = new boolean[this.bosque.listaDeVertices().tamanio() + 1];
        boolean encontre = false;
        Vertice<String> aux = null;
        ListaGenerica<Vertice<String>> vertices = this.bosque.listaDeVertices();
        vertices.comenzar();
        while (!vertices.fin() && !encontre) {
            aux = vertices.proximo();
            if (aux.dato().equals("Casa Caperucita")) {
                encontre = true;
            }
        }
        if (encontre)
            recorridosMasSeguros(aux.getPosicion(), this.bosque, caminos, actual, marca);
        return caminos;
    }

    private void recorridosMasSeguros(int posicion, Grafo<String> grafo, ListaGenerica<ListaGenerica<String>> caminos,ListaGenerica<String> actual, boolean[] marca) {
        marca[posicion] = true;
        Vertice<String> v = grafo.listaDeVertices().elemento(posicion);
        actual.agregarFinal(v.dato());
        if (v.dato().equals("Casa Abuelita")) {
            caminos.agregarFinal(actual.clonar());
        } else {
            ListaGenerica<Arista<String>> ady = grafo.listaDeAdyacentes(v);
            ady.comenzar();
            while (!ady.fin()) {
                Arista<String> arista = ady.proximo();
                int j = arista.verticeDestino().getPosicion();
                if (!marca[j] && arista.peso() < 5) {
                    recorridosMasSeguros(j, grafo, caminos, actual, marca);
                    actual.eliminarEn(actual.tamanio());
                    marca[j] = false;
                }
            }

        }

    }

}
