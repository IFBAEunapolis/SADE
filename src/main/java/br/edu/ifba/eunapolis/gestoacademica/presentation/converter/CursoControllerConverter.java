/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifba.eunapolis.gestoacademica.presentation.converter;

import br.edu.ifba.eunapolis.gestoacademica.model.Curso;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author Jonathas 'John'
 * @version 1.0.0
 * @since 19/04/2016
 */
@FacesConverter(forClass = Curso.class)
public class CursoControllerConverter extends AbstractControllerConverter<Curso> {

    public CursoControllerConverter() {
        super(Curso.class, "cursoController");
    }
}
