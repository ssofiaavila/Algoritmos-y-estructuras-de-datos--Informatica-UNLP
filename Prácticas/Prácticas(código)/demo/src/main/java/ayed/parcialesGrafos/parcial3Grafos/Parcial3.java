package ayed.parcialesGrafos.parcial3Grafos;

import ayed.tp02.ejercicio2.ListaEnlazadaGenerica;
import ayed.tp02.ejercicio2.ListaGenerica;
import ayed.tp06.ejercicio3.Arista;
import ayed.tp06.ejercicio3.Grafo;
import ayed.tp06.ejercicio3.Vertice;
import ayed.tp06.ejercicio6.ListaGenericaEnlazada;

public class Parcial3 {

    public ListaGenerica<ListaGenerica<String>> resolver(Grafo<String> ciudades, String origen, String destino, String pasandoPor) {
        ListaGenerica<ListaGenerica<String>> caminos= new ListaEnlazadaGenerica<ListaGenerica<String>>();
        boolean[]marca= new boolean[ciudades.listaDeVertices().tamanio()+1];
        ListaGenerica<String> actual= new ListaEnlazadaGenerica<String>();
        boolean encontre=false;
        ListaGenerica<Vertice<String>> vertices= ciudades.listaDeVertices();
        Vertice<String> aux;
        vertices.comenzar();
        int posicion=-1;
        while(!vertices.fin() && !encontre){
            aux=vertices.proximo();
            if (aux.dato().equals(origen)){
                posicion=aux.getPosicion();
                encontre=true;
            }
        }
        if (encontre){
            actual.agregarFinal(ciudades.listaDeVertices().elemento(posicion).dato());
            resolver(posicion,ciudades,marca,caminos,actual,destino,pasandoPor);
        }       
        return caminos;
    }


    private void resolver(int posicion, Grafo<String> ciudades, boolean[] marca, ListaGenerica<ListaGenerica<String>> caminos, ListaGenerica<String> actual, String destino, String pasandoPor) {
        marca[posicion]=true;
        Vertice<String> v= ciudades.listaDeVertices().elemento(posicion);
        if (v.dato().equals(destino)){
            if (actual.incluye(pasandoPor)){
                caminos.agregarFinal(actual.clonar());
            }
        }else{
            ListaGenerica<Arista<String>> ady=ciudades.listaDeAdyacentes(v);
            ady.comenzar();
            while (!ady.fin()){
                Arista<String> arista= ady.proximo();
                int pos=arista.verticeDestino().getPosicion();
                if (!marca[pos] && arista.peso()==1){
                    actual.agregarFinal(arista.verticeDestino().dato());
                    resolver(pos,ciudades,marca,caminos,actual,destino,pasandoPor);
                    marca[pos]= false;
                    actual.eliminarEn(actual.tamanio());
                }
            }
        }  
    
    }

}
