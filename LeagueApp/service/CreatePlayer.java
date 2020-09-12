
package LeagueApp.service;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


import LeagueApp.Player;

public class CreatePlayer {
	public CreatePlayer(Player player) {
		EntityManagerFactory emfactory = Persistence.createEntityManagerFactory( "Eclipselink_JPA" );
      
      EntityManager entitymanager = emfactory.createEntityManager( );
     
      entitymanager.getTransaction( ).begin( );
      entitymanager.persist(player);
      entitymanager.getTransaction( ).commit( );

      entitymanager.close( );
      emfactory.close( );
	
}
}
