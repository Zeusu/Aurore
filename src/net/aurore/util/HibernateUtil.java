package net.aurore.util;


import java.util.Set;

import javax.persistence.Entity;

import org.hibernate.MappingException;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.reflections.Reflections;


public class HibernateUtil {

	private static final SessionFactory sessionFactory = buildSessionFactory();


	private static SessionFactory buildSessionFactory() {
		
		Reflections reflect = new Reflections();
		Set<Class<?>> annotated = reflect.getTypesAnnotatedWith(Entity.class);
		try {
			AnnotationConfiguration configuration = new AnnotationConfiguration();
			try{					
			    configuration.configure();

			    for(Class<?> c : annotated){
			    	configuration.addAnnotatedClass(c);
			    }
			}catch(MappingException e){
				e.printStackTrace();
			}
		    System.out.println("[Aurore] Hibernate Annotation Configuration loaded");

		    SessionFactory sessionFactory = configuration.buildSessionFactory();
		    
		    return sessionFactory;
		    
		} catch (Throwable ex) {
			System.err.println("Initial SessionFactory creation failed." + ex);
			throw new ExceptionInInitializerError(ex);
		}
	}

	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public static void shutdown() {
		getSessionFactory().close();
	}

	public static void test(){
	}
}