package com.konak.dao;
import java.util.List;

import com.konak.bean.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class HotelDAO {
	private static final String PERSISTENCE_UNIT_NAME = "konak";
	private static EntityManagerFactory factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);

	public int save(KonakHotelDetailsTb hotel) {
		EntityManager em = factory.createEntityManager();
		em.getTransaction().begin();
		em.persist(hotel);
		System.out.println(hotel);
		em.getTransaction().commit();
		em.close();
		return hotel.getHotelid();
	}

	public static KonakHotelDetailsTb load(int id) {
		EntityManager em = factory.createEntityManager();
		em.getTransaction().begin();
		KonakHotelDetailsTb hotel = em.find(KonakHotelDetailsTb.class, id);
		em.getTransaction().commit();
		em.close();
		return hotel;
	}

	public static List<KonakHotelDetailsTb> load() {
		EntityManager em = factory.createEntityManager();
		em.getTransaction().begin();
		List<KonakHotelDetailsTb> hotel = (List<KonakHotelDetailsTb>)em.createNamedQuery("KonakHotelDetailsTb.findAll", KonakHotelDetailsTb.class).getResultList();
		em.getTransaction().commit();
		em.close();
		return hotel;
	}
	public static List<KonakHotelDetailsTb> getHotelByCriteria(String location, String checkin, String checkout, String rating) {
		EntityManager em = factory.createEntityManager();
		String query = "Select h from KonakHotelDetailsTb h where h.location = :location and h.checkin = :checkin and h.checkout = :checkout and h.rating= :rating";
		Query q = em.createQuery(query);
		q.setParameter("location", location);
		q.setParameter("checkin", checkin);
		q.setParameter("checkout", checkout);
		q.setParameter("rating", rating);
		List<KonakHotelDetailsTb> h = q.getResultList();
		return h;
	}
	public static boolean remove(int id) {
		boolean set = false;
		EntityManager em = factory.createEntityManager();
		em.getTransaction().begin();
		try{
			em.remove(em.getReference(KonakHotelDetailsTb.class, id));
			em.getTransaction().commit();
			set = true;
			System.out.println("true");
		}catch(Exception e){
			set = false;
			System.out.println("false");
		}
		em.close();
		return set;
	}

	public static boolean update(KonakHotelDetailsTb updatehotel) {
		boolean set = false;
		EntityManager em = factory.createEntityManager();
		em.getTransaction().begin();
		try{
			em.merge(updatehotel);
			em.getTransaction().commit();
			set = true;
		}catch(Exception e)
		{
			set = false;
		}
		em.close();
		return set ;
	}

	public static void main(String[] args) {
		KonakHotelDetailsTb application = new KonakHotelDetailsTb();
		HotelDAO dao = new HotelDAO();
		int app = dao.save(application);
	
		//System.out.println(dao.remove(151));
		/*System.out.println(application);

		List<KonakHotelDetailsTb> vertices = dao.load();
		for(KonakHotelDetailsTb v:vertices)
			System.out.println(v);*/

		/*KonakHotelDetailsTb v5 = dao.load(5);
		System.out.println(v5);*/
	}
}


