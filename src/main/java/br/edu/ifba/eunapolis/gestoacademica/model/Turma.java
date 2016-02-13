package br.edu.ifba.eunapolis.gestoacademica.model;

import java.util.List;
import javax.persistence.*;

/**
 * @author Franciel
 * @version 1.0
 */
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

    /**
     * Construtor da classe disciplina
     *
     * @param nome
     * @param disciplina
     * @param planoAula
     * @param semestreProfessor
     * @param horarioAulas
     */
    public Turma(String nome, Disciplina disciplina, PlanoAula planoAula, SemestreProfessor semestreProfessor, List<HorarioAula> horarioAulas) {
        this.nome = nome;
        this.disciplina = disciplina;
        this.planoAula = planoAula;
        this.semestreProfessor = semestreProfessor;
        this.horarioAulas = horarioAulas;
    }

    /**
     * Retona o Id do objeto Turma
     *
     * @return
     */
    @Id
    @GeneratedValue
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * Retorna o nome do objeto turma
     *
     * @return
     */
    @Column(length = 50, nullable = false)
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * Retorna as diciplinas da turma
     *
     * @return
     */
    @ManyToOne(optional = false)
    @JoinColumn(name = "disciplina_id")
    public Disciplina getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(Disciplina disciplina) {
        this.disciplina = disciplina;
    }

    /**
     * Retorna a plano de aula da turma
     *
     * @return
     */
    @ManyToOne(optional = false)
    @JoinColumn(name = "planoAula_id")
    public PlanoAula getPlanoAula() {
        return planoAula;
    }

    public void setPlanoAula(PlanoAula planoAula) {
        this.planoAula = planoAula;
    }

    /**
     *Retorna o professor do semestre na turma
     * @return
     */
    @ManyToOne(optional = false)
    @JoinColumn(name = "semestreProfessor_id")
    public SemestreProfessor getSemestreProfessor() {
        return semestreProfessor;
    }

    public void setSemestreProfessor(SemestreProfessor semestreProfessor) {
        this.semestreProfessor = semestreProfessor;
    }

    /**
     * Retorna a lista de horariosAaula da turma
     *
     * @return
     */
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
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        Turma other = (Turma) obj;
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
