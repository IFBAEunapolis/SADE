package br.edu.ifba.eunapolis.gestoacademica.presentation.converter;

import br.edu.ifba.eunapolis.gestoacademica.model.PeriodoLetivo;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author Luana Almeida
 */
@FacesConverter(forClass = PeriodoLetivo.class)
public class PeriodoLetivoControllerConverter extends AbstractControllerConverter<PeriodoLetivo> {

    public PeriodoLetivoControllerConverter() {
        super(PeriodoLetivo.class, "periodoLetivoController");
    }

}
