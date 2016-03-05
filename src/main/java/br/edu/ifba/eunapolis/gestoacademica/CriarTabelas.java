package br.edu.ifba.eunapolis.gestoacademica;

import javax.persistence.Persistence;

/**
 * Classe que cria as tabelas no banco de dados
 *
 * @author Luana Almeida
 * @version 1.0
 */
public class CriarTabelas {

    public static void main(String[] args) {
        
        Persistence.createEntityManagerFactory("SADE_PU");

    }

}
