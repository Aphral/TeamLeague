

package LeagueApp;

import java.util.ArrayList;
import java.util.List;


import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Team
 * @author aphralgriffin
 */


@Entity
public class Team {
	
	@Id
	private String jersey; 
	
	 @OneToOne
	private Manager manager; 
	
	  @OneToMany
	  @JoinTable(name = "TEAM_PLAYERS",
	          joinColumns = {@JoinColumn(name = "TEAM_COLOUR")},
	          inverseJoinColumns = {@JoinColumn(name = "PLAYER_NUMBER")}
	  )
	private List<Player> players = new ArrayList<Player>();
	
	public Team(String jersey, Manager manager, ArrayList<Player> players) {
		this.jersey = jersey;
		this.manager = manager;
		this.players = players;
	}
	
	public Team() {
		
	}


	public String getJersey() {
		return jersey;
	}

	public void setJersey(String jersey) {
		this.jersey = jersey;
	}
	public Manager getManager() {
		return manager;
	}

	public void setManager(Manager manager) {
		this.manager = manager;
	}

	public void setPlayers(List<Player> players) {
		this.players = players;
	}

	public List<Player> getPlayers() {
		return (List<Player>) players;
	}
	
	@Override
	public String toString() {
		return  jersey +"";
	}
}
