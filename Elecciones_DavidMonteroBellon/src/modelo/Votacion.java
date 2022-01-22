package modelo;

public class Votacion {

	private int edad;
	private String comunidad;
	private String partido;
	
	public Votacion(int edad, String comunidad, String partido) {
		super();
		this.edad = edad;
		this.comunidad = comunidad;
		this.partido = partido;
	}

	

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public String getComunidad() {
		return comunidad;
	}

	public void setComunidad(String comunidad) {
		this.comunidad = comunidad;
	}

	public String getPartido() {
		return partido;
	}

	public void setPartido(String partido) {
		this.partido = partido;
	}
	
	
	@Override
	public String toString() {
		return "Votacion [edad=" + edad + ", comunidad=" + comunidad + ", partido=" + partido + "]";
	}

	
	
	
}
