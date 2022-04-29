package practica2.ejercicio2;

public class Estudiante extends Persona{
	private String direccion;
	private int comision;
	
	public Estudiante(String nombre, String apellido, String email, String direccion, int comision) {
		super(nombre,apellido,email);
		this.setDireccion(direccion);
		this.setComision(comision);
		
	}
	

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public int getComision() {
		return comision;
	}

	public void setComision(int comision) {
		this.comision = comision;
	}

	@Override
	public String tusDatos() {
		String info= super.getInfo()+ " Direccion: "+ this.getDireccion()+ " Comision: " + this.getComision();
		return info;
	}
	
	
	
	
	
}
