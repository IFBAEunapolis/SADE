/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
