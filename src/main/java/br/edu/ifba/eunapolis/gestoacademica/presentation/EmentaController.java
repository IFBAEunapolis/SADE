package br.edu.ifba.eunapolis.gestoacademica.presentation;

import br.edu.ifba.eunapolis.gestoacademica.model.Ementa;
import br.edu.ifba.eunapolis.gestoacademica.session.EmentaFacade;

import javax.ejb.EJB;
import javax.inject.Named;
import javax.faces.view.ViewScoped;

@Named("ementaController")
@ViewScoped
public class EmentaController extends AbstractController<Ementa> {

    @EJB
    private EmentaFacade ejbFacade;

    public EmentaController() {
        super(Ementa.class);
    }

    @Override
    protected EmentaFacade getFacade() {
        return ejbFacade;
    }

}
