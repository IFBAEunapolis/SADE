package br.edu.ifba.eunapolis.gestoacademica.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JpaUtil {

	private static EntityManagerFactory factory;

	static {
		factory = Persistence.createEntityManagerFactory("br.edu.ifba.eunapolis_SADE_war_0.0.1-SNAPSHOTPU");

	}

	public static EntityManager getEntityManager() {
		return factory.createEntityManager();
	}

}
