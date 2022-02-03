package modelo;

public class VotosComunidades {

	public String comunidad;
	public int votosPP;
	public int votosPSOE;
	public int votosVOX;
	public int votosCIUDADANOS;

	public VotosComunidades(String comunidad, int votosPP, int votosPSOE, int votosVOX, int votosCIUDADANOS) {
		super();
		this.comunidad = comunidad;
		this.votosPP = votosPP;
		this.votosPSOE = votosPSOE;
		this.votosVOX = votosVOX;
		this.votosCIUDADANOS = votosCIUDADANOS;
	}

	public String getComunidad() {
		return comunidad;
	}

	public void setComunidad(String comunidad) {
		this.comunidad = comunidad;
	}

	public int getVotosPP() {
		return votosPP;
	}

	public void setVotosPP(int votosPP) {
		this.votosPP = votosPP;
	}

	public int getVotosPSOE() {
		return votosPSOE;
	}

	public void setVotosPSOE(int votosPSOE) {
		this.votosPSOE = votosPSOE;
	}

	public int getVotosVOX() {
		return votosVOX;
	}

	public void setVotosVOX(int votosVOX) {
		this.votosVOX = votosVOX;
	}

	public int getVotosCIUDADANOS() {
		return votosCIUDADANOS;
	}

	public void setVotosCIUDADANOS(int votosCIUDADANOS) {
		this.votosCIUDADANOS = votosCIUDADANOS;
	}

	@Override
	public String toString() {
		return "Comunidad: " + comunidad + " --> [PP: " + votosPP + " | PSOE: " + votosPSOE
				+ " | VOX: " + votosVOX + " | CIUDADANOS: " + votosCIUDADANOS + "]";
	}
	
	

}
