package br.edu.ifba.eunapolis.gestoacademica.controller;

import br.edu.ifba.eunapolis.gestoacademica.dao.JpaUtil;
import br.edu.ifba.eunapolis.gestoacademica.model.Disciplina;
import br.edu.ifba.eunapolis.gestoacademica.model.SemestreProfessor;
import br.edu.ifba.eunapolis.gestoacademica.model.Turma;
import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

/**
 *
 * @author Administrador
 */
@ManagedBean
@ViewScoped
public class TurmaBean implements Serializable {

    private static final long serialVersionUID = 1L;

    EntityManager manager = JpaUtil.getEntityManager();
    EntityTransaction trx = manager.getTransaction();
    private Turma turma = new Turma();
    private Turma turmaSelecionada;
    private List<Turma> turmas;
    private List<Disciplina> disciplinas;
    private List<SemestreProfessor> professores;
    private Integer id;

    public void prepararCadastro() {

        TypedQuery<Disciplina> queryD = manager.createQuery(
                "from Disciplina", Disciplina.class);
        disciplinas = queryD.getResultList();

        TypedQuery<SemestreProfessor> queryP = manager.createQuery(
                "from SemestreProfessor", SemestreProfessor.class);
        professores = queryP.getResultList();

    }

    public void cadastrar() {
        trx.begin();
        this.manager.persist(turma);
        trx.commit();
    }

    public void editar(Turma turma) {
        this.manager.merge(turma);
    }

    public void consultar() {
        TypedQuery<Turma> query = manager.createQuery(
                "from Turma", Turma.class);
        turmas = query.getResultList();
    }

    public void excluir() {
        trx.begin();
        this.manager.remove(turma);
        trx.commit();
    }

    public void porId() {
        turma = manager.find(Turma.class, getId());
    }

    /**
     * @return the turmas
     */
    public List<Turma> getTurmas() {
        return turmas;
    }

    /**
     * @return the turmaSelecionada
     */
    public Turma getTurmaSelecionada() {
        return turmaSelecionada;
    }

    /**
     * @param turmaSelecionada the turmaSelecionada to set
     */
    public void setTurmaSelecionada(Turma turmaSelecionada) {
        this.turmaSelecionada = turmaSelecionada;
    }

    /**
     * @return the disciplinas
     */
    public List<Disciplina> getDisciplinas() {
        return disciplinas;
    }

    /**
     * @return the professores
     */
    public List<SemestreProfessor> getProfessores() {
        return professores;
    }

    /**
     * @return the turma
     */
    public Turma getTurma() {
        return turma;
    }

    /**
     * @param turma the turma to set
     */
    public void setTurma(Turma turma) {
        this.turma = turma;
    }

    /**
     * @return the id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Integer id) {
        this.id = id;
    }
}
