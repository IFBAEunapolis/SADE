package br.edu.ifba.eunapolis.gestoacademica.presentation;

import br.edu.ifba.eunapolis.gestoacademica.model.Curso;
import br.edu.ifba.eunapolis.gestoacademica.session.CursoFacade;
import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

/**
 *
 * @author Jonathas 'John'
 * @version 1.1.0
 * @since 20/04/2016
 */
@Named("cursoController")
@ViewScoped
public class CursoController extends AbstractController<Curso> {

    @EJB
    private CursoFacade ejbFacade;

    public CursoController() {
        super(Curso.class);
    }

    @Override
    protected CursoFacade getFacade() {
        return ejbFacade;
    }
}
