package br.edu.ifba.eunapolis.gestoacademica.model;

import java.util.List;
import javax.persistence.*;

@Entity
@Table(name = "Turma")
public class Turma {
    
    @Id
    @GeneratedValue
    private Integer id;
    
    @Column(length = 60, nullable = false)
    private String nome;
    
    @ManyToOne(optional = false)
    @JoinColumn(name = "disciplina_id")
    private Disciplina disciplina;
    
    @ManyToOne(optional = false)
    @JoinColumn(name = "planoAula_id")
    private PlanoAula planoAula;
    
    @ManyToOne(optional = false)
    @JoinColumn(name = "semestreProfessor_id")
    private SemestreProfessor semestreProfessor;
    
    @OneToMany
    @JoinColumn(name = "horarioAulas_id")
    private List<HorarioAula> horarioAulas;
    
    //-------------------------------CONSTRUTORES--------------------------------------//
    public Turma() {
    }

    //-------------------------------GETTERS E SETTERS---------------------------------//
    
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

    public Disciplina getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(Disciplina disciplina) {
        this.disciplina = disciplina;
    }

    public PlanoAula getPlanoAula() {
        return planoAula;
    }

    public void setPlanoAula(PlanoAula planoAula) {
        this.planoAula = planoAula;
    }

    public SemestreProfessor getSemestreProfessor() {
        return semestreProfessor;
    }

    public void setSemestreProfessor(SemestreProfessor semestreProfessor) {
        this.semestreProfessor = semestreProfessor;
    }

    public List<HorarioAula> getHorarioAulas() {
        return horarioAulas;
    }

    public void setHorarioAulas(List<HorarioAula> horarioAulas) {
        this.horarioAulas = horarioAulas;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + (this.id != null ? this.id.hashCode() : 0);
        return hash;
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
        final Turma other = (Turma) obj;
        if (this.id != other.id && (this.id == null || !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

}
