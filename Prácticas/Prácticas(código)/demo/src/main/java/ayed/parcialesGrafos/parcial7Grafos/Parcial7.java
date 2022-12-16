package ayed.parcialesGrafos.parcial7Grafos;

import ayed.tp02.ejercicio2.ListaEnlazadaGenerica;
import ayed.tp02.ejercicio2.ListaGenerica;
import ayed.tp02.ejercicio3.ColaGenerica;
import ayed.tp06.ejercicio3.Arista;
import ayed.tp06.ejercicio3.Grafo;
import ayed.tp06.ejercicio3.Vertice;
import ayed.tp06.ejercicio6.ListaGenericaEnlazada;

public class Parcial7 {

    public ListaGenerica<Persona> resolver(Grafo<Persona> grafo, Vertice<Persona> empleado, int distancia, int maxCant) {
        ListaGenerica<Persona> listado= new ListaEnlazadaGenerica<Persona>();
        boolean[]marca= new boolean[grafo.listaDeVertices().tamanio() + 1];
        obtenerListado(grafo,empleado,distancia,maxCant,marca,listado);

        return listado;
    }

    private void obtenerListado(Grafo<Persona> grafo, Vertice<Persona> empleado, int distancia, int maxCant, boolean[] marca, ListaGenerica<Persona> listado) {
        ColaGenerica<Vertice<Persona>> cola = new ColaGenerica<Vertice<Persona>>();
        marca[empleado.getPosicion()]=true;
        cola.encolar(empleado);
        cola.encolar(null);
        while (!cola.esVacia() && listado.tamanio() < maxCant && distancia >0 ){
            Vertice<Persona> v= cola.desencolar();
            if (v != null){
                ListaGenerica<Arista<Persona>> ady = grafo.listaDeAdyacentes(v);
                ady.comenzar();
                while (!ady.fin() && listado.tamanio() < maxCant){
                    Arista<Persona> arista= ady.proximo();
                    int pos= arista.verticeDestino().getPosicion();
                    if (!marca[pos]){
                        cola.encolar(arista.verticeDestino());
                        marca[pos]=true;
                        if (arista.verticeDestino().dato().getTipo().equals("Jubilado")){
                            listado.agregarFinal(arista.verticeDestino().dato());
                        }
                        
                    }
                }
            }
            else{
                if (!cola.esVacia()){
                    distancia--;
                    cola.encolar(null);
                }
            }

        }



    }

}
