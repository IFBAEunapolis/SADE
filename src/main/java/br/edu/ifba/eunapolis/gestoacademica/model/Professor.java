package br.edu.ifba.eunapolis.gestoacademica.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
/**
 *
 * @author Luana Almeida
 * @version 1.0
 */
@Entity
@Table(name = "professor")
public class Professor implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue
	private Integer id;
	@Column(length = 50, nullable = false)
	private String nome;
	@OneToMany
	@JoinColumn(name = "semestreProfessor_id")
	@Column(name = "semestre_professores")
	private List<SemestreProfessor> semestreProfessores;

	public Professor() {}
	
	public Professor(String nome) {
		this.id = id;
		this.nome = nome;
		this.semestreProfessores = null;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<SemestreProfessor> getSemestreProfessores() {
		return semestreProfessores;
	}

	public void setSemestreProfessores(List<SemestreProfessor> semestreProfessores) {
		this.semestreProfessores = semestreProfessores;
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
		Professor other = (Professor) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
