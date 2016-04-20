package br.edu.ifba.eunapolis.gestoacademica.presentation;
import br.edu.ifba.eunapolis.gestoacademica.model.PeriodoLetivoProfessor;
import br.edu.ifba.eunapolis.gestoacademica.session.AbstractFacade;
import br.edu.ifba.eunapolis.gestoacademica.session.PeriodoLetivoProfessorFacade;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.faces.view.ViewScoped;

@Named("periodoLetivoProfessorController")
@ViewScoped
public class PeriodoLetivoProfessorController extends AbstractController<PeriodoLetivoProfessor> {

    @EJB
    private PeriodoLetivoProfessorFacade ejbFacade;

    public PeriodoLetivoProfessorController() {
        super(PeriodoLetivoProfessor.class);
    }

    @Override
    protected  AbstractFacade<PeriodoLetivoProfessor>getFacade() {
        return ejbFacade;
    }

}
