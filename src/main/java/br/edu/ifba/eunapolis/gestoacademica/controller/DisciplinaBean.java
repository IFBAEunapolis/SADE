/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifba.eunapolis.gestoacademica.controller;

import static java.lang.System.out;
import javax.faces.bean.ManagedBean;

/**
 *
 * @author Will
 */
@ManagedBean (name = "disciplina")
public class DisciplinaBean {
    
    private String id;
    private String nome;
    private String curso;
    private String ementa;
    private String cargaHoraria;
    private String preRequisitos;
    private String turmas;
    private String periodo;
    
    public void cadastrar() {
       out.println("<br/>");
       out.println("Cadastrado com sucesso!");
    }

    /**
     * @return the id
     */
    public String getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * @return the curso
     */
    public String getCurso() {
        return curso;
    }

    /**
     * @param curso the curso to set
     */
    public void setCurso(String curso) {
        this.curso = curso;
    }

    /**
     * @return the ementa
     */
    public String getEmenta() {
        return ementa;
    }

    /**
     * @param ementa the ementa to set
     */
    public void setEmenta(String ementa) {
        this.ementa = ementa;
    }

    /**
     * @return the cargaHoraria
     */
    public String getCargaHoraria() {
        return cargaHoraria;
    }

    /**
     * @param cargaHoraria the cargaHoraria to set
     */
    public void setCargaHoraria(String cargaHoraria) {
        this.cargaHoraria = cargaHoraria;
    }

    /**
     * @return the preRequisitos
     */
    public String getPreRequisitos() {
        return preRequisitos;
    }

    /**
     * @param preRequisitos the preRequisitos to set
     */
    public void setPreRequisitos(String preRequisitos) {
        this.preRequisitos = preRequisitos;
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
     * @return the periodo
     */
    public String getPeriodo() {
        return periodo;
    }

    /**
     * @param periodo the periodo to set
     */
    public void setPeriodo(String periodo) {
        this.periodo = periodo;
    }
}
