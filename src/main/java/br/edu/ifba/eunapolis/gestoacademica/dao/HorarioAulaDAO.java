package br.edu.ifba.eunapolis.gestoacademica.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import br.edu.ifba.eunapolis.gestoacademica.model.HorarioAula;

/**
 * @author Leonardo
 * @version 1.0
 */
public class HorarioAulaDAO {

    private EntityManager manager = JpaUtil.getEntityManager();
    private EntityTransaction trx = manager.getTransaction();

    /**
     * Lista todos os objetos HorarioAula armazenados no banco de dados
     *
     * @return
     */
    public List<HorarioAula> Listar() {

        TypedQuery<HorarioAula> query = manager.createQuery("from HorarioAula", HorarioAula.class);
        List<HorarioAula> hAulas = query.getResultList();
        return hAulas;
    }

    /**
     * Armazana no banco de dados o objeto recebido por parametro
     *
     * @param horarioAula
     */
    public void criar(HorarioAula horarioAula) {
        try {
            trx.begin();
            manager.persist(horarioAula);
            trx.commit();
        } catch (Exception ex) {
            ex.printStackTrace();
            trx.rollback();
        }
    }

    /**
     * Atualiza no banco de dados o objeto recebido por parametro
     *
     * @param horarioAula
     */
    public void Atualizar(HorarioAula horarioAula) {
        try {
            trx.begin();
            manager.merge(horarioAula);
            trx.commit();
        } catch (Exception ex) {
            ex.printStackTrace();
            trx.rollback();
        }
    }

    /**
     * Apaga do banco de dados o objeto horarioAula recebido por parametro
     *
     * @param horarioAula
     */
    public void Deletar(HorarioAula horarioAula) {
        try {
            trx.begin();
            horarioAula = manager.find(HorarioAula.class, horarioAula.getId());
            manager.remove(horarioAula);
            trx.commit();
        } catch (Exception ex) {
            ex.printStackTrace();
            trx.rollback();
        }
    }

}
