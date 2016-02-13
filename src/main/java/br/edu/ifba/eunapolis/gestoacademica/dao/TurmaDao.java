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
 */
public class TurmaDao {

    private EntityManager manager = JpaUtil.getEntityManager();
    private EntityTransaction trx = manager.getTransaction();

    public List<Turma> listar() {

        TypedQuery<Turma> query = manager.createQuery("from Turma", Turma.class);
        List<Turma> turmas = query.getResultList();
        return turmas;
    }

    public Turma consultar(String nome) {
        Turma turma = null;
        try{
            trx.begin();
            turma = manager.find(Turma.class, nome);
            trx.commit();
        } catch (Exception ex) {
            ex.printStackTrace();
            trx.rollback();
        }
        return turma;
    }

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
