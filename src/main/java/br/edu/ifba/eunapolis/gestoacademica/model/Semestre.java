package br.edu.ifba.eunapolis.gestoacademica.model;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
@Entity
@Table(name="Semestre")

public class Semestre {

	@Id
	@GeneratedValue
	private Integer id;
	@Column(nullable = false)
	private Integer ano;
	@Column(nullable = false)
	private Integer periodoLetivo;
	@Temporal(TemporalType.TIMESTAMP)
	private Calendar inicio;
	@Temporal(TemporalType.TIMESTAMP)
	private Calendar fim;
	@Column(nullable = false)
	private Boolean ativo;
    
   
    public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getAno() {
		return ano;
	}
	public void setAno(Integer ano) {
		this.ano = ano;
	}
	public Integer getPeriodoLetivo() {
		return periodoLetivo;
	}
	public void setPeriodoLetivo(Integer periodoLetivo) {
		this.periodoLetivo = periodoLetivo;
	}
	public Calendar getInicio() {
		return inicio;
	}
	public void setInicio(Calendar inicio) {
		this.inicio = inicio;
	}
	public Calendar getFim() {
		return fim;
	}
	public void setFim(Calendar fim) {
		this.fim = fim;
	}
	public Boolean getAtivo() {
		return ativo;
	}
	public void setAtivo(Boolean ativo) {
		this.ativo = ativo;
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
		Semestre other = (Semestre) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
    
    
    
    
}
