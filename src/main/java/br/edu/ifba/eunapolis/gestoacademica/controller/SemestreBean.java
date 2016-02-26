/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifba.eunapolis.gestoacademica.controller;

import java.util.Calendar;
import java.util.Date;
import javax.faces.bean.ManagedBean;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;


import br.edu.ifba.eunapolis.gestoacademica.dao.JpaUtil;
import br.edu.ifba.eunapolis.gestoacademica.model.Semestre;

/**
 *
 * @author Michael
 */
@ManagedBean(name = "semestre")
public class SemestreBean {
	
	
	private Integer ano;
	private Integer periodoLetivo;
	private Date inicio;
	private Date fim;
	private Boolean ativo;
    private EntityManager manager;
    private Semestre semestreModel;
    
    public SemestreBean(){
    	manager=JpaUtil.getEntityManager();
    	semestreModel= new Semestre();
    }
    
    public void cadastrar(){
    	cast();
    	EntityTransaction trx= this.manager.getTransaction();
        trx.begin();
        this.manager.persist(semestreModel);
        trx.commit();
        manager.close();
    }

	public Integer getAno() {
		return ano;
	}

	public void setAno(Integer ano) {
		this.ano = ano;
	}

	public Integer getPeriodoLetivo() {
		return periodoLetivo;
	}

	public void setPeriodoLetivo(Integer periodoLetivo) {
		this.periodoLetivo = periodoLetivo;
	}

	public Date getInicio() {
		return inicio;
	}

	public void setInicio(Date inicio) {
		this.inicio = inicio;
	}

	public Date getFim() {
		return fim;
	}

	public void setFim(Date fim) {
		this.fim = fim;
	}

	public Boolean getAtivo() {
		return ativo;
	}

	public void setAtivo(Boolean ativo) {
		this.ativo = ativo;
	}
	
	private void cast(){
		Calendar Inicio=Calendar.getInstance();
		Calendar Fim=Calendar.getInstance();
		Inicio.setTime(this.inicio);
		Fim.setTime(this.fim);
		semestreModel.setAno(this.ano);
		semestreModel.setPeriodoLetivo(this.periodoLetivo);
		semestreModel.setAtivo(this.ativo);
		semestreModel.setInicio(Inicio);
		semestreModel.setFim(Fim);
	}
	
	
  
}
