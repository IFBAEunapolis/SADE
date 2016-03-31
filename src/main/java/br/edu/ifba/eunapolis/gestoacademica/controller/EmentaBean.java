package br.edu.ifba.eunapolis.gestoacademica.controller;

import br.edu.ifba.eunapolis.gestoacademica.util.JpaUtil;
import br.edu.ifba.eunapolis.gestoacademica.model.Ementa;
import java.io.Serializable;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

/**
 *
 * @author Will
 */
@ManagedBean
@ViewScoped
public class EmentaBean implements Serializable {

    private static final long serialVersionUID = 1L;

    EntityManager manager = JpaUtil.getEntityManager();
    EntityTransaction trx = manager.getTransaction();
    private Ementa ementa = new Ementa();
    private List<Ementa> ementas;
    private Ementa ementaSelecionada;
    private Integer id;

    public String cadastrar() {
        FacesContext context = FacesContext.getCurrentInstance();
        try {
            trx.begin();
            this.manager.persist(ementa);
            context.addMessage(null, new FacesMessage(
                    "Ementa cadastrada com sucesso!"));
            trx.commit();
            return "ListarEmenta?faces-redirect=true";
        } catch (Exception e) {
            trx.rollback();
            FacesMessage mensagem = new FacesMessage(e.getMessage());
            mensagem.setSeverity(FacesMessage.SEVERITY_ERROR);
            context.addMessage(null, mensagem);
            return "CadastrarEmenta?faces-redirect=true";
        }
    }

    public void editar() {
        FacesContext context = FacesContext.getCurrentInstance();

        try {
            trx.begin();
            this.manager.merge(ementa);
            context.addMessage(null, new FacesMessage(
                    "Ementa alterada com sucesso!"));
            trx.commit();
        } catch (Exception e) {
            trx.rollback();
            FacesMessage mensagem = new FacesMessage(e.getMessage());
            mensagem.setSeverity(FacesMessage.SEVERITY_ERROR);
            context.addMessage(null, mensagem);

        }

    }

    public void consultar() {
        TypedQuery<Ementa> query = manager.createQuery(
                "from Ementa", Ementa.class);
        ementas = query.getResultList();

    }

    public void porId() {
        ementa = manager.find(Ementa.class, getId());
    }

    public void excluir() {

        FacesContext context = FacesContext.getCurrentInstance();
        try {
            trx.begin();
            this.manager.remove(ementaSelecionada);
            this.consultar();
            context.addMessage(null, new FacesMessage(
                    "Ementa excluída com sucesso!"));
            trx.commit();
        } catch (Exception e) {
            FacesMessage mensagem = new FacesMessage(e.getMessage());
            mensagem.setSeverity(FacesMessage.SEVERITY_ERROR);
            context.addMessage(null, mensagem);

        }
    }

    /**
     * @return the ementas
     */
    public List<Ementa> getEmentas() {
        return ementas;
    }

    /**
     * @return the ementaSelecionada
     */
    public Ementa getEmentaSelecionada() {
        return ementaSelecionada;
    }

    /**
     * @param ementaSelecionada the ementaSelecionada to set
     */
    public void setEmentaSelecionada(Ementa ementaSelecionada) {
        this.ementaSelecionada = ementaSelecionada;
    }

    /**
     * @return the ementa
     */
    public Ementa getEmenta() {
        return ementa;
    }

    /**
     * @param ementa the ementa to set
     */
    public void setEmenta(Ementa ementa) {
        this.ementa = ementa;
    }

    /**
     * @return the id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Integer id) {
        this.id = id;
    }

}
