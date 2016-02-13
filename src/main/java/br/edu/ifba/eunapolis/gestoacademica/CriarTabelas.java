package br.edu.ifba.eunapolis.gestoacademica;

import javax.persistence.Persistence;

/**
 * Classe que cria as tabelas no banco de dados
 *
 * @author Leonardo
 * @version 1.0
 */
public class CriarTabelas {

    public static void main(String[] args) {

        Persistence.createEntityManagerFactory("br.edu.ifba.eunapolis_SADE_war_0.0.1-SNAPSHOTPU");

    }

}
