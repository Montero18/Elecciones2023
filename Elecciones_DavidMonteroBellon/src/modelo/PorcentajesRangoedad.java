package modelo;
// Generated 22 ene. 2022 20:08:16 by Hibernate Tools 5.4.32.Final

/**
 * PorcentajesRangoedad generated by hbm2java
 */
public class PorcentajesRangoedad implements java.io.Serializable {

	private String nombreComunidad;
	private int rango19;
	private int rango1017;
	private int rango1825;
	private int rango2640;
	private int rango4165;
	private int rangoMas66;
	private int totalHabitantes;

	public PorcentajesRangoedad() {
	}

	public PorcentajesRangoedad(String nombreComunidad, int rango19, int rango1017, int rango1825, int rango2640,
			int rango4165, int rangoMas66, int totalHabitantes) {
		this.nombreComunidad = nombreComunidad;
		this.rango19 = rango19;
		this.rango1017 = rango1017;
		this.rango1825 = rango1825;
		this.rango2640 = rango2640;
		this.rango4165 = rango4165;
		this.rangoMas66 = rangoMas66;
		this.totalHabitantes = totalHabitantes;
	}

	public String getNombreComunidad() {
		return this.nombreComunidad;
	}

	public void setNombreComunidad(String nombreComunidad) {
		this.nombreComunidad = nombreComunidad;
	}

	public int getRango19() {
		return this.rango19;
	}

	public void setRango19(int rango19) {
		this.rango19 = rango19;
	}

	public int getRango1017() {
		return this.rango1017;
	}

	public void setRango1017(int rango1017) {
		this.rango1017 = rango1017;
	}

	public int getRango1825() {
		return this.rango1825;
	}

	public void setRango1825(int rango1825) {
		this.rango1825 = rango1825;
	}

	public int getRango2640() {
		return this.rango2640;
	}

	public void setRango2640(int rango2640) {
		this.rango2640 = rango2640;
	}

	public int getRango4165() {
		return this.rango4165;
	}

	public void setRango4165(int rango4165) {
		this.rango4165 = rango4165;
	}

	public int getRangoMas66() {
		return this.rangoMas66;
	}

	public void setRangoMas66(int rangoMas66) {
		this.rangoMas66 = rangoMas66;
	}

	public int getTotalHabitantes() {
		return this.totalHabitantes;
	}

	public void setTotalHabitantes(int totalHabitantes) {
		this.totalHabitantes = totalHabitantes;
	}

}
