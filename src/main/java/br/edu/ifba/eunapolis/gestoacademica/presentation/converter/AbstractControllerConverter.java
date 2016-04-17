/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifba.eunapolis.gestoacademica.presentation.converter;

import br.edu.ifba.eunapolis.gestoacademica.model.AbstractModel;
import br.edu.ifba.eunapolis.gestoacademica.presentation.AbstractController;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;

/**
 *
 * @author root
 * @param <T>
 */
public class AbstractControllerConverter<T extends AbstractModel> implements Converter {

    
    private Class<T> entityClass;
    private String controllerName;
    
    public AbstractControllerConverter(Class<T> entityClass, String controllerName) {
        this.entityClass = entityClass;
        this.controllerName = controllerName;
    }
    

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            AbstractController<T> controller = (AbstractController<T>) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, controllerName);
            return controller.getItem(getKey(value));
        }

        java.lang.Long getKey(String value) {
            java.lang.Long key;
            key = Long.valueOf(value);
            return key;
        }

        String getStringKey(java.lang.Long value) {
            StringBuilder sb = new StringBuilder();
            sb.append(value);
            return sb.toString();
        }

        @Override
        public String getAsString(FacesContext facesContext, UIComponent component, Object object) {
            if (object == null) {
                return null;
            }
            if (entityClass.isInstance(object)) {
                T o = (T) object;
                return getStringKey(o.getId());
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), entityClass.getName()});
                return null;
            }
        }

    
}
