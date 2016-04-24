package br.edu.ifba.eunapolis.gestoacademica.presentation.converter;

import br.edu.ifba.eunapolis.gestoacademica.model.Area;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author root
 */
@FacesConverter(forClass = Area.class)
public class AreaControllerConverter extends AbstractControllerConverter<Area> {

    public AreaControllerConverter() {
        super(Area.class, "areaController");
    }

}
