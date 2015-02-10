package com.konak.dao;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import com.konak.bean.KonakLoginCredentialsTb;

public class LoginDAO {
	private static final String PERSISTENCE_UNIT_NAME = "konak";
	private static EntityManagerFactory factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
	public List<KonakLoginCredentialsTb> load() {
		EntityManager em = factory.createEntityManager();
		em.getTransaction().begin();
		List<KonakLoginCredentialsTb> login = (List<KonakLoginCredentialsTb>)em.createNamedQuery("KonakLoginCredentialsTb.findAll", KonakLoginCredentialsTb.class).getResultList();
		em.getTransaction().commit();
		em.close();
		return login;
	}
	public boolean validateCredential(KonakLoginCredentialsTb lbean) {
		boolean set = false;
		List<KonakLoginCredentialsTb> login = load();
		for (KonakLoginCredentialsTb log : login)
			if ((log.getUser().equals(lbean.getUser())) && (log.getPassword().equals(lbean.getPassword()))
					&&(log.getUsertype().equals(lbean.getUsertype()))){
				set = true;
			break;
			}
		return set;
	}
}



