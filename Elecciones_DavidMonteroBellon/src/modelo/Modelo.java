package modelo;

import java.util.ArrayList;
import java.util.List;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;


public class Modelo {
    
    static ArrayList<DatosCiudad>listaDatos=new ArrayList<DatosCiudad>();
    
    public static void main (String [] args) throws Exception {

        SessionFactory sessionFactory = null;

        try {
            Configuration configuration = new Configuration();
            configuration.configure("hibernate.cfg.xml");
            sessionFactory = configuration.buildSessionFactory();

            sessionFactory.getCurrentSession().beginTransaction();
            
            listar("Andalucia", sessionFactory);
            listar("Aragon", sessionFactory);
            listar("Asturias", sessionFactory);
            listar("Baleares", sessionFactory);
            listar("Canarias", sessionFactory);
            listar("Cantabria", sessionFactory);
            listar("Castilla La Mancha", sessionFactory);
            listar("Castilla y Leon", sessionFactory);
            listar("Catalunia", sessionFactory);
            listar("Comunidad Valenciana", sessionFactory);
            listar("Extremadura", sessionFactory);
            listar("Galicia", sessionFactory);
            listar("Madrid", sessionFactory);
            listar("Murcia", sessionFactory);
            listar("Navarra", sessionFactory);
            listar("Pais Vasco", sessionFactory);
            listar("La Rioja", sessionFactory);
            listar("Ceuta", sessionFactory);
            listar("Melilla", sessionFactory);
            

            
            sessionFactory.getCurrentSession().getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            sessionFactory.getCurrentSession().getTransaction().rollback();
            throw e;
            
        }finally {
        	if (sessionFactory != null) {
                sessionFactory.close();
			}
        }
    }
    
    /**
     * Metodo que ejecuta la sentencia SQL, obtiene los datos de la tabla y hace la llamada a lo hilos
     * @param ciudad
     * @param sessionFactory
     * @return
     * @throws InterruptedException
     */
    
    public static ArrayList<DatosCiudad> listar(String ciudad, SessionFactory sessionFactory) throws InterruptedException {
        
    	//Consulta
        Query query = sessionFactory.getCurrentSession().createSQLQuery("SELECT RANGO_18_25, RANGO_26_40, RANGO_41_65,RANGO_MAS_66, TOTAL_HABITANTES FROM PORCENTAJES_RANGOEDAD WHERE NOMBRE_COMUNIDAD=:nombre");        
        query.setParameter("nombre", ciudad); 
        
        List<Object[]> resultado = query.list();
        
        for (Object[] array : resultado) {
            int rango1825 = (int) array [0]; 
            int rango2640 = (int) array [1]; 
            int rango4165 = (int) array [2]; 
            int rango66 = (int) array [3];
            int habitantesTotal = (int) array [4];
            
            int habitantes1825 = ((rango1825 * habitantesTotal)/100)/100000;
            int habitantes2640 = ((rango2640 * habitantesTotal)/100)/100000;
            int habitantes4165 = ((rango4165 * habitantesTotal)/100)/100000;
            int habitantes66 = ((rango66 * habitantesTotal)/100)/100000;
            
            if(habitantes1825 == 0) {habitantes1825 = 1;}
            if(habitantes2640 == 0) {habitantes2640 = 1;}
            if(habitantes4165 == 0) {habitantes4165 = 1;}
            if(habitantes66 == 0) {habitantes66 = 1;}
            
            listaDatos.add(new DatosCiudad(ciudad, habitantes1825, habitantes2640, habitantes4165, habitantes66));        
            
            
            
            for(int i=0; i<habitantes1825; i++) {
            	int aleatorio1825 =(int)(Math.random()*100);
            	int edad1825 = (int)(Math.random()*(25 - 18) + 18);
            	
            	Hilo hilo = new Hilo(edad1825, aleatorio1825, ciudad, sessionFactory);
            	hilo.start();
            	hilo.join();
            }
                      
            System.out.println("---------------------------------");
            for(int i=0; i<habitantes2640; i++) {
            	int aleatorio2640 =(int)(Math.random()*100);
            	int edad2640 = (int)(Math.random()*(40 - 26) + 26);
            	
            	Hilo hilo = new Hilo(edad2640, aleatorio2640, ciudad, sessionFactory);
            	hilo.start();
            	hilo.join();
            }
            	       	
            System.out.println("---------------------------------");
            for(int i=0; i<habitantes4165; i++) {         	
            	int aleatorio4165 =(int)(Math.random()*100);
            	int edad4165 = (int)(Math.random()*(65 - 41) + 41);
            	
            	Hilo hilo = new Hilo(edad4165, aleatorio4165, ciudad, sessionFactory);
            	hilo.start();
            	hilo.join();
            }
            	
            System.out.println("---------------------------------");
            for(int i=0; i<habitantes66; i++) {
            	int aleatorio66 =(int)(Math.random()*100);
            	int edad66 = (int)(Math.random()*(110 - 66) + 66);
            	
            	Hilo hilo = new Hilo(edad66, aleatorio66, ciudad, sessionFactory);
            	hilo.start();
            	hilo.join();
            }
            
        }
       
        
        return listaDatos;
    }
}