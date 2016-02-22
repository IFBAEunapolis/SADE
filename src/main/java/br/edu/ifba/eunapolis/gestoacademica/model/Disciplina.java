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
@Table(name = "disciplina")
public class Disciplina {
	@Id
    @GeneratedValue
    private Integer id;
	@Column(length = 50, nullable = false)
    private String nome;
	@ManyToOne(optional = false)
    @JoinColumn(name = "curso_id")
    private Curso curso;
	@ManyToOne(optional = false)
    @JoinColumn(name = "ementa_id")
    private Ementa ementa;
	@Column(name = "carga_horaria", length = 3, nullable = false)
    private Integer cargaHoraria;
	@OneToMany
    @Column(name = "pre_requisitos")
    private List<Disciplina> preRequisitos;
	@OneToMany
    private List<Turma> turmas;
	@Column(length = 10, nullable = false)
    private Integer periodo;

    public Disciplina() {
    }

    public Disciplina(String nome, Curso curso, Ementa ementa, Integer cargaHoraria, List<Disciplina> preRequisitos, List<Turma> turmas, Integer periodo) {
        this.nome = nome;
        this.curso = curso;
        this.ementa = ementa;
        this.cargaHoraria = cargaHoraria;
        this.preRequisitos = preRequisitos;
        this.turmas = turmas;
        this.periodo = periodo;
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

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }
    
    public Ementa getEmenta() {
        return ementa;
    }

    public void setEmenta(Ementa ementa) {
        this.ementa = ementa;
    }
    
    public Integer getCargaHoraria() {
        return cargaHoraria;
    }

    public void setCargaHoraria(Integer cargaHoraria) {
        this.cargaHoraria = cargaHoraria;
    }
    
    public List<Disciplina> getPreRequisitos() {
        return preRequisitos;
    }

    public void setPreRequisitos(List<Disciplina> preRequisitos) {
        this.preRequisitos = preRequisitos;
    }
    
    public List<Turma> getTurmas() {
        return turmas;
    }

    public void setTurmas(List<Turma> turmas) {
        this.turmas = turmas;
    }
    
    public Integer getPeriodo() {
        return periodo;
    }

    public void setPeriodo(Integer periodo) {
        this.periodo = periodo;
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
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        Disciplina other = (Disciplina) obj;
        if (id == null) {
            if (other.id != null) {
                return false;
            }
        } else if (!id.equals(other.id)) {
            return false;
        }
        return true;
    }

}
