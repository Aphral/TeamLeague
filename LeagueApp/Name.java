
package LeagueApp;

import javax.persistence.Embeddable;

/**
 * Name
 * @author aphralgriffin
 */

@Embeddable
public class Name {

	private String firstname;
	private String middlename;
	private String lastname;
	
	
	public Name(String firstname, String middlename, String lastname) {
		this.firstname = firstname;
		this.middlename = middlename;
		this.lastname = lastname;
		
		
	}
	
	public Name() {
		
	}


	public String getFirstname() {
		return firstname;
	}


	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}


	public String getMiddlename() {
		return middlename;
	}


	public void setMiddlename(String middlename) {
		this.middlename = middlename;
	}


	public String getLastname() {
		return lastname;
	}


	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	
	public String toString() {
		return "Name [firstname=" + firstname +", middlename=" 
	+ middlename +  ", lastname=" + lastname + "]";
	}
	
	
}
