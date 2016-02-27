package br.edu.ifba.eunapolis.gestoacademica.controller;

import static java.lang.System.out;

import javax.faces.bean.ManagedBean;


@ManagedBean(name = "professor")
/**
 *
 * @author Luana
 */
public class ProfessorBean {

	private String idProfessor;
	private String nomeProfessor;
	private String semestreprofessor;

	public void cadastrar() {

		out.println("<br/>");
		out.println("Cadastrado com sucesso!");

	}

	
	public void setIdProfessor(String idProfessor) {
		this.idProfessor = idProfessor;
	}

	public void setNomeProfessor(String nomeProfessor) {
		this.nomeProfessor = nomeProfessor;
	}

	public void setSemestreprofessor(String semestreprofessor) {
		this.semestreprofessor = semestreprofessor;
	}

	public String getIdProfessor() {
		return idProfessor;
	}

	public String getNomeProfessor() {
		return nomeProfessor;
	}

	public String getSemestreprofessor() {
		return semestreprofessor;
	}

}
