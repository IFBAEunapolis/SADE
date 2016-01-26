package br.edu.ifba.eunapolis.gestoacademica.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "semestreProfessor")
public class SemestreProfessor {

	private Integer id;
	private Professor professor;
	private Semestre semestre;
	private List<Turma> turmas;
	private Integer maximoHorasProfessor;

	public SemestreProfessor() {
	}

	@Id
	@GeneratedValue
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@ManyToOne
	@JoinColumn(name = "professor_id")
	public Professor getProfessor() {
		return professor;
	}

	public void setProfessor(Professor professor) {
		this.professor = professor;
	}

	@ManyToOne
	@JoinColumn(name = "semestre_id")
	public Semestre getSemestre() {
		return semestre;
	}

	public void setSemestre(Semestre semestre) {
		this.semestre = semestre;
	}

	@OneToMany
	@JoinColumn(name = "turma_id")
	public List<Turma> getTurmas() {
		return turmas;
	}

	public void setTurmas(List<Turma> turmas) {
		this.turmas = turmas;
	}

	@Column(length = 2, name = "maximo_horas_professor", nullable = false)
	public Integer getMaximoHorasProfessor() {
		return maximoHorasProfessor;
	}

	public void setMaximoHorasProfessor(Integer maximoHorasProfessor) {
		this.maximoHorasProfessor = maximoHorasProfessor;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SemestreProfessor other = (SemestreProfessor) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
