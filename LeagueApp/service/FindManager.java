

package LeagueApp.service;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import LeagueApp.Manager;
import LeagueApp.Player;

public class FindManager {

	public List<Manager> findAllManagers() {

		EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("Eclipselink_JPA");

		EntityManager entitymanager = emfactory.createEntityManager();

		Query query = entitymanager.createQuery("select m from Person as m Where Type(m) = Manager", Manager.class);
		List<Manager> list = query.getResultList();

		System.out.println("Managers" );
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i).getTeam());

		}
		entitymanager.close();
		return list;
	}
	
	public List<Manager> findNullManagers() {
		List<Manager> nullManagers = new ArrayList<Manager>();
		
		
		EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("Eclipselink_JPA");

		EntityManager entitymanager = emfactory.createEntityManager();

		Query query = entitymanager.createQuery("select m from Person as m Where Type(m) = Manager", Manager.class);
		List<Manager> list = query.getResultList();

		System.out.println("Managers" );
		for (int i = 0; i < list.size(); i++) {
			if(list.get(i).getTeam() == null) {
				nullManagers.add(list.get(i));
			}

		}
		entitymanager.close();
		return nullManagers;
	}
}
