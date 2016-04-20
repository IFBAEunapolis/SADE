package br.edu.ifba.eunapolis.gestoacademica.presentation.converter;

import br.edu.ifba.eunapolis.gestoacademica.model.PeriodoLetivoProfessor;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author Huggo Santos
 */
@FacesConverter(forClass = PeriodoLetivoProfessor.class)
public class PeriodoLetivoProfessorControllerConverter extends AbstractControllerConverter<PeriodoLetivoProfessor> {

    public PeriodoLetivoProfessorControllerConverter() {
        super(PeriodoLetivoProfessor.class, "periodoLetivoProfessorController");
    }

}
