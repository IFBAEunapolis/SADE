package br.edu.ifba.eunapolis.gestoacademica.converter;

import br.edu.ifba.eunapolis.gestoacademica.controller.SemestreProfessorBean;
import br.edu.ifba.eunapolis.gestoacademica.model.SemestreProfessor;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author leonardo
 */
//@FacesConverter(forClass = SemestreProfessor.class)
public class SemestreProfessorConverter implements Converter {

    @Override
    public Object getAsObject(FacesContext fc,
            UIComponent uic, String string) {
        SemestreProfessor retorno = null;

        if (string != null && !"".equals(string)) {
            SemestreProfessorBean semestreprofessor = new SemestreProfessorBean();
            retorno = semestreprofessor.porId(new Integer(string));
        }
        return retorno;
    }

    @Override
    public String getAsString(FacesContext fc,
            UIComponent uic, Object o) {
        if (o != null) {
            return ((SemestreProfessor) o).getId().toString();
        }
        return null;

    }

}
