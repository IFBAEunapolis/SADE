package br.edu.ifba.eunapolis.gestoacademica.model;

import java.util.List;
import javax.persistence.*;

/**
 * @author Franciel
 * @version 1.0
 */
@Entity
public class Turma extends AbstractModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(length = 50, nullable = false)
    private String nome;

    @ManyToOne(optional = false)
    private Disciplina disciplina;

    @ManyToOne(optional = true)
    private PlanoEnsino planoEnsino;

    @ManyToOne(optional = false)
    private PeriodoLetivoProfessor periodoLetivoProfessor;

    @OneToMany
    private List<HorarioAula> horarioAulas;
    
    @ManyToOne(optional = true)
    private EspacoFisico espacoFisico;

    public Turma() {
    }

    /**
     * Retona o Id do objeto Turma
     *
     * @return
     */
    @Override
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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
     * Retorna a plano de Ensino da turma
     *
     * @return
     */
    public PlanoEnsino getPlanoEnsino() {
        return planoEnsino;
    }

    public void setPlanoEnsino(PlanoEnsino planoEnsino) {
        this.planoEnsino = planoEnsino;
    }

    public PeriodoLetivoProfessor getPeriodoLetivoProfessor() {
        return periodoLetivoProfessor;
    }

    public void setPeriodoLetivoProfessor(PeriodoLetivoProfessor periodoLetivoProfessor) {
        this.periodoLetivoProfessor = periodoLetivoProfessor;
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

    public EspacoFisico getEspacoFisico() {
        return espacoFisico;
    }

    public void setEspacoFisico(EspacoFisico espacoFisico) {
        this.espacoFisico = espacoFisico;
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
