package br.edu.ifba.eunapolis.gestoacademica.controller;

import br.edu.ifba.eunapolis.gestoacademica.util.JpaUtil;
import br.edu.ifba.eunapolis.gestoacademica.model.Ementa;
import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
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

    public void cadastrar() {
        trx.begin();
        this.manager.persist(ementa);
        trx.commit();
    }

    public void editar() {
        trx.begin();
        this.manager.merge(ementa);
        trx.commit();
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
        trx.begin();
        this.manager.remove(ementaSelecionada);
        trx.commit();
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
