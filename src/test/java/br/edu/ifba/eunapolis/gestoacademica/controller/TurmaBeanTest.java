/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifba.eunapolis.gestoacademica.controller;

import br.edu.ifba.eunapolis.gestoacademica.model.Disciplina;
import br.edu.ifba.eunapolis.gestoacademica.model.PlanoAula;
import br.edu.ifba.eunapolis.gestoacademica.model.SemestreProfessor;
import br.edu.ifba.eunapolis.gestoacademica.model.Turma;

/**
 *
 * @author Cliente
 */
public class TurmaBeanTest {

    public void test() {

        Turma turma = new Turma();
        turma.setNome("Turma B");
        turma.setDisciplina(new Disciplina());
        turma.setPlanoAula(new PlanoAula());
        turma.setSemestreProfessor(new SemestreProfessor());
   

    }

}
