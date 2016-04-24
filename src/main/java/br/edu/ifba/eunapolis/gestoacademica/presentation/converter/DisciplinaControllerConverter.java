package br.edu.ifba.eunapolis.gestoacademica.presentation.converter;

import br.edu.ifba.eunapolis.gestoacademica.model.Disciplina;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author willads
 */
@FacesConverter(forClass = Disciplina.class)
public class DisciplinaControllerConverter extends AbstractControllerConverter<Disciplina> {

    public DisciplinaControllerConverter() {
        super(Disciplina.class, "disciplinaController");
    }

}
