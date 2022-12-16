package ayed.parcialesGrafos.parcial1raFecha;

public class Estadio {
    private String estadio,ciudad;

    public Estadio(String estadio, String ciudad){
        this.estadio = estadio;
        this.ciudad = ciudad;
    }

    public String getEstadio(){
        return this.estadio;
    }

    public String getCiudad(){
        return this.ciudad;
    }

}
