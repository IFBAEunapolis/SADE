package br.edu.ifba.eunapolis.gestoacademica.model;

import java.util.List;
import javax.persistence.*;

@Entity
@Table(name = "turma")
public class Turma {

	private Integer id;
	private String nome;
	private Disciplina disciplina;
	private PlanoAula planoAula;
	private SemestreProfessor semestreProfessor;
	private List<HorarioAula> horarioAulas;

	public Turma() {
	}

	@Id
	@GeneratedValue
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Column(length = 50, nullable = false)
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	@ManyToOne(optional = false)
	@JoinColumn(name = "disciplina_id")
	public Disciplina getDisciplina() {
		return disciplina;
	}

	public void setDisciplina(Disciplina disciplina) {
		this.disciplina = disciplina;
	}

	@ManyToOne(optional = false)
	@JoinColumn(name = "planoAula_id")
	public PlanoAula getPlanoAula() {
		return planoAula;
	}

	public void setPlanoAula(PlanoAula planoAula) {
		this.planoAula = planoAula;
	}

	@ManyToOne(optional = false)
	@JoinColumn(name = "semestreProfessor_id")
	public SemestreProfessor getSemestreProfessor() {
		return semestreProfessor;
	}

	public void setSemestreProfessor(SemestreProfessor semestreProfessor) {
		this.semestreProfessor = semestreProfessor;
	}

	@OneToMany
	@JoinColumn(name = "horarioAula_id")
	@Column(name = "horario_aulas")
	public List<HorarioAula> getHorarioAulas() {
		return horarioAulas;
	}

	public void setHorarioAulas(List<HorarioAula> horarioAulas) {
		this.horarioAulas = horarioAulas;
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
		Turma other = (Turma) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
