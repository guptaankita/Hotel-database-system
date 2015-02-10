package com.konak.dao;
import java.util.List;

import com.konak.bean.*;

//import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 * @author Khan
 *
 */
public class RegisterDAO {
	private static final String PERSISTENCE_UNIT_NAME = "konak";
	private static EntityManagerFactory factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
	public static String save(KonakUserDetailsTb user) {
		EntityManager em = factory.createEntityManager();
		em.getTransaction().begin();
		em.persist(user);
		KonakLoginCredentialsTb login = new KonakLoginCredentialsTb();
		login.setUser(user.getUsername());
		login.setPassword(user.getPassword());
		login.setUsertype("user");
		em.persist(login);
		em.getTransaction().commit();
		em.close();
		return user.getUsername();
	}
public static void main(String[] args) {
		KonakUserDetailsTb user = new KonakUserDetailsTb();
		RegisterDAO.save(user);
		}
public static List<KonakUserDetailsTb> load() {
	EntityManager em = factory.createEntityManager();
	em.getTransaction().begin();
	List<KonakUserDetailsTb> user = (List<KonakUserDetailsTb>)em.createNamedQuery("KonakUserDetailsTb.findAll", KonakUserDetailsTb.class).getResultList();
	em.getTransaction().commit();
	em.close();
	return user;
}
	}
