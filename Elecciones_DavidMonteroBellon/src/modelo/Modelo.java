package modelo;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;


public class Modelo {
	
    public void listarDatos (int numeroVotos) throws Exception {
    	SessionFactory sessionFactory = null;

        try {
            Configuration configuration = new Configuration();
            configuration.configure("hibernate.cfg.xml");
            sessionFactory = configuration.buildSessionFactory();
            
            sessionFactory.getCurrentSession().beginTransaction();
            
            listar("Andalucia", sessionFactory, numeroVotos);
            listar("Aragon", sessionFactory, numeroVotos);
            listar("Asturias", sessionFactory, numeroVotos);
            listar("Baleares", sessionFactory, numeroVotos);
            listar("Canarias", sessionFactory, numeroVotos);
            listar("Cantabria", sessionFactory, numeroVotos);
            
            listar("Castilla La Mancha", sessionFactory, numeroVotos);
            listar("Castilla y Leon", sessionFactory, numeroVotos);
            listar("Catalunia", sessionFactory, numeroVotos);
            listar("Comunidad Valenciana", sessionFactory, numeroVotos);
            listar("Extremadura", sessionFactory, numeroVotos);
            listar("Galicia", sessionFactory, numeroVotos);
            listar("Madrid", sessionFactory, numeroVotos);
            listar("Murcia", sessionFactory, numeroVotos);
            listar("Navarra", sessionFactory, numeroVotos);
            listar("Pais Vasco", sessionFactory, numeroVotos);
            listar("La Rioja", sessionFactory, numeroVotos);
            listar("Ceuta", sessionFactory, numeroVotos);
            listar("Melilla", sessionFactory, numeroVotos);
           
                      
        } catch (Exception e) {
            e.printStackTrace();
            sessionFactory.getCurrentSession().getTransaction().rollback();
                        
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
    
    public static void listar(String ciudad, SessionFactory sessionFactory, int numeroVotos) throws InterruptedException {
        
    	
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
            
            int habitantes1825 = ((rango1825 * habitantesTotal)/100)/numeroVotos;
            int habitantes2640 = ((rango2640 * habitantesTotal)/100)/numeroVotos;
            int habitantes4165 = ((rango4165 * habitantesTotal)/100)/numeroVotos;
            int habitantes66 = ((rango66 * habitantesTotal)/100)/numeroVotos;
            
            if(habitantes1825 == 0) {habitantes1825 = 1;}
            if(habitantes2640 == 0) {habitantes2640 = 1;}
            if(habitantes4165 == 0) {habitantes4165 = 1;}
            if(habitantes66 == 0) {habitantes66 = 1;}
            
            
            
            
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
    }
    
    public static int datosGenerales (SessionFactory sessionFactory, String partido) {
    	BigInteger auxVotos = null;
    	Session session = null;
    	int votos = 0;
    	
    	try {
    		
    		session = sessionFactory.getCurrentSession();
    		session.beginTransaction();
    		
    		Query query = session.createSQLQuery("SELECT COUNT(*) AS VOTOS FROM DATOS_ELECTORALES WHERE VOTO_PARTIDO= :votoPartido");
			query.setParameter("votoPartido", partido);
			auxVotos = (BigInteger) query.getSingleResult();
			

			String votosAux = String.valueOf(auxVotos);
			votos = Integer.parseInt(votosAux);
			
			System.out.println(votos);
			
		}catch (HibernateException e) {
            e.printStackTrace();
            sessionFactory.getCurrentSession().getTransaction().rollback();
            throw e;
            
        }finally {
        	if (session != null) {
                session.close();
			}
        }
    	
    	
    	return votos;
    }
    
    public static int datosComunidad (SessionFactory sessionFactory, String comunidad, String votoPartido) {
    	BigInteger auxVotos;
    	Session session = null;
    	int votos = 0;
    	
    	try {
    		
    		session = sessionFactory.getCurrentSession();
    		session.beginTransaction();
    		
    		Query query = session.createSQLQuery("SELECT COUNT(*) AS VOTOS FROM DATOS_ELECTORALES WHERE COMUNIDAD= :nombreComunidad AND VOTO_PARTIDO= :votoPartido");
			query.setParameter("nombreComunidad", comunidad);
			query.setParameter("votoPartido", votoPartido);
			auxVotos = (BigInteger) query.getSingleResult();
			
			String votosAux = String.valueOf(auxVotos);
			votos = Integer.parseInt(votosAux);
						
		}catch (HibernateException e) {
            e.printStackTrace();
            sessionFactory.getCurrentSession().getTransaction().rollback();
            throw e;
            
        }finally {
        	if (session != null) {
        		session.close();
			}
        }
    	return votos;
    }
    
    public static int datosRango (SessionFactory sessionFactory, int edad1, int edad2, String votoPartido) {
    	BigInteger auxVotos;
    	Session session = null;
    	int votos = 0;
    	
    	try {
    		
    		session = sessionFactory.getCurrentSession();
    		session.beginTransaction();
    		
    		Query query = session.createSQLQuery("SELECT COUNT(*) AS VOTOS FROM DATOS_ELECTORALES WHERE EDAD>= :edad1 AND EDAD<= :edad2 AND VOTO_PARTIDO= :votoPartido");
			query.setParameter("edad1", edad1);
			query.setParameter("edad2", edad2);
			query.setParameter("votoPartido", votoPartido);
			auxVotos = (BigInteger) query.getSingleResult();
			
			String votosAux = String.valueOf(auxVotos);
			votos = Integer.parseInt(votosAux);
			
			System.out.println(votos);
			
		} catch (HibernateException e) {
            e.printStackTrace();
            sessionFactory.getCurrentSession().getTransaction().rollback();
            throw e;
            
        }finally {
        	if (session != null) {
        		session.close();
			}
        }
    	
    	return votos;
    }
    
}