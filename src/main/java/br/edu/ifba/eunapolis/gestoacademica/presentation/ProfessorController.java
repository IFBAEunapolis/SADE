package br.edu.ifba.eunapolis.gestoacademica.presentation;

import br.edu.ifba.eunapolis.gestoacademica.model.Professor;
import br.edu.ifba.eunapolis.gestoacademica.session.AbstractFacade;
import br.edu.ifba.eunapolis.gestoacademica.session.ProfessorFacade;

import javax.ejb.EJB;
import javax.inject.Named;
import javax.faces.view.ViewScoped;

/**
 *
 * @author Luana
 */

@Named("professorController")
@ViewScoped
public class ProfessorController extends AbstractController<Professor> {

    @EJB
    private ProfessorFacade ejbFacade;
   

    public ProfessorController() {
        super(Professor.class);
    }

    @Override
    protected AbstractFacade<Professor> getFacade() {
        return ejbFacade;
    }

    
      
}
