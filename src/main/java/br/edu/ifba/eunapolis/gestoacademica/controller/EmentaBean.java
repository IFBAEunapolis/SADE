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
@ManagedBean (name = "ementa")
public class EmentaBean {
    
    private String id;
    private String nome;
    private String disciplinas;
    private String descricao;
    
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

    /**
     * @return the descricao
     */
    public String getDescricao() {
        return descricao;
    }

    /**
     * @param descricao the descricao to set
     */
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    
}
