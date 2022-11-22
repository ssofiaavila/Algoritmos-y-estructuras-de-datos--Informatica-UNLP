package ayed.parcialesArboles.ejercicio7;

import ayed.tp03.ejercicio1.ArbolBinario;

public class SumaImpares {
    

    public Integer sumaImparesPosOrdenMayorA(ArbolBinario<Integer> ab, int limite) {
        int sumaTotal=0;
        
        if (ab.tieneHijoIzquierdo()){
            sumaTotal+= sumaImparesPosOrdenMayorA(ab.getHijoIzquierdo(),limite);
        }
        if (ab.tieneHijoDerecho()){
            sumaTotal+= sumaImparesPosOrdenMayorA(ab.getHijoDerecho(),limite);
        }
        if (this.cumple(ab.getDato(),limite)){
            sumaTotal+= ab.getDato();
        }
       return sumaTotal;
    }

    private boolean cumple(Integer dato, int limite) {
        if ((dato> limite) && (dato % 2 ==1))
            return true;
        return false;
    }


    


}
