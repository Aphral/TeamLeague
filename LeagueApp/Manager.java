

package LeagueApp;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToOne;


/**
 * Manager 
 * Extends Person
 * @author aphralgriffin
 */

@Entity
@DiscriminatorValue("M")
public class Manager extends Person {

	private String dob;
	private int starRate; 
	
	
	@OneToOne(mappedBy = "manager")
	private Team team; 
	
	public Manager(Name name, String phone, String email, String dob, int starRate, Team team) {
		super(name, phone, email);
		this.dob = dob;
		this.starRate = starRate;
		this.team = team;
		
		
	}
	
	public Manager() {
		
	}
	
	public String getManagerFirstName() {
		return this.getName().getFirstname();
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public int getStarRate() {
		return starRate;
	}

	public void setStarRate(int starRate) {
		this.starRate = starRate;
	}

	public Team getTeam() {
		return team;
	}

	public void setTeam(Team team) {
		this.team = team;
	}

	public String toString() {
		return String.format("%-10s %-10s %-10s %-10s %-20s %-5d %-10s %-10s", this.getName().getFirstname(),this.getName().getMiddlename(),  this.getName().getLastname(),this.getPhone(), this.getEmail(), starRate, dob, team);
	}
}
