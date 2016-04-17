/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifba.eunapolis.gestoacademica.presentation.converter;

import br.edu.ifba.eunapolis.gestoacademica.model.EspacoFisico;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author Luana
 */
@FacesConverter(forClass = EspacoFisico.class)
public class EspacoFisicoControllerConverter extends AbstractControllerConverter<EspacoFisico> {
    
    public EspacoFisicoControllerConverter() {
      super(EspacoFisico.class, "espacoFisicoController");
    }
}
