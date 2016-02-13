package br.edu.ifba.eunapolis.gestoacademica.controller;

import java.util.Calendar;

import javax.faces.bean.ManagedBean;

@ManagedBean(name = "hora")
public class HorarioAulaBean {
	
	//@PersistenceContext(name="br.edu.ifba.eunapolis_SADE_war_0.0.1-SNAPSHOTPU")
	//private EntityManager entityManager;
	
	//private HorarioAula horarioAula;

	//public void cadastrar(){
	//	entityManager.persist(getHorarioAula());
	//}

	private String diaSemana;
	private Calendar horaInicio;
	private Calendar horaFim;
	private String mensagem;
	
	public void MensagemCadastro(){
		this.mensagem = "Dia: "+this.diaSemana+" HoraIni: "+this.horaInicio+" HoraFim: "+this.horaFim+" Cadastrados com Sucesso!";
	}

	public String getMensagem() {
		return mensagem;
	}

	public String getDiaSemana() {
		return diaSemana;
	}

	public void setDiaSemana(String diaSemana) {
		this.diaSemana = diaSemana;
	}
	public Calendar getHoraInicio() {
		return horaInicio;
	}
	public void setHoraInicio(Calendar horaInicio) {
		this.horaInicio = horaInicio;
	}
	public Calendar getHoraFim() {
		return horaFim;
	}

	public void setHoraFim(Calendar horaFim) {
		this.horaFim = horaFim;
	}


}
