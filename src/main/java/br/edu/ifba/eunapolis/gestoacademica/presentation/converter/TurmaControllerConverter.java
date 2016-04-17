package br.edu.ifba.eunapolis.gestoacademica.presentation.converter;

import br.edu.ifba.eunapolis.gestoacademica.model.Turma;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author Leonardo Rufino
 */
@FacesConverter(forClass = Turma.class)
public class TurmaControllerConverter extends AbstractControllerConverter<Turma> {

    public TurmaControllerConverter() {
        super(Turma.class, "turmaController");
    }

}
