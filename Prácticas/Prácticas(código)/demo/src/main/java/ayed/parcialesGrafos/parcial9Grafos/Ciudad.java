package ayed.parcialesGrafos.parcial9Grafos;

public class Ciudad {

    private String nombre;
    private int transito;

    public Ciudad(String nombre, int transito){
        this.nombre = nombre;
        this.transito = transito;
    }

    public void setNombre(String nombre){
        this.nombre=nombre;
    }

    public String getNombre(){
        return this.nombre;
    }
    public void setTransito(int transito){
        this.transito = transito;
    }

    public int getTransito(){
        return this.transito;
    }
    
}
