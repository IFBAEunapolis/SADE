package br.edu.ifba.eunapolis.gestoacademica.presentation;


import br.edu.ifba.eunapolis.gestoacademica.model.EspacoFisico;
import br.edu.ifba.eunapolis.gestoacademica.session.EspacoFisicoFacade;

import javax.ejb.EJB;
import javax.inject.Named;
import javax.faces.view.ViewScoped;

/**
 *
 * @author Jonathas 'John'
 * @version 1.1.0
 * @since 20/04/2016
 */
@Named("espacoFisicoController")
@ViewScoped
public class EspacoFisicoController extends AbstractController<EspacoFisico> {

    @EJB
    private EspacoFisicoFacade ejbFacade;
    
    public  EspacoFisicoController() {
        super(EspacoFisico.class);
    }

    @Override
    protected EspacoFisicoFacade getFacade() {
        return ejbFacade;
    }
}
