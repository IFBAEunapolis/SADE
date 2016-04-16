package br.edu.ifba.eunapolis.gestoacademica.presentation;

import br.edu.ifba.eunapolis.gestoacademica.model.Area;
import br.edu.ifba.eunapolis.gestoacademica.session.AreaFacade;

import javax.ejb.EJB;
import javax.inject.Named;
import javax.faces.view.ViewScoped;

@Named("areaController")
@ViewScoped
public class AreaController extends AbstractController<Area> {

    @EJB
    private AreaFacade ejbFacade;

    public AreaController() {
        super(Area.class);
    }

    @Override
    protected AreaFacade getFacade() {
        return ejbFacade;
    }

}
