package br.edu.ifba.eunapolis.gestoacademica.presentation.converter;

import br.edu.ifba.eunapolis.gestoacademica.model.HorarioAula;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author Leonardo Rufino
 */
@FacesConverter(forClass = HorarioAula.class)
public class HorarioAulaControllerConverter extends AbstractControllerConverter<HorarioAula> {

    public HorarioAulaControllerConverter() {
        super(HorarioAula.class, "horarioAulaController");
    }

}
