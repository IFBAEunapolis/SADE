/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifba.eunapolis.gestoacademica.controller;

import javax.faces.bean.ManagedBean;

/**
 *
 * @author Will
 */
@ManagedBean(name = "curso")
public class CursoBean {
    
    private String id;
    private String nome;
    private String disciplinas;
    
    public void Cadastrar() {
        System.out.println("Cadastrado com sucesso!");
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
     * @return the disciplinas
     */
    public String getDisciplinas() {
        return disciplinas;
    }

    /**
     * @param disciplinas the disciplinas to set
     */
    public void setDisciplinas(String disciplinas) {
        this.disciplinas = disciplinas;
    }
}
