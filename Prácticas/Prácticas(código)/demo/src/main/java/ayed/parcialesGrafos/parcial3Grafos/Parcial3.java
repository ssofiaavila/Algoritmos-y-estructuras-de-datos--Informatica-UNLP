package ayed.parcialesGrafos.parcial3Grafos;

import ayed.tp02.ejercicio2.ListaEnlazadaGenerica;
import ayed.tp02.ejercicio2.ListaGenerica;
import ayed.tp06.ejercicio3.Arista;
import ayed.tp06.ejercicio3.Grafo;
import ayed.tp06.ejercicio3.Vertice;

public class Parcial3 {

    public ListaGenerica<ListaGenerica<String>> resolver(Grafo<String> ciudades, String origen, String destino, String pasandoPor) {
        boolean[] marca= new boolean[ciudades.listaDeVertices().tamanio() + 1];
        ListaGenerica<ListaGenerica<String>> recorridos= new ListaEnlazadaGenerica<ListaGenerica<String>>();
        ListaGenerica<String> camino= new ListaEnlazadaGenerica<String>();
        
        ListaGenerica<Vertice<String>> vertices= ciudades.listaDeVertices();
        boolean encontre=false;
        int indice=-1;
        Vertice<String> vertice;
        vertices.comenzar();
        while ((!vertices.fin()) && (!encontre)){
            vertice=vertices.proximo();
            if (vertice.dato().equals(origen)){
                indice=vertice.getPosicion();
                encontre=true;
            }
        }
        if (indice !=-1){
            
            resolver(indice,ciudades,recorridos,camino,marca,destino,pasandoPor);
        }    

        return recorridos;
    }

    private void resolver(int indice, Grafo<String> ciudades, ListaGenerica<ListaGenerica<String>> recorridos, ListaGenerica<String> camino, boolean[] marca, String destino, String pasandoPor) {
        marca[indice]=true;
        Vertice<String> v= ciudades.listaDeVertices().elemento(indice);
        camino.agregarFinal(v.dato());
        if (v.dato().equals(destino) && (camino.incluye(pasandoPor))){
            recorridos.agregarFinal(camino.clonar());
        }
        else{
            ListaGenerica<Arista<String>> ady= ciudades.listaDeAdyacentes(v);
            ady.comenzar();            
            while (!ady.fin()){
                Arista<String> arista= ady.proximo();
                int j= arista.verticeDestino().getPosicion();
                if ((!marca[j]) && (arista.peso()==1)){
                    resolver(j,ciudades,recorridos,camino,marca,destino,pasandoPor);
                    marca[j]=false;
                    camino.eliminarEn(camino.tamanio());
                    
                }



            }
            
        }
    }

}
