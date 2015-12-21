/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifba.eunapolis.gestoacademica.controller;

import br.edu.ifba.eunapolis.gestoacademica.model.Disciplina;
import br.edu.ifba.eunapolis.gestoacademica.model.HorarioAula;
import br.edu.ifba.eunapolis.gestoacademica.model.PlanoAula;
import br.edu.ifba.eunapolis.gestoacademica.model.SemestreProfessor;
import static java.lang.System.out;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 *
 * @author Administrador
 */

@ManagedBean(name = "turma")
public class TurmaBean {

    private String disciplina;
    private String planoAula;
    private String semestreProfessor;
    private String horarioAulas;

    public void cadastrar(){
       out.println("<br/>");
       out.println("Cadastrado com sucesso!");
    }
    
    /**
     * @return the disciplina
     */
    public String getDisciplina() {
        return disciplina;
    }

    /**
     * @param disciplina the disciplina to set
     */
    public void setDisciplina(String disciplina) {
        this.disciplina = disciplina;
    }

    /**
     * @return the planoAula
     */
    public String getPlanoAula() {
        return planoAula;
    }

    /**
     * @param planoAula the planoAula to set
     */
    public void setPlanoAula(String planoAula) {
        this.planoAula = planoAula;
    }

    /**
     * @return the semestreProfessor
     */
    public String getSemestreProfessor() {
        return semestreProfessor;
    }

    /**
     * @param semestreProfessor the semestreProfessor to set
     */
    public void setSemestreProfessor(String semestreProfessor) {
        this.semestreProfessor = semestreProfessor;
    }

    /**
     * @return the horarioAulas
     */
    public String getHorarioAulas() {
        return horarioAulas;
    }

    /**
     * @param horarioAulas the horarioAulas to set
     */
    public void setHorarioAulas(String horarioAulas) {
        this.horarioAulas = horarioAulas;
    }
    
    
}
