package br.edu.ifba.eunapolis.gestoacademica.presentation;

import br.edu.ifba.eunapolis.gestoacademica.model.PlanoEnsino;
import br.edu.ifba.eunapolis.gestoacademica.session.PlanoEnsinoFacade;
import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

@Named("planoEnsinoController")
@ViewScoped
public class PlanoEnsinoController extends AbstractController<PlanoEnsino> {

    @EJB
    private PlanoEnsinoFacade ejbFacade;

    public PlanoEnsinoController() {
        super(PlanoEnsino.class);
    }

    @Override
    protected PlanoEnsinoFacade getFacade() {
        return ejbFacade;
    }

}
