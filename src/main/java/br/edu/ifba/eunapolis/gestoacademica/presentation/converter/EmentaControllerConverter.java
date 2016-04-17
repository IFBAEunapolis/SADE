package br.edu.ifba.eunapolis.gestoacademica.presentation.converter;

import br.edu.ifba.eunapolis.gestoacademica.model.Ementa;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author Leonardo Rufino
 */
@FacesConverter(forClass = Ementa.class)
public class EmentaControllerConverter extends AbstractControllerConverter<Ementa> {

    public EmentaControllerConverter() {
        super(Ementa.class, "ementaController");
    }

}
