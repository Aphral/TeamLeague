package LeagueApp;

import static org.junit.Assert.*;

import org.junit.Test;

public class PlayerTest {
	
	
	@Test
	public void testPlayer() {
		Player player = new Player();
		
		Name newName = new Name("John", "M", "Smith");
		String phone = "08713621";
		String email = "thisemail@gmail";
		int goals = 2;
		Boolean goalie = true;
		
		player.setName(newName);
		player.setPhone(phone);
		player.setEmail(email);
		player.setGoals(goals);
		player.setGoalie(goalie);
		
		assertEquals(newName, player.getName());
		assertEquals(phone, player.getPhone());
		assertEquals(email, player.getEmail());
		assertEquals(goals, player.getGoals());
		assertEquals(goalie, player.getGoalie());
	}

}
