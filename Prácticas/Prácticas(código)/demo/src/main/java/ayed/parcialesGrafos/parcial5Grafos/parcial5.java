package ayed.parcialesGrafos.parcial5Grafos;

import ayed.tp02.ejercicio2.ListaEnlazadaGenerica;
import ayed.tp02.ejercicio2.ListaGenerica;
import ayed.tp06.ejercicio3.Arista;
import ayed.tp06.ejercicio3.Grafo;
import ayed.tp06.ejercicio3.Vertice;
import ayed.tp06.ejercicio6.ListaGenericaEnlazada;

public class parcial5 {

    public ListaGenerica<String> resolver(Grafo<Sitio> grafo) {
        boolean[]marca= new boolean[grafo.listaDeVertices().tamanio() + 1];
        ListaGenerica<String> camino= new ListaEnlazadaGenerica<String>();

        boolean encontre=false;
        ListaGenerica<Vertice<Sitio>> vertices= grafo.listaDeVertices();
        vertices.comenzar();
        Vertice<Sitio> aux=null;
        while (!vertices.fin() && !encontre){
            aux=vertices.proximo();
            if (aux.dato().getNombre().equals("Municipalidad")){
                encontre=true;
            }              
        }
        if (encontre){
            buscarCamino(aux.getPosicion(),grafo,marca,camino);
        }
        return camino;
    }

    private boolean buscarCamino(int posicion, Grafo<Sitio> grafo, boolean[] marca, ListaGenerica<String> camino) {
        boolean encontre=false;
        marca[posicion]=true;
        Vertice<Sitio> v= grafo.listaDeVertices().elemento(posicion);
        camino.agregarFinal(v.dato().getNombre());
        if (v.dato().getNombre().equals("Casa del Intendente")){
            encontre=true;
        }
        else{
            ListaGenerica<Arista<Sitio>> ady= grafo.listaDeAdyacentes(v);
            ady.comenzar();
            while (!ady.fin() && !encontre){
                Arista<Sitio> arista= ady.proximo();
                int pos= arista.verticeDestino().getPosicion();
                if (!marca[pos] && arista.peso()!=1 && arista.verticeDestino().dato().getEstado().equals("Sin control Mafia")){
                    encontre=buscarCamino(pos,grafo,marca,camino);
                }
            }
            if (!encontre){
                marca[posicion]=false;
                camino.eliminarEn(camino.tamanio());
            }
           
        }
        return encontre;


    }
    
}
