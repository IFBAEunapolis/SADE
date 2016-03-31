package br.edu.ifba.eunapolis.gestoacademica.converter;

import br.edu.ifba.eunapolis.gestoacademica.controller.DisciplinaBean;
import br.edu.ifba.eunapolis.gestoacademica.model.Disciplina;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author leonardo
 */
@FacesConverter(forClass = Disciplina.class)
public class DisciplinaConverter implements Converter {

    @Override
    public Object getAsObject(FacesContext fc,
            UIComponent uic, String string) {
        Disciplina retorno = null;

        if (string != null && !"".equals(string)) {
            DisciplinaBean disciplina = new DisciplinaBean();
            retorno = disciplina.porId(new Integer(string));
        }
        return retorno;
    }

    @Override
    public String getAsString(FacesContext fc,
            UIComponent uic, Object o) {
        if (o != null) {
            return ((Disciplina) o).getId().toString();
        }
        return null;

    }

}
