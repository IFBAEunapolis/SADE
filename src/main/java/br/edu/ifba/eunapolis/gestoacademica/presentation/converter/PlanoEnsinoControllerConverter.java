/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifba.eunapolis.gestoacademica.presentation.converter;

import br.edu.ifba.eunapolis.gestoacademica.model.PlanoEnsino;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author Luana
 */
@FacesConverter(forClass = PlanoEnsino.class)
public class PlanoEnsinoControllerConverter extends AbstractControllerConverter<PlanoEnsino> {

    public PlanoEnsinoControllerConverter() {
        super(PlanoEnsino.class, "planoEnsinoController");
    }

    
}
