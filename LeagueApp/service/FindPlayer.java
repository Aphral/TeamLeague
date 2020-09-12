

package LeagueApp.service;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import LeagueApp.Player;
import LeagueApp.Name;
import LeagueApp.Team;

public class FindPlayer {

	public List<Player> findAllPlayers() {

		EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("Eclipselink_JPA");

		EntityManager entitymanager = emfactory.createEntityManager();

		// Get All Players From Person Table
		Query query = entitymanager.createQuery("select p from Person as p Where Type(p) = Player", Player.class);
		List<Player> list = query.getResultList();

		entitymanager.close();

		// Return List of All players
		return list;
	}

	public String findPlayerByName(String name) {
		// Create Empty String
		String playerDetails = "";

		EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("Eclipselink_JPA");

		EntityManager entitymanager = emfactory.createEntityManager();

		// Select All Teams From Team Lsit
		Query query = entitymanager.createQuery("select t from Team as t ");

		List<Team> teamList = query.getResultList();

		// Loop Through Teams Looking For Player That Matches In Team List
		for (int i = 0; i < teamList.size(); i++) {
			System.out.println(teamList.get(i).getPlayers().size());

			List<Player> playerList = teamList.get(i).getPlayers();
			for (int j = 0; j < playerList.size(); j++) {

				// Compare Name to List Of Names In TEam
				int dif = playerList.get(j).getName().getFirstname().compareTo(name);
				if (dif == 0) {
					// IF no difference in names Add Player Details To String And Manager NAme

					playerDetails += "Name: " + playerList.get(j).getName().getFirstname() + "    \tGoals: "
							+ playerList.get(j).getGoals() + "\t    Manager: "
							+ teamList.get(i).getManager().getName().getFirstname();
				}

			}
		}

		entitymanager.close();
		return playerDetails;
	}
	
	public List<Player> findPlayersNotOnTeam(){
		
		List<Player> notOnTeam = new ArrayList<Player>();
		
		List<Player> allPlayers = findAllPlayers();
		
		FindTeam find = new FindTeam();
		
		List<Player> playerOnTeam = find.findAllPlayersOnATeam();
		
		for(int i = 0; i < allPlayers.size(); i++) {
			int exists = 0;
			for(int j = 0; j < playerOnTeam.size(); j++) {
				if(allPlayers.get(i).getId() == playerOnTeam.get(j).getId()) {
					exists = 1;
					
				}
			}
			if(exists == 0) {
				notOnTeam.add(allPlayers.get(i));
			}
			
			
		}
		
		return notOnTeam;
		
	}
}









