/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifba.eunapolis.gestoacademica.controller;

import static java.lang.System.out;
import java.util.Calendar;
import javax.faces.bean.ManagedBean;
import javax.persistence.Column;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Michael
 */
@ManagedBean(name = "semestre")
public class SemestreBean {
    private String id;
    private String ano;
    private String periodoLetivo;
    private String inicio;
    private String fim;
    private String ativo;
    
    public void cadastrar(){
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
     * @return the ano
     */
    public String getAno() {
        return ano;
    }

    /**
     * @param ano the ano to set
     */
    public void setAno(String ano) {
        this.ano = ano;
    }

    /**
     * @return the periodoLetivo
     */
    public String getPeriodoLetivo() {
        return periodoLetivo;
    }

    /**
     * @param periodoLetivo the periodoLetivo to set
     */
    public void setPeriodoLetivo(String periodoLetivo) {
        this.periodoLetivo = periodoLetivo;
    }

    /**
     * @return the inicio
     */
    public String getInicio() {
        return inicio;
    }

    /**
     * @param inicio the inicio to set
     */
    public void setInicio(String inicio) {
        this.inicio = inicio;
    }

    /**
     * @return the fim
     */
    public String getFim() {
        return fim;
    }

    /**
     * @param fim the fim to set
     */
    public void setFim(String fim) {
        this.fim = fim;
    }

    /**
     * @return the ativo
     */
    public String getAtivo() {
        return ativo;
    }

    /**
     * @param ativo the ativo to set
     */
    public void setAtivo(String ativo) {
        this.ativo = ativo;
    }
}
