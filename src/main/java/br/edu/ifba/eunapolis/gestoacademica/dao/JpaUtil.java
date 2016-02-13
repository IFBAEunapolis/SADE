package br.edu.ifba.eunapolis.gestoacademica.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * Classe responsavel pela criar e gerir as conexoes com o banco de dados
 * 
 * @author Leonardo 
 * @version 1.0
 */
public class JpaUtil {

    private static EntityManagerFactory factory;

    static {
        factory = Persistence.createEntityManagerFactory("br.edu.ifba.eunapolis_SADE_war_0.0.1-SNAPSHOTPU");

    }

    /**
     * Retorna uma entidade de persistencia
     *
     * @return
     */
    public static EntityManager getEntityManager() {
        return factory.createEntityManager();
    }

}
