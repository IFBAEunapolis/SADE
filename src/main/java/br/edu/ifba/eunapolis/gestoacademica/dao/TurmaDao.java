/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifba.eunapolis.gestoacademica.dao;

import br.edu.ifba.eunapolis.gestoacademica.model.Turma;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

/**
 *
 * @author Franciel
 * @version 1.0
 */
public class TurmaDao {

    private EntityManager manager = JpaUtil.getEntityManager();
    private EntityTransaction trx = manager.getTransaction();

    /**
     * Lista todos os objetos Turma armazenados no banco de dados
     *
     * @return
     */
    public List<Turma> listar() {

        TypedQuery<Turma> query = manager.createQuery("from Turma", Turma.class);
        List<Turma> turmas = query.getResultList();
        return turmas;
    }

    /**
     * Retorna o objetos Turma armazenados no banco de dados
     *
     * @param nome
     * @return
     */
    public Turma consultar(String nome) {
        Turma turma = null;
        try {
            trx.begin();
            turma = manager.find(Turma.class, nome);
            trx.commit();
        } catch (Exception ex) {
            ex.printStackTrace();
            trx.rollback();
        }
        return turma;
    }

    /**
     * Armazana no banco de dados o objeto recebido por parametro
     *
     * @param turma
     */
    public void inserir(Turma turma) {
        try {
            trx.begin();
            manager.persist(turma);
            trx.commit();
        } catch (Exception ex) {
            ex.printStackTrace();
            trx.rollback();
        }
    }

    /**
     * Atualiza no banco de dados o objeto recebido por parametro
     *
     * @param turma
     */
    public void Atualizar(Turma turma) {
        try {
            trx.begin();
            manager.merge(turma);
            trx.commit();
        } catch (Exception ex) {
            ex.printStackTrace();
            trx.rollback();
        }
    }

    /**
     * Apaga do banco de dados o objeto horarioAula recebido por parametro
     *
     * @param turma
     */
    public void Deletar(Turma turma) {
        try {
            trx.begin();
            turma = manager.find(Turma.class, turma.getId());
            manager.remove(turma);
            trx.commit();
        } catch (Exception ex) {
            ex.printStackTrace();
            trx.rollback();
        }
    }

}
