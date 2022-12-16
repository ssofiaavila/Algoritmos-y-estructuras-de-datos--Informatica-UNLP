package ayed.parcialesGrafos.parcial9Grafos;

import ayed.tp02.ejercicio2.ListaGenerica;
import ayed.tp06.ejercicio3.Arista;
import ayed.tp06.ejercicio3.Grafo;
import ayed.tp06.ejercicio3.Vertice;

public class Parcial9 {

    public int resolver(Grafo<Ciudad> ciudades, String origen, String destino, int maxControles) {
        Max max= new Max();
        boolean[]marca= new boolean[ciudades.listaDeVertices().tamanio() + 1];
        int i=existen(ciudades,origen,destino);
        if (i != -1){
            System.out.println(i);
            resolver(i,ciudades,destino,maxControles,marca,ciudades.listaDeVertices().elemento(i).dato().getMaxTransito(),max);
        }
        return max.getMax();
    }

    private void resolver(int i, Grafo<Ciudad> ciudades, String destino, int maxControles, boolean[]marca, int transito, Max max) {
        marca[i]=true;
        Vertice<Ciudad> v= ciudades.listaDeVertices().elemento(i);
        if (v.dato().getNombre().equals(destino)){
            if (transito > max.getMax()){
                max.setMax(transito);
            }
        }
        else{
            ListaGenerica<Arista<Ciudad>> ady= ciudades.listaDeAdyacentes(v);
            ady.comenzar();
            while (!ady.fin()){
                Arista<Ciudad> arista = ady.proximo();
                int j= arista.verticeDestino().getPosicion();
                if (!marca[j] && arista.peso()<=maxControles){
                    resolver(j,ciudades,destino,maxControles,marca,transito+arista.verticeDestino().dato().getMaxTransito(),max);
                    marca[j]=false;
                }

            }


        }

    }

    private int existen(Grafo<Ciudad> ciudades, String origen, String destino) {
        ListaGenerica<Vertice<Ciudad>> vertices=ciudades.listaDeVertices();
        Vertice<Ciudad> aux=null;
        vertices.comenzar();
        int pos=-1;
        boolean encontre=false, origenE=false, destinoE=false;
        while (!vertices.fin() && (encontre==false)){
			aux=vertices.proximo();
			if (aux.dato().getNombre().equals(origen)){
				origenE=true;
                pos=aux.getPosicion();
			}
            else{
                if (aux.dato().getNombre().equals(destino)){
                    destinoE=true;
                }
            }
			encontre= origenE && destinoE;
		}
        return pos;

  
    }

}
