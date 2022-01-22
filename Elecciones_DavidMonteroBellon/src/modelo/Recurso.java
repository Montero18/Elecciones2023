package modelo;

public class Recurso {

	private static Recurso instancia;
	
	private boolean partido = false;
	private Object object = new Object();
	
	public Recurso() {
		
	}
	
	public synchronized static void createInstance() {
		if(instancia == null) {
			instancia = new Recurso();
		}
	}
	
	public static Recurso getInstancia() {
		if(instancia == null) {
			createInstance();
		}
		return instancia;
	}
	
	public Boolean calcularVoto (int voto, int edadCiudadano) {
		synchronized (object) {
			if(edadCiudadano >= 18 && edadCiudadano <= 25) {
				if(voto >= 0 && voto <= 30) {
					partido = true;
				}
				if(voto >= 31 && voto <= 50) {
					partido = true;
				}
				if(voto >= 51 && voto <= 70) {
					partido = true;
				}
				if(voto >= 71 && voto <= 100) {
					partido = true;
				}
			}
			
			if(edadCiudadano >= 26 && edadCiudadano <= 40) {
				if(voto >= 0 && voto <= 20) {
					partido = true;
				}
				if(voto >= 21 && voto <= 55) {
					partido = true;
				}
				if(voto >= 56 && voto <= 85) {
					partido = true;
				}
				if(voto >= 86 && voto <= 100) {
					partido = true;
				}
			}
			if(edadCiudadano >= 41 && edadCiudadano <= 65) {
				if(voto >= 0 && voto <= 10) {
					partido = true;
				}
				if(voto >= 11 && voto <= 55) {
					partido = true;
				}
				if(voto >= 56 && voto <= 90) {
					partido = true;
				}
				if(voto >= 91 && voto <= 100) {
					partido = true;
				}
			}
			if(edadCiudadano >= 66 && edadCiudadano <= 100) {
				if(voto >= 0 && voto <= 25) {
					partido = true;
				}
				if(voto >= 26 && voto <= 60) {
					partido = true;
				}
				if(voto >= 61 && voto <= 95) {
					partido = true;
				}
					partido = true;
				}
			}
			
		return partido;
	}

	public boolean votacion() {
		return partido;
	}
}
