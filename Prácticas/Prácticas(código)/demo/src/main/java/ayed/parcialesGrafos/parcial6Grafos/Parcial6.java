package ayed.parcialesGrafos.parcial6Grafos;

import ayed.tp02.ejercicio2.ListaEnlazadaGenerica;
import ayed.tp02.ejercicio2.ListaGenerica;
import ayed.tp06.ejercicio3.Arista;
import ayed.tp06.ejercicio3.Grafo;
import ayed.tp06.ejercicio3.Vertice;

public class Parcial6 {

    public ListaGenerica<ListaGenerica<String>> caminosCosto10(Grafo<String> ciudades) {
        ListaGenerica<ListaGenerica<String>> caminos = new ListaEnlazadaGenerica<ListaGenerica<String>>();
        ListaGenerica<String> aux = new ListaEnlazadaGenerica<String>();
        boolean[] marca = new boolean[ciudades.listaDeVertices().tamanio() + 1];
        int costo;
        for (int i = 1; i <= ciudades.listaDeVertices().tamanio(); i++) {
            costo = 0;
            caminosCosto10(i, ciudades, caminos, marca, aux, costo);
            marca[i] = false;
            aux.eliminarEn(aux.tamanio());
        }

        return caminos;

    }

    private void caminosCosto10(int i, Grafo<String> ciudades, ListaGenerica<ListaGenerica<String>> caminos,
            boolean[] marca, ListaGenerica<String> aux, int costo) {
        marca[i] = true;
        Vertice<String> v = ciudades.listaDeVertices().elemento(i);
        aux.agregarFinal(v.dato());
        if (costo == 10) {
            caminos.agregarFinal(aux.clonar());
        } 
        else {
            ListaGenerica<Arista<String>> ady= ciudades.listaDeAdyacentes(v);
            ady.comenzar();
            while (!ady.fin()){
                Arista<String> arista=ady.proximo();
                int j = arista.verticeDestino().getPosicion();
                if (!marca[j] && (costo + arista.peso() <= 10)){
                    caminosCosto10(j,ciudades,caminos,marca,aux,costo+arista.peso());
                    marca[j]=false;
                    aux.eliminarEn(aux.tamanio());
                }
            }
        }

    }
}
