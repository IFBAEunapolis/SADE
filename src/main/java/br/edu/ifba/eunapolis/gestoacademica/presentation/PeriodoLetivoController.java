package br.edu.ifba.eunapolis.gestoacademica.presentation;


import br.edu.ifba.eunapolis.gestoacademica.model.PeriodoLetivo;
import br.edu.ifba.eunapolis.gestoacademica.session.AbstractFacade;
import br.edu.ifba.eunapolis.gestoacademica.session.PeriodoLetivoFacade;


import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Named;


@Named("periodoLetivoController")
@ViewScoped
public class PeriodoLetivoController extends AbstractController<PeriodoLetivo> {

    @EJB
    private PeriodoLetivoFacade ejbFacade;
    
    public  PeriodoLetivoController(){
    
    super(PeriodoLetivo.class);
   }

    @Override
    protected AbstractFacade<PeriodoLetivo> getFacade() {
            return ejbFacade; 
    }
   

    
}
