

package LeagueApp.service;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


import LeagueApp.Manager;

public class CreateManager {
	
	public CreateManager(Manager manager) {
			EntityManagerFactory emfactory = Persistence.createEntityManagerFactory( "Eclipselink_JPA" );
	      
	      EntityManager entitymanager = emfactory.createEntityManager( );
	     
	      entitymanager.getTransaction( ).begin( );
	      entitymanager.persist(manager);
	      entitymanager.getTransaction( ).commit( );

	      entitymanager.close( );
	      emfactory.close( );
		
	}
}
