/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifba.eunapolis.gestoacademica.presentation.converter;

import br.edu.ifba.eunapolis.gestoacademica.model.Professor;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author Luana Almeida
 */
@FacesConverter(forClass = Professor.class)
public class ProfessorControllerConverter extends AbstractControllerConverter<Professor>{
    
    public ProfessorControllerConverter() {
        super(Professor.class, "professorController");
    }
    
}
