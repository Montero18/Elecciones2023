package modelo;

public class DatosCiudad {

	private String nombre;
    private int rango1825, rango2640, rango4165, rango66;

    public DatosCiudad(String nombre, int rango1825, int rango2640, int rango4165, int rango66) {
        this.nombre = nombre;
        this.rango1825 = rango1825;
        this.rango2640 = rango2640;
        this.rango4165 = rango4165;
        this.rango66 = rango66;
    }

    public String getNombre() {
        return nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public int getRango1825() {
        return rango1825;
    }
    
    public void setRango1825(int rango1825) {
        this.rango1825 = rango1825;
    }
    
    public int getRango2640() {
        return rango2640;
    }
    
    public void setRango2640(int rango2640) {
        this.rango2640 = rango2640;
    }
    
    public int getRango4165() {
        return rango4165;
    }
    
    public void setRango4165(int rango4165) {
        this.rango4165 = rango4165;
    }
    
    public int getRango66() {
        return rango66;
    }
    
    public void setRango66(int rango66) {
        this.rango66 = rango66;
    }

    @Override
    public String toString() {
        return "Datos [Nombre = " + nombre + " --> rango1825=" + rango1825 + ", rango2640=" + rango2640 + ", rango4165="
                + rango4165 + ", rango66=" + rango66 + "]";
    }
	
}
