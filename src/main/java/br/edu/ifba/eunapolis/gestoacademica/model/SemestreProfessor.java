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

}
