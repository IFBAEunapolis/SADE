package br.edu.ifba.eunapolis.gestoacademica.presentation;

import br.edu.ifba.eunapolis.gestoacademica.model.Ementa;
import br.edu.ifba.eunapolis.gestoacademica.presentation.util.JsfUtil;
import br.edu.ifba.eunapolis.gestoacademica.presentation.util.JsfUtil.PersistAction;

import java.io.Serializable;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJBException;
import javax.inject.Named;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.transaction.Transactional;

@Named("ementaController")
@ViewScoped
public class EmentaController implements Serializable {

    private List<Ementa> items = null;
    private Ementa selected;
    
    @PersistenceContext
    private EntityManager manager;

    
    
    public Ementa getSelected() {
        return selected;
    }

    public void setSelected(Ementa selected) {
        this.selected = selected;
    }

    protected void setEmbeddableKeys() {
    }

    protected void initializeEmbeddableKey() {
    }

    public Ementa prepareCreate() {
        selected = new Ementa();
        initializeEmbeddableKey();
        return selected;
    }

    public void create() {
        persist(PersistAction.CREATE, ResourceBundle.getBundle("/Bundle").getString("EmentaCreated"));
        if (!JsfUtil.isValidationFailed()) {
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public void update() {
        persist(PersistAction.UPDATE, ResourceBundle.getBundle("/Bundle").getString("EmentaUpdated"));
    }

    public void destroy() {
        persist(PersistAction.DELETE, ResourceBundle.getBundle("/Bundle").getString("EmentaDeleted"));
        if (!JsfUtil.isValidationFailed()) {
            selected = null; // Remove selection
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public List<Ementa> getItems() {
        if (items == null) {
            items = findAll();
        }
        return items;
    }

    private void persist(PersistAction persistAction, String successMessage) {
        if (selected != null) {
            setEmbeddableKeys();
            try {
                if (persistAction != PersistAction.DELETE) {
                    manager.merge(selected);
                } else {
                    manager.remove(selected);
                }
                JsfUtil.addSuccessMessage(successMessage);
            } catch (EJBException ex) {
                String msg = "";
                Throwable cause = ex.getCause();
                if (cause != null) {
                    msg = cause.getLocalizedMessage();
                }
                if (msg.length() > 0) {
                    JsfUtil.addErrorMessage(msg);
                } else {
                    JsfUtil.addErrorMessage(ex, ResourceBundle.getBundle("/Bundle").getString("PersistenceErrorOccured"));
                }
            } catch (Exception ex) {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, ex);
                JsfUtil.addErrorMessage(ex, ResourceBundle.getBundle("/Bundle").getString("PersistenceErrorOccured"));
            }
        }
    }

    public Ementa getEmenta(java.lang.Integer id) {
        return manager.find(Ementa.class, id);
    }

    public List<Ementa> getItemsAvailableSelectMany() {
        return findAll();
    }

    public List<Ementa> getItemsAvailableSelectOne() {
        return findAll();
    }

    @Transactional
    public List<Ementa> findAll() {

        CriteriaBuilder builder = manager.getCriteriaBuilder();
        CriteriaQuery<Ementa> query = builder.createQuery(Ementa.class);

        TypedQuery<Ementa> typedQuery = manager.createQuery(
                query.select(query.from(Ementa.class)));
        List<Ementa> results = typedQuery.getResultList();
        return results;
    }

    @FacesConverter(forClass = Ementa.class)
    public static class EmentaControllerConverter implements Converter {

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            EmentaController controller = (EmentaController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "ementaController");
            return controller.getEmenta(getKey(value));
        }

        java.lang.Integer getKey(String value) {
            java.lang.Integer key;
            key = Integer.valueOf(value);
            return key;
        }

        String getStringKey(java.lang.Integer value) {
            StringBuilder sb = new StringBuilder();
            sb.append(value);
            return sb.toString();
        }

        @Override
        public String getAsString(FacesContext facesContext, UIComponent component, Object object) {
            if (object == null) {
                return null;
            }
            if (object instanceof Ementa) {
                Ementa o = (Ementa) object;
                return getStringKey(o.getId());
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), Ementa.class.getName()});
                return null;
            }
        }

    }

}
