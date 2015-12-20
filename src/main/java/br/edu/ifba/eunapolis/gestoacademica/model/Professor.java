package br.edu.ifba.eunapolis.gestoacademica.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "tab_Professor")
public class Professor {
	@Id
	@GeneratedValue
	@Column(name = "id_Professor")
    private Integer id;
    @Column(name = "nome_Professor", nullable = false)
    private String nome;
    @OneToMany
    private List<SemestreProfessor> semestreProfessors;
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
	public List<SemestreProfessor> getSemestreProfessors() {
		return semestreProfessors;
	}
	public void setSemestreProfessors(List<SemestreProfessor> semestreProfessors) {
		this.semestreProfessors = semestreProfessors;
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
