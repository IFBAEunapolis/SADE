package br.edu.ifba.eunapolis.gestoacademica.controller;

import javax.faces.bean.ManagedBean;

@ManagedBean(name = "hora")
public class HorarioAulaBean {

	private String diaSemana;
	private String horaInicio;
	private String horaFim;
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
	public String getHoraInicio() {
		return horaInicio;
	}
	public void setHoraInicio(String horaInicio) {
		this.horaInicio = horaInicio;
	}
	public String getHoraFim() {
		return horaFim;
	}
	public void setHoraFim(String horaFim) {
		this.horaFim = horaFim;
	}


}
