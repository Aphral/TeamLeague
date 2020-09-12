
package LeagueApp;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 * Player 
 * Extends Person
 * @author aphralgriffin
 */


@Entity
@DiscriminatorValue("P")
public class Player extends Person{
	private int goals;
	private Boolean goalie;
	
	public Player(Name name, String phone, String email, int goals, Boolean goalie) {
		super(name, phone, email);
		this.goals = goals;
		this.goalie = goalie;
	}

	public Player() {
		
	}

	public int getGoals() {
		return goals;
	}

	public void setGoals(int goals) {
		this.goals = goals;
	}

	public Boolean getGoalie() {
		return goalie;
	}

	public void setGoalie(Boolean goalie) {
		this.goalie = goalie;
	}
	
	

	public String toString() {
		return String.format("%-10s %-10s %-10s %-10s %-20s %-5d %-10s", this.getName().getFirstname(),this.getName().getMiddlename(),  this.getName().getLastname(),this.getPhone(), this.getEmail(), goals, goalie );
	}
	
}
