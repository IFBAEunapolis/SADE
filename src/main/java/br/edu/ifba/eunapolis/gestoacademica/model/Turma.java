package br.edu.ifba.eunapolis.gestoacademica.model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.*;
import javax.validation.constraints.Size;
import org.hibernate.validator.constraints.NotEmpty;

/**
 * @author Franciel
 * @version 1.0
 */
@Entity
@Table(name = "turma")
public class Turma implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue
    private Integer id;

    @NotEmpty
    @Size(max = 50)
    @Column(length = 50, nullable = false)
    private String nome;

    @NotEmpty
    @ManyToOne(optional = false)
    @JoinColumn(name = "disciplina_id")
    private Disciplina disciplina;

    @ManyToOne(optional = true)
    @JoinColumn(name = "planoAula_id")
    private PlanoAula planoAula;

    @NotEmpty
    @ManyToOne(optional = false)
    @JoinColumn(name = "semestreProfessor_id")
    private SemestreProfessor semestreProfessor;

    @OneToMany
    @JoinColumn(name = "horarioAula_id")
    @Column(name = "horario_aulas")
    private List<HorarioAula> horarioAulas;

    public Turma() {
    }

    /**
     * Retona o Id do objeto Turma
     *
     * @return
     */
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
    public PlanoAula getPlanoAula() {
        return planoAula;
    }

    public void setPlanoAula(PlanoAula planoAula) {
        this.planoAula = planoAula;
    }

    /**
     * Retorna o professor do semestre na turma
     *
     * @return
     */
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
