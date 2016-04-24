package br.edu.ifba.eunapolis.gestoacademica.presentation;

import br.edu.ifba.eunapolis.gestoacademica.model.Turma;
import br.edu.ifba.eunapolis.gestoacademica.session.TurmaFacade;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.faces.view.ViewScoped;

@Named("turmaController")
@ViewScoped
public class TurmaController extends AbstractController<Turma> {

    @EJB
    private TurmaFacade ejbFacade;

    public TurmaController() {
        super(Turma.class);
    }

    @Override
    protected TurmaFacade getFacade() {
        return ejbFacade;
    }

}
