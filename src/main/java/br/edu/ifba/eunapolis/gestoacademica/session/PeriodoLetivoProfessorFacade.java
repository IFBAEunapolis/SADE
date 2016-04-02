/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifba.eunapolis.gestoacademica.session;

import br.edu.ifba.eunapolis.gestoacademica.model.PeriodoLetivoProfessor;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author root
 */
@Stateless
public class PeriodoLetivoProfessorFacade extends AbstractFacade<PeriodoLetivoProfessor> {

    @PersistenceContext(unitName = "br.edu.ifba.eunapolis_mavenproject2_war_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public PeriodoLetivoProfessorFacade() {
        super(PeriodoLetivoProfessor.class);
    }
    
}
