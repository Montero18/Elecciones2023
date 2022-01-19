package modelo;

import java.util.ArrayList;
import java.util.List;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;


public class Modelo {
    
    static ArrayList<DatosCiudad>listaDatos=new ArrayList<DatosCiudad>();
    
    public static void main (String [] args) {

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
            
            for (int i = 0; i < listaDatos.size(); i++) {
                System.out.println(listaDatos.get(i));
            }

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
    
    public static ArrayList<DatosCiudad> listar(String ciudad, SessionFactory sessionFactory) {
        
        Query query = sessionFactory.getCurrentSession().createSQLQuery("SELECT RANGO_18_25, RANGO_26_40, RANGO_41_65,RANGO_MAS_66, TOTAL_HABITANTES FROM PORCENTAJES_RANGOEDAD WHERE NOMBRE_COMUNIDAD=:nombre");        
        query.setParameter("nombre", ciudad);       
        List<Object[]> resultado = query.list();
        for (Object[] fila : resultado) {
            Integer rango1825 = (Integer) fila[0]; 
            Integer rango2640 = (Integer) fila[1]; 
            Integer rango4165 = (Integer) fila[2]; 
            Integer rango66 = (Integer) fila[3];
            Integer habitantes = (Integer) fila[4];
            
            int habitantes1825 = ((rango1825*habitantes)/100)/100000;
            int habitantes2640 = ((rango2640*habitantes)/100)/100000;
            int habitantes4165 = ((rango4165*habitantes)/100)/100000;
            int habitantes66 = ((rango66*habitantes)/100)/100000;
            
            if(habitantes1825 == 0) {habitantes1825=1;}
            if(habitantes2640 == 0) {habitantes2640=1;}
            if(habitantes4165 == 0) {habitantes4165=1;}
            if(habitantes66 == 0) {habitantes66=1;}
            
            listaDatos.add(new DatosCiudad(ciudad, habitantes1825,habitantes2640,habitantes4165,habitantes66));        
        }
        return listaDatos;
    }
}