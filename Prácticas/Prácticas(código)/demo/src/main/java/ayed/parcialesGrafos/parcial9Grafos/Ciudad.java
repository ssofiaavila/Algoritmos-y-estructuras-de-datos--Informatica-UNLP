package ayed.parcialesGrafos.parcial9Grafos;

public class Ciudad {
    private String nombre;
    private int maxTransito;

    public Ciudad (String nombre, int maxTransito){
        this.nombre = nombre;
        this.maxTransito = maxTransito;
    }

    


    /**
     * @return String return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return int return the maxTransito
     */
    public int getMaxTransito() {
        return maxTransito;
    }

    /**
     * @param maxTransito the maxTransito to set
     */
    public void setMaxTransito(int maxTransito) {
        this.maxTransito = maxTransito;
    }

}
