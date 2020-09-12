

package LeagueApp;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.Embeddable;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

/**
 * Person
 * @author aphralgriffin
 */

@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@Entity
@DiscriminatorColumn(name = "PER_TYPE")
@Embeddable
public class Person {

	
	
	@Id 
	 @GeneratedValue
	private long id;
	private String phone;
	private String email;
	@Embedded
	private Name name;
	
	public Person(Name name, String phone, String email) {
		this.name = name;
		this.phone = phone;
		this.email = email;
	}
	
	public Person() {
		
	} 

	public Name getName() {
		return name;
	}

	public void setName(Name name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
	

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	public String toString() {
		return "Person [name=" + name +", phone=" 
	+ phone +  ", emial=" + email + "]";
	}
}
