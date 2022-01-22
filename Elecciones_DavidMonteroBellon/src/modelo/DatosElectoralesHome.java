package modelo;
// Generated 22 ene. 2022 20:08:17 by Hibernate Tools 5.4.32.Final

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.InitialContext;
import org.hibernate.LockMode;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Example;

/**
 * Home object for domain model class DatosElectorales.
 * @see modelo.DatosElectorales
 * @author Hibernate Tools
 */
public class DatosElectoralesHome {

	private static final Logger logger = Logger.getLogger(DatosElectoralesHome.class.getName());

	private final SessionFactory sessionFactory = getSessionFactory();

	protected SessionFactory getSessionFactory() {
		try {
			return (SessionFactory) new InitialContext().lookup("SessionFactory");
		} catch (Exception e) {
			logger.log(Level.SEVERE, "Could not locate SessionFactory in JNDI", e);
			throw new IllegalStateException("Could not locate SessionFactory in JNDI");
		}
	}

	public void persist(DatosElectorales transientInstance) {
		logger.log(Level.INFO, "persisting DatosElectorales instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			logger.log(Level.INFO, "persist successful");
		} catch (RuntimeException re) {
			logger.log(Level.SEVERE, "persist failed", re);
			throw re;
		}
	}

	public void attachDirty(DatosElectorales instance) {
		logger.log(Level.INFO, "attaching dirty DatosElectorales instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			logger.log(Level.INFO, "attach successful");
		} catch (RuntimeException re) {
			logger.log(Level.SEVERE, "attach failed", re);
			throw re;
		}
	}

	public void attachClean(DatosElectorales instance) {
		logger.log(Level.INFO, "attaching clean DatosElectorales instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			logger.log(Level.INFO, "attach successful");
		} catch (RuntimeException re) {
			logger.log(Level.SEVERE, "attach failed", re);
			throw re;
		}
	}

	public void delete(DatosElectorales persistentInstance) {
		logger.log(Level.INFO, "deleting DatosElectorales instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			logger.log(Level.INFO, "delete successful");
		} catch (RuntimeException re) {
			logger.log(Level.SEVERE, "delete failed", re);
			throw re;
		}
	}

	public DatosElectorales merge(DatosElectorales detachedInstance) {
		logger.log(Level.INFO, "merging DatosElectorales instance");
		try {
			DatosElectorales result = (DatosElectorales) sessionFactory.getCurrentSession().merge(detachedInstance);
			logger.log(Level.INFO, "merge successful");
			return result;
		} catch (RuntimeException re) {
			logger.log(Level.SEVERE, "merge failed", re);
			throw re;
		}
	}

	public DatosElectorales findById(int id) {
		logger.log(Level.INFO, "getting DatosElectorales instance with id: " + id);
		try {
			DatosElectorales instance = (DatosElectorales) sessionFactory.getCurrentSession()
					.get("modelo.DatosElectorales", id);
			if (instance == null) {
				logger.log(Level.INFO, "get successful, no instance found");
			} else {
				logger.log(Level.INFO, "get successful, instance found");
			}
			return instance;
		} catch (RuntimeException re) {
			logger.log(Level.SEVERE, "get failed", re);
			throw re;
		}
	}

	public List findByExample(DatosElectorales instance) {
		logger.log(Level.INFO, "finding DatosElectorales instance by example");
		try {
			List results = sessionFactory.getCurrentSession().createCriteria("modelo.DatosElectorales")
					.add(Example.create(instance)).list();
			logger.log(Level.INFO, "find by example successful, result size: " + results.size());
			return results;
		} catch (RuntimeException re) {
			logger.log(Level.SEVERE, "find by example failed", re);
			throw re;
		}
	}
}
