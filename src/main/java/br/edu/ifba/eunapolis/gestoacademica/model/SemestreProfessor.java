package br.edu.ifba.eunapolis.gestoacademica.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Table(name = "tab_SemestreProfessor")
public class SemestreProfessor {
	@OneToMany
	private Professor professor;
	@OneToMany
	private Semestre semestre;
	@OneToMany
	private List<Turma> turmas;
	@Column(nullable = false)
	private Integer maximoHorasProfessor;
	
	public Professor getProfessor() {
		return professor;
	}
	public void setProfessor(Professor professor) {
		this.professor = professor;
	}
	public Semestre getSemestre() {
		return semestre;
	}
	public void setSemestre(Semestre semestre) {
		this.semestre = semestre;
	}
	public List<Turma> getTurmas() {
		return turmas;
	}
	public void setTurmas(List<Turma> turmas) {
		this.turmas = turmas;
	}
	public Integer getMaximoHorasProfessor() {
		return maximoHorasProfessor;
	}
	public void setMaximoHorasProfessor(Integer maximoHorasProfessor) {
		this.maximoHorasProfessor = maximoHorasProfessor;
	}

	
	
	
}
