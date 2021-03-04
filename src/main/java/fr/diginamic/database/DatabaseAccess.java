package fr.diginamic.database;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class DatabaseAccess {

	private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("Projet-JPA-voiture");

	private static EntityManager em;

	private DatabaseAccess() {

	}

	public static EntityManager getEntityManager() {
		if (em == null) {
			em = emf.createEntityManager();
		}
		return em;
	}

	public static void releaseEntityManager() {
		em.close();
		em = null;
	}
}
