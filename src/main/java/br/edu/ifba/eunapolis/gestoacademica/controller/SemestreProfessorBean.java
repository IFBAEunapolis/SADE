/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifba.eunapolis.gestoacademica.controller;

import br.edu.ifba.eunapolis.gestoacademica.model.Professor;
import br.edu.ifba.eunapolis.gestoacademica.model.Semestre;
import br.edu.ifba.eunapolis.gestoacademica.model.SemestreProfessor;
import br.edu.ifba.eunapolis.gestoacademica.model.Turma;
import br.edu.ifba.eunapolis.gestoacademica.util.JpaUtil;
import static java.lang.System.out;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.persistence.Column;
import javax.persistence.EntityManager;
import javax.persistence.OneToMany;

/**
 *
 * @author Michael
 */

@ManagedBean(name = "semestreprofessor")
public class SemestreProfessorBean {
    private String professor;
    private String semestre;
    private String turmas;
    private String maximoHorasProfessor;
    EntityManager manager = JpaUtil.getEntityManager();
        
    public void cadastrar(){
       out.println("<br/>");
       out.println("Cadastrado com sucesso!");
    }
    
    public SemestreProfessor porId(Integer id) {
        return manager.find(SemestreProfessor.class, id);
    }

    /**
     * @return the professor
     */
    public String getProfessor() {
        return professor;
    }

    /**
     * @param professor the professor to set
     */
    public void setProfessor(String professor) {
        this.professor = professor;
    }

    /**
     * @return the semestre
     */
    public String getSemestre() {
        return semestre;
    }

    /**
     * @param semestre the semestre to set
     */
    public void setSemestre(String semestre) {
        this.semestre = semestre;
    }

    /**
     * @return the turmas
     */
    public String getTurmas() {
        return turmas;
    }

    /**
     * @param turmas the turmas to set
     */
    public void setTurmas(String turmas) {
        this.turmas = turmas;
    }

    /**
     * @return the maximoHorasProfessor
     */
    public String getMaximoHorasProfessor() {
        return maximoHorasProfessor;
    }

    /**
     * @param maximoHorasProfessor the maximoHorasProfessor to set
     */
    public void setMaximoHorasProfessor(String maximoHorasProfessor) {
        this.maximoHorasProfessor = maximoHorasProfessor;
    }
    
    
        
}
