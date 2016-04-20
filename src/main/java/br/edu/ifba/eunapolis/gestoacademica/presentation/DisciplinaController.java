package br.edu.ifba.eunapolis.gestoacademica.presentation;

import br.edu.ifba.eunapolis.gestoacademica.model.Disciplina;
import br.edu.ifba.eunapolis.gestoacademica.session.DisciplinaFacade;

import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import org.primefaces.model.DualListModel;

@Named("disciplinaController")
@ViewScoped
public class DisciplinaController extends AbstractController<Disciplina> {

    @EJB
    private br.edu.ifba.eunapolis.gestoacademica.session.DisciplinaFacade ejbFacade;
    private DualListModel<Disciplina> preRequisitos;
    private List<Disciplina> source;
    private Disciplina temp;
    
    public DisciplinaController() {
        super(Disciplina.class);
    }
    
    @Override
    protected DisciplinaFacade getFacade() {
        return ejbFacade;
    }
    
    /**
     * @return the preRequisitos
     */
    public DualListModel<Disciplina> getPreRequisitos() {
        return preRequisitos;
    }

    /**
     * @param preRequisitos the preRequisitos to set
     */
    public void setPreRequisitos(DualListModel<Disciplina> preRequisitos) {
        this.preRequisitos = preRequisitos;
    }
    
    @Override
    public Disciplina prepareCreate() {
        this.setSelected(new Disciplina());
        getSelected().setPreRequisitos(new ArrayList<Disciplina>());
        initializeEmbeddableKey();
        preRequisitos=new DualListModel<>(this.getItemsAvailableSelectOne(),getSelected().getPreRequisitos());
        return this.getSelected();
    }

    public void prepareUpdate(){
        source=this.getItemsAvailableSelectOne();
        temp=this.getSelected();
        this.temp.setPreRequisitos(ejbFacade.retornaPreRequisitos(this.getSelected()));
        source.removeAll(temp.getPreRequisitos());
        preRequisitos=new DualListModel<>(source,temp.getPreRequisitos());
    }
    
}
