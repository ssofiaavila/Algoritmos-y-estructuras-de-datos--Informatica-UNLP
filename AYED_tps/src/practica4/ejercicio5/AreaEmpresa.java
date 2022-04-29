package practica4.ejercicio5;

public class AreaEmpresa {
	private String id;
	private int transmision;
	
	
	public AreaEmpresa(String id,int transmision) {
		this.id=id;
		this.transmision=transmision;
	}
	public String getId() {
		return this.id;
	}
	public int getTransmision() {
		return this.transmision;
	}
}
