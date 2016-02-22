/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifba.eunapolis.gestoacademica.controller;


import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import br.edu.ifba.eunapolis.gestoacademica.dao.JpaUtil;
import br.edu.ifba.eunapolis.gestoacademica.model.Curso;
import br.edu.ifba.eunapolis.gestoacademica.model.Disciplina;

/**
 *
 * @author Will
 */
@ManagedBean 
@ApplicationScoped
public class DisciplinaBean {
    
    private EntityManager manager=JpaUtil.getEntityManager();;
    private Disciplina discip;
    private Curso curs;
    private String nome;
    private String curso;
    private String ementa;
    private Integer cargaHoraria;
    private String preRequisitos;
    private String turmas;
    private Integer periodo;
    
    
    public DisciplinaBean(){
    	
    }
    
    public void cadastrar() {
       feed();
       EntityTransaction trx= this.manager.getTransaction();
       trx.begin();
       this.manager.persist(discip);
       trx.commit();
       manager.close();
    }

	public Disciplina getDisciplina() {
		return discip;
	}

	public void setDisciplina(Disciplina discip) {
		this.discip= discip;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCurso() {
		return curso;
	}

	public void setCurso(String curso) {
		this.curso = curso;
	}

	public String getEmenta() {
		return ementa;
	}

	public void setEmenta(String ementa) {
		this.ementa = ementa;
	}

	public Integer getCargaHoraria() {
		return cargaHoraria;
	}

	public void setCargaHoraria(Integer cargaHoraria) {
		this.cargaHoraria = cargaHoraria;
	}

	public String getPreRequisitos() {
		return preRequisitos;
	}

	public void setPreRequisitos(String preRequisitos) {
		this.preRequisitos = preRequisitos;
	}

	public String getTurmas() {
		return turmas;
	}

	public void setTurmas(String turmas) {
		this.turmas = turmas;
	}

	public Integer getPeriodo() {
		return periodo;
	}

	public void setPeriodo(Integer periodo) {
		this.periodo = periodo;
	}

	private void feed(){
		discip=new Disciplina();
		curs=new Curso();
		curs.setNome("TESTE");
		discip.setNome(this.nome);
		discip.setCargaHoraria(this.cargaHoraria);
		discip.setPeriodo(this.periodo);
		discip.setCurso(curs);
	}
}
