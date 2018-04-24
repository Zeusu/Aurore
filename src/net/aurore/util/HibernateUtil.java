package net.aurore.util;


import java.util.Set;

import javax.persistence.Entity;

import org.hibernate.MappingException;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.reflections.Reflections;

/*
import net.aurore.entities.AuroreMatch;
import net.aurore.entities.AuroreMatchEvent;
import net.aurore.entities.AuroreMatchFrame;
import net.aurore.entities.AuroreMatchParticipantFrame;
import net.aurore.entities.AuroreMatchSummary;
import net.aurore.entities.AuroreParticipantSummary;
import net.aurore.entities.AuroreTeamSummary;
import net.aurore.entities.MatchListItem;
import net.aurore.lolservice.entities.Rank;
import net.aurore.lolservice.entities.Summoner;*/

public class HibernateUtil {

	private static final SessionFactory sessionFactory = buildSessionFactory();


	private static SessionFactory buildSessionFactory() {
		
		Reflections reflect = new Reflections();
		Set<Class<?>> annotated = reflect.getTypesAnnotatedWith(Entity.class);
		try {
			// Create the SessionFactory from hibernate.cfg.xml
			AnnotationConfiguration configuration = new AnnotationConfiguration();
			try{					
			    configuration.configure();
			    /*	.addAnnotatedClass(Summoner.class)
			    	.addAnnotatedClass(Rank.class)
			    	.addAnnotatedClass(AuroreMatch.class)
			    	.addAnnotatedClass(AuroreMatchFrame.class)
			    	.addAnnotatedClass(AuroreMatchParticipantFrame.class)
			    	.addAnnotatedClass(AuroreMatchEvent.class)
			    	.addAnnotatedClass(AuroreMatchSummary.class)
			    	.addAnnotatedClass(AuroreParticipantSummary.class)
			    	.addAnnotatedClass(AuroreTeamSummary.class)
			    	.addAnnotatedClass(MatchListItem.class);*/
			    for(Class<?> c : annotated){
			    	configuration.addAnnotatedClass(c);
			    }
			}catch(MappingException e){
				e.printStackTrace();
			}
		    System.out.println("[Aurore] Hibernate Annotation Configuration loaded");
		             
		    /*ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
		      .applySettings(configuration.getProperties()).build();
		    System.out.println("Hibernate Annotation serviceRegistry created");*/
		             
		    SessionFactory sessionFactory = configuration.buildSessionFactory();
		    
		    return sessionFactory;
		    
		} catch (Throwable ex) {
			// Make sure you log the exception, as it might be swallowed
			System.err.println("Initial SessionFactory creation failed." + ex);
			throw new ExceptionInInitializerError(ex);
		}
	}

	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public static void shutdown() {
		// Close caches and connection pools
		getSessionFactory().close();
	}

}