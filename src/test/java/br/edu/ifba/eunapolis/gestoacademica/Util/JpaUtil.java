package br.edu.ifba.eunapolis.gestoacademica.Util;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JpaUtil {

	private static EntityManagerFactory factory;

	static {
		factory = Persistence.createEntityManagerFactory("SADE_PU2");
	}

	public static EntityManager getEntityManager() {
		return factory.createEntityManager();
	}

}