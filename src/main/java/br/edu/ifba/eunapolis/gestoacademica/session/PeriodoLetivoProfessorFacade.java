package br.edu.ifba.eunapolis.gestoacademica.session;
import javax.ejb.Stateless;
import br.edu.ifba.eunapolis.gestoacademica.model.PeriodoLetivoProfessor;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author root
 */
@Stateless
public class PeriodoLetivoProfessorFacade extends AbstractFacade<PeriodoLetivoProfessor> {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    protected EntityManager getEntityManager() {
        return entityManager;
    }

    public PeriodoLetivoProfessorFacade() {
        super(PeriodoLetivoProfessor.class);
    }

}