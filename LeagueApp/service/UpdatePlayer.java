

package LeagueApp.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import LeagueApp.Player;
import LeagueApp.Name;

public class UpdatePlayer {

	public void updatePlayer(Player player, Player oldPlayer) {
		EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("Eclipselink_JPA");

		EntityManager entitymanager = emfactory.createEntityManager();

		Query query = entitymanager
				.createQuery("select p from Person as p WHERE Type(p) = Player And p.name.firstname = :name");
		query.setParameter("name", oldPlayer.getName().getFirstname());
		List<Player> teamList = query.getResultList();

		long playerId = teamList.get(0).getId();

		Name newName = new Name(player.getName().getFirstname(), player.getName().getMiddlename(),
				player.getName().getLastname());
		entitymanager.getTransaction().begin();
		Player playerUpdate = entitymanager.find(Player.class, playerId);

		playerUpdate.setName(newName);
		playerUpdate.setEmail(player.getEmail());
		playerUpdate.setPhone(player.getPhone());
		playerUpdate.setGoalie(player.getGoalie());
		playerUpdate.setGoals(player.getGoals());
		entitymanager.getTransaction().commit();
		entitymanager.close();
	}
}
