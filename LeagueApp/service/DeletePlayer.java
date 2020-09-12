package LeagueApp.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import LeagueApp.Player;

public class DeletePlayer {

	public void deletePlayer(Player player) {
		
		String removeName = player.getName().getFirstname();
		
		EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("Eclipselink_JPA");

		EntityManager entitymanager = emfactory.createEntityManager();

		Query query = entitymanager.createQuery("select p from Person as p Where Type(p) = Player", Player.class);
		List<Player> playerList = query.getResultList();

		for(int j = 0; j < playerList.size(); j++) {
			
			int dif = playerList.get(j).getName().getFirstname().compareTo(removeName);
			if(dif  == 0) {
				 entitymanager.getTransaction( ).begin( );
			      
			      Player playerDelete = entitymanager.find(Player.class, playerList.get(j).getId() );
			      entitymanager.remove( playerDelete );
			      entitymanager.getTransaction( ).commit( );
			}
		}
		
		entitymanager.close();
	}
}
