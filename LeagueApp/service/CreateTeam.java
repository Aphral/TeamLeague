

package LeagueApp.service;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import LeagueApp.Manager;
import LeagueApp.Team;

public class CreateTeam {

	public CreateTeam(Team team) {
		EntityManagerFactory emfactory = Persistence.createEntityManagerFactory( "Eclipselink_JPA" );
	      
	      EntityManager entitymanager = emfactory.createEntityManager( );
	     
	      entitymanager.getTransaction( ).begin( );
	      entitymanager.persist(team );
	      entitymanager.getTransaction( ).commit( );
	      

	      entitymanager.close();
	      emfactory.close( );
	}
}
