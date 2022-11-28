package ayed.parcialesGrafos.parcial9Grafos;

import ayed.tp02.ejercicio2.ListaGenerica;
import ayed.tp06.ejercicio3.Arista;
import ayed.tp06.ejercicio3.Grafo;
import ayed.tp06.ejercicio3.Vertice;


//devolver maxima cantidad de dias de estadias entre los caminos que no superen el maximo de controles permitidos
public class Parcial9 {

    public int resolver(Grafo<Ciudad> ciudades, String origen, String destino, int maxControles) {
        boolean[] marca= new boolean[ciudades.listaDeVertices().tamanio()+1];
        Max max= new Max();
        Vertice<Ciudad> origenV= buscar(ciudades,origen, destino);
        if (origenV!= null){
            resolver(origenV.getPosicion(),ciudades,marca,destino,maxControles,origenV.dato().getTransito(),max);
        }
        return max.getMax();
    }

    private void resolver(int i,Grafo<Ciudad> ciudades, boolean[]marca, String destino, int maxControles, int transito, Max max) {
        marca[i]=true;
        Vertice<Ciudad> v= ciudades.listaDeVertices().elemento(i);
        if (v.dato().getNombre().equals(destino)){
            if (transito > max.getMax()){
                max.setMax(transito);
            }
        }
        else{ 
            ListaGenerica<Arista<Ciudad>> adyacentes= ciudades.listaDeAdyacentes(v);
            adyacentes.comenzar();
            while (!adyacentes.fin()){
                Arista<Ciudad> aux=adyacentes.proximo();
                int j= aux.verticeDestino().getPosicion();
                if (!marca[j] && aux.peso() <= maxControles){
                    resolver(j,ciudades,marca,destino,maxControles, transito+aux.verticeDestino().dato().getTransito(),max);
                    marca[j]=false;
                }
            }
        }


    }


    private Vertice<Ciudad> buscar(Grafo<Ciudad> ciudades,String origen, String destino) {
        Vertice<Ciudad> verticeO= null;
        boolean encontreO=false;
        boolean encontreD=false;
        ListaGenerica<Vertice<Ciudad>> vertices= ciudades.listaDeVertices();
        vertices.comenzar();
        Vertice<Ciudad> aux=null;
        while (!vertices.fin() && !encontreO && !encontreD){
            aux= vertices.proximo();
            if (aux.dato().getNombre().equals(origen))
                encontreO=true;
                verticeO=aux; 
            if (aux.dato().getNombre().equals(destino))
                encontreD=true;           
        }    
        return verticeO;
    }

}
