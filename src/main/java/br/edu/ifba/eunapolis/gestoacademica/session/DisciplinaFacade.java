package br.edu.ifba.eunapolis.gestoacademica.session;

import br.edu.ifba.eunapolis.gestoacademica.model.Disciplina;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author root
 */
@Stateless
public class DisciplinaFacade extends AbstractFacade<Disciplina> {

    @PersistenceContext
    private EntityManager em;
    private Disciplina temp;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public DisciplinaFacade() {
        super(Disciplina.class);
    }

    public List<Disciplina> retornaPreRequisitos(Disciplina selected) {
        temp = em.find(Disciplina.class, selected.getId());
        return temp.getPreRequisitos();
        /*
        ver http://www.objectdb.com/java/jpa/query/jpql/from
         */
    }

}
