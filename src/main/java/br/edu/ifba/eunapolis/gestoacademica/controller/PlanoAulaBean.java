package br.edu.ifba.eunapolis.gestoacademica.controller;

import javax.faces.bean.ManagedBean;

@ManagedBean(name = "plano")
public class PlanoAulaBean {

	private String descricao;
	private String turma;
	private String mensagem;

	public void MensagemCadastro(){
		this.mensagem = "Turma: "+this.turma+" Descrição: "+this.descricao+" Cadastrados com Sucesso!";
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public String getTurma() {
		return turma;
	}
	public void setTurma(String turma) {
		this.turma = turma;
	}
	public String getMensagem() {
		return mensagem;
	}



}
