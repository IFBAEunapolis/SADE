package br.edu.ifba.eunapolis.gestoacademica.presentation;

import br.edu.ifba.eunapolis.gestoacademica.model.HorarioAula;
import br.edu.ifba.eunapolis.gestoacademica.session.HorarioAulaFacade;
import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

@Named("horarioAulaController")
@ViewScoped
public class HorarioAulaController extends AbstractController<HorarioAula> {

    @EJB
    private HorarioAulaFacade ejbFacade;

    public HorarioAulaController() {
        super(HorarioAula.class);
    }

    @Override
    protected HorarioAulaFacade getFacade() {
        return ejbFacade;
    }
}
