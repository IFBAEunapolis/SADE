package br.edu.ifba.eunapolis.gestoacademica.presentation.converter;

import br.edu.ifba.eunapolis.gestoacademica.model.Professor;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author Luana Almeida
 */
@FacesConverter(forClass = Professor.class)
public class ProfessorControllerConverter extends AbstractControllerConverter<Professor> {

    public ProfessorControllerConverter() {
        super(Professor.class, "professorController");
    }

}
