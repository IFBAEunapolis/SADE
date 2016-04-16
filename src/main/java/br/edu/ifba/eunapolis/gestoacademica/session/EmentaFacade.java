package br.edu.ifba.eunapolis.gestoacademica.session;

import br.edu.ifba.eunapolis.gestoacademica.model.Ementa;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Leonardo Rufino
 */
@Stateless
public class EmentaFacade extends AbstractFacade<Ementa> {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    protected EntityManager getEntityManager() {
        return entityManager;
    }

    public EmentaFacade() {
        super(Ementa.class);
    }

}
