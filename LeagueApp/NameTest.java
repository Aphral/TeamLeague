package LeagueApp;

import static org.junit.Assert.*;

import org.junit.Test;

public class NameTest {
	String fname = "Mary";
	String mname = "P";
	String lname = "Smith";
	
	
	
	@Test
	public void testName() {
		
		Name newName = new Name();
		newName.setFirstname(fname);
		newName.setMiddlename(mname);
		newName.setLastname(lname);
		
		assertEquals(fname, newName.getFirstname());
		assertEquals(mname, newName.getMiddlename());
		assertEquals(lname, newName.getLastname());
	
		
	}

}
