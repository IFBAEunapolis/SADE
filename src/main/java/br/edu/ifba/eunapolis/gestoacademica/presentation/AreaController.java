package br.edu.ifba.eunapolis.gestoacademica.presentation;

import br.edu.ifba.eunapolis.gestoacademica.model.Area;
import br.edu.ifba.eunapolis.gestoacademica.session.AbstractFacade;
import br.edu.ifba.eunapolis.gestoacademica.session.AreaFacade;

import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;

@Named("areaController")
@SessionScoped
public class AreaController extends AbstractController<Area>  {

    @EJB
    private AreaFacade ejbFacade;
    

    public AreaController() {
        super(Area.class);
    }

    @Override
    protected AbstractFacade<Area> getFacade() {
        return ejbFacade;
    }
    
}
