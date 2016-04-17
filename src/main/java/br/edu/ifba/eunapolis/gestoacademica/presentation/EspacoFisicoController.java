package br.edu.ifba.eunapolis.gestoacademica.presentation;


import br.edu.ifba.eunapolis.gestoacademica.model.EspacoFisico;
import br.edu.ifba.eunapolis.gestoacademica.session.AbstractFacade;
import br.edu.ifba.eunapolis.gestoacademica.session.EspacoFisicoFacade;

import javax.ejb.EJB;
import javax.inject.Named;
import javax.faces.view.ViewScoped;

@Named("espacoFisicoController")
@ViewScoped
public class EspacoFisicoController extends AbstractController<EspacoFisico> {

    @EJB
    private EspacoFisicoFacade ejbFacade;
    
    public  EspacoFisicoController() {
        super(EspacoFisico.class);
    }

    @Override
    protected AbstractFacade<EspacoFisico> getFacade() {
           return ejbFacade;
    }
    
   
    
}
