package modelo;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;


public class Modelo {

	public static void main (String [] args) {
		
		SessionFactory sessionFactory = null;
		
		try {
			//Solo se hace una vez, al iniciar la aplicaci�n
			Configuration configuration = new Configuration();
			configuration.configure("hibernate.cfg.xml");
			System.out.println("Paso 0 hecho");
			sessionFactory = configuration.buildSessionFactory();
			
			
			// Cualquier operacion debe hacerse dentro de una transaccion
			sessionFactory.getCurrentSession().beginTransaction();


			// leer todas las asignaturas
			Query query = sessionFactory.getCurrentSession().createQuery("FROM PorcentajesRangoedad");
			ArrayList<PorcentajesRangoedad> porcentajes = (ArrayList<PorcentajesRangoedad>) query.list();
				for(PorcentajesRangoedad lista: porcentajes) {
					System.out.println(lista);
				}
			
			sessionFactory.getCurrentSession().getTransaction().commit();
			System.out.println("hemos terminado");
		
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		
	}
	
}
