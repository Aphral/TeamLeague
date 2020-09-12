

package LeagueApp.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import LeagueApp.Manager;
import LeagueApp.Player;
import LeagueApp.Team;

public class UpdateTeam {

	public List<Player> addPlayerToTeam(Player player, String colour) {
		EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("Eclipselink_JPA");

		EntityManager entitymanager = emfactory.createEntityManager();
		entitymanager.getTransaction().begin();
		Team team = entitymanager.find(Team.class, colour);

		List<Player> playerList = team.getPlayers();

		playerList.add(player);

		team.setPlayers(playerList);
		entitymanager.getTransaction().commit();
		entitymanager.close();
		emfactory.close();

		return null;
	}

	public void addManagerToTeam(Manager manager, String colour) {
		EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("Eclipselink_JPA");

		EntityManager entitymanager = emfactory.createEntityManager();
		entitymanager.getTransaction().begin();
		Team team = entitymanager.find(Team.class, colour);

		team.setManager(manager);

		entitymanager.getTransaction().commit();
		entitymanager.close();
		emfactory.close();

	}

	public void removePlayerFromTeam(Player player, String colour) {

		String removeName = player.getName().getFirstname();

		EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("Eclipselink_JPA");
		EntityManager entitymanager = emfactory.createEntityManager();
		entitymanager.getTransaction().begin();
		Team team = entitymanager.find(Team.class, colour);

		List<Player> playerList = team.getPlayers();

		System.out.println(playerList.size());

		for (int j = 0; j < playerList.size(); j++) {

			System.out.println("Printing Palyer");
			System.out.println(playerList.get(j).getName().getFirstname());

			int dif = playerList.get(j).getName().getFirstname().compareTo(removeName);
			if (dif == 0) {
				playerList.remove(j);
			}
		}

		team.setPlayers(playerList);
		entitymanager.getTransaction().commit();

	}

	public void removeManagerFromTeam(String colour) {
		EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("Eclipselink_JPA");

		EntityManager entitymanager = emfactory.createEntityManager();
		entitymanager.getTransaction().begin();
		Team team = entitymanager.find(Team.class, colour);

		team.setManager(null);

		entitymanager.getTransaction().commit();
		entitymanager.close();
		emfactory.close();

	}
}
