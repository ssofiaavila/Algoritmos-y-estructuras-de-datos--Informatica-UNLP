package ayed.parcialesGrafos.parcial7Grafos;

public class Persona {

    private String tipo;
	private String nombre;
	
    public Persona(String nombre, String tipo){
        this.nombre = nombre;
        this.tipo = tipo;
    }
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	

}
