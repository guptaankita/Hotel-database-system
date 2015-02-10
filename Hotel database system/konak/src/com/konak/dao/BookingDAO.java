package com.konak.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import com.konak.bean.*;


public class BookingDAO {
	private static final String PERSISTENCE_UNIT_NAME = "konak";
	private static EntityManagerFactory factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
	
	public static int save(KonakHotelBookingTb hotel) {
		EntityManager em = factory.createEntityManager();
		em.getTransaction().begin();
		em.persist(hotel);
		System.out.println(hotel);
		em.getTransaction().commit();
		em.close();
		return hotel.getBookingid();
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
	public static boolean remove(int id) {
		boolean set = false;
		EntityManager em = factory.createEntityManager();
		em.getTransaction().begin();
		try{
		em.remove(em.getReference(KonakHotelBookingTb.class, id));
		em.getTransaction().commit();
		set = true;
		}catch(Exception e){
		set = false;
		}
		em.close();
		return set;
	}
}
