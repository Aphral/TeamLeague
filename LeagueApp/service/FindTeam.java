

package LeagueApp.service;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import LeagueApp.Player;
import LeagueApp.Team;

public class FindTeam {

	public List<Team> findTeamByColour(String colour) {
		EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("Eclipselink_JPA");

		EntityManager entitymanager = emfactory.createEntityManager();

		Query query = entitymanager.createQuery("select t from Team as t WHERE t.jersey = ?1");
		query.setParameter(1, colour);
		List<Team> list = query.getResultList();

		entitymanager.close();
		return list;
	}

	public List<Team> findAllTeams() {
		EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("Eclipselink_JPA");

		EntityManager entitymanager = emfactory.createEntityManager();

		Query query = entitymanager.createQuery("select t from Team as t");
		List<Team> list = query.getResultList();

		entitymanager.close();
		return list;
	}

	public List<Player> findAllPlayersInTeam(String colour) {

		EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("Eclipselink_JPA");

		EntityManager entitymanager = emfactory.createEntityManager();

		entitymanager.getTransaction().begin();
		Team team = entitymanager.find(Team.class, colour);

		List<Player> playerList = team.getPlayers();

		entitymanager.close();

		return playerList;
	}
	
	public List<Player> findAllPlayersOnATeam() {

		List<Player> allPlayers = new ArrayList<Player>();
		
		EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("Eclipselink_JPA");

		EntityManager entitymanager = emfactory.createEntityManager();

		Query query = entitymanager.createQuery("select t from Team as t");
		List<Team> list = query.getResultList();
		
		
		for(int i = 0; i < list.size(); i++) {
			List<Player> teamsPlayers = list.get(i).getPlayers();
			if(teamsPlayers.size() > 0) {
				for(int j = 0; j < teamsPlayers.size(); j++) {
					allPlayers.add(teamsPlayers.get(j));
				}
			}
			
		}
		
		entitymanager.close();
		
		
		return allPlayers;
	}
}
