package modelo;

import java.util.ArrayList;

import org.hibernate.SessionFactory;

public class Hilo extends Thread{

	private int edad;
	private int voto;
	private String comunidad;
	private String partidoVoto;
	private Recurso recurso = null;
	private SessionFactory sessionFactory;
	
	
	public Hilo(int edad, int voto, String comunidad, SessionFactory sessionFactory) {
		this.edad = edad;
		this.voto = voto;
		this.comunidad = comunidad;
		this.sessionFactory = sessionFactory;
	}



	@SuppressWarnings("static-access")
    @Override
    public void run() {
        try {
            recurso=recurso.getInstancia();
            boolean comprobar=recurso.calcularVoto(voto, edad);
            if(comprobar==true) {
                    if(edad>=18 && edad<=25) { 
                    	sessionFactory.getCurrentSession().beginTransaction();
                        if(voto>=0 && voto<=30) { System.out.println(comunidad+"("+edad+" Años)--"+voto+"---PP");
                        	DatosElectorales datosElectorales = new DatosElectorales();
                        	datosElectorales.setComunidad(comunidad);
                        	datosElectorales.setEdad(edad);
                        	datosElectorales.setVotoPartido("PP");
                        	
                        	sessionFactory.getCurrentSession().saveOrUpdate(datosElectorales);
                        	sessionFactory.getCurrentSession().getTransaction().commit();
                       
                        }
                        if(voto>=31 && voto<=50) { System.out.println(comunidad+"("+edad+" Años)--"+voto+"---PSOE");
	                        DatosElectorales datosElectorales = new DatosElectorales();
	                    	datosElectorales.setComunidad(comunidad);
	                    	datosElectorales.setEdad(edad);
	                    	datosElectorales.setVotoPartido("PSOE");
	                    	
	                    	sessionFactory.getCurrentSession().saveOrUpdate(datosElectorales);
	                    	sessionFactory.getCurrentSession().getTransaction().commit();
	                   
                        }
                        if(voto>=51 && voto<=70) { System.out.println(comunidad+"("+edad+" Años)--"+voto+"---VOX"); 
	                        DatosElectorales datosElectorales = new DatosElectorales();
	                    	datosElectorales.setComunidad(comunidad);
	                    	datosElectorales.setEdad(edad);
	                    	datosElectorales.setVotoPartido("VOX");
	                    	
	                    	sessionFactory.getCurrentSession().saveOrUpdate(datosElectorales);
	                    	sessionFactory.getCurrentSession().getTransaction().commit();
	                   
                        }
                        if(voto>=71 && voto<=100) { System.out.println(comunidad+"("+edad+" Años)--"+voto+"---CIUDADANOS");
	                        DatosElectorales datosElectorales = new DatosElectorales();
	                    	datosElectorales.setComunidad(comunidad);
	                    	datosElectorales.setEdad(edad);
	                    	datosElectorales.setVotoPartido("CIUDADANOS");
	                    	
	                    	sessionFactory.getCurrentSession().saveOrUpdate(datosElectorales);
	                    	sessionFactory.getCurrentSession().getTransaction().commit();
	                   
                        }
                    }
                    if(edad>=26 && edad<=40) { 
                        if(voto>=0 && voto<=20) { System.out.println(comunidad+"("+edad+" Años)--"+voto+"---PP");}
                        if(voto>=21 && voto<=55) { System.out.println(comunidad+"("+edad+" Años)--"+voto+"---PSOE");}
                        if(voto>=56 && voto<=85) { System.out.println(comunidad+"("+edad+" Años)--"+voto+"---VOX");}
                        if(voto>=86 && voto<=100) { System.out.println(comunidad+"("+edad+" Años)--"+voto+"---CIUDADANOS");}
                    }
                    if(edad>=41 && edad<=65) { 
                        if(voto>=0 && voto<=10) { System.out.println(comunidad+"("+edad+" Años)--"+voto+"---PP");}
                        if(voto>=11 && voto<=55) { System.out.println(comunidad+"("+edad+" Años)--"+voto+"---PSOE");}
                        if(voto>=56 && voto<=90) { System.out.println(comunidad+"("+edad+" Años)--"+voto+"---VOX");}
                        if(voto>=91 && voto<=100) {System.out.println(comunidad+"("+edad+" Años)--"+voto+"---CIUDADANOS");}
                    }
                    if(edad>=66 && edad<=110) { 
                        if(voto>=0 && voto<=25) { System.out.println(comunidad+"("+edad+" Años)--"+voto+"---PP");}
                        if(voto>=26 && voto<=60) { System.out.println(comunidad+"("+edad+" Años)--"+voto+"---PSOE");}
                        if(voto>=61 && voto<=95) { System.out.println(comunidad+"("+edad+" Años)--"+voto+"---VOX");}
                        if(voto>=96 && voto<=100) { System.out.println(comunidad+"("+edad+" Años)--"+voto+"---CIUDADANOS");}
                    }
                }            
        }catch(Exception e) { e.printStackTrace(); }
    }
}
