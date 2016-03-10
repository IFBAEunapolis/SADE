package br.edu.ifba.eunapolis.gestoacademica.controller;

import br.edu.ifba.eunapolis.gestoacademica.dao.JpaUtil;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import br.edu.ifba.eunapolis.gestoacademica.model.Professor;

@ManagedBean(name = "professor")
/**
 *
 * @author Luana Almeida
 */

public class ProfessorBean {

	private String idProfessor;
	private String nomeProfessor;
	private String semestreprofessor;

	private EntityManager em = JpaUtil.getEntityManager();
	private EntityTransaction trans = em.getTransaction();

	public void cadastrar(Professor professor) {
		try {
			trans.begin();
			em.persist(professor);
			em.getTransaction();
			trans.commit();
		} catch (Exception e) {
			e.printStackTrace();
			trans.rollback();
		}
	}

	public List<Professor> listarProfessores() {

		TypedQuery<Professor> q = em.createQuery("from Professor", Professor.class);
		List<Professor> listProfessores = q.getResultList();

		return listProfessores;
	}

	public void buscarProfessor(Integer idProfessor) {

		try {
			trans.begin();
			em.find(Professor.class, idProfessor);
		} catch (Exception e) {
			e.printStackTrace();
			trans.rollback();
		}
	}

	public void atualizar(Professor professor) {
		try {
			trans.begin();
			em.merge(professor);
			em.getTransaction();
			trans.commit();
		} catch (Exception e) {
			e.printStackTrace();
			trans.rollback();
		}
	}

	public void Deletar(Professor professor) {
		try {
			trans.begin();
			professor = em.find(Professor.class, professor.getId());
			em.remove(professor);
			trans.commit();
		} catch (Exception e) {
			e.printStackTrace();
			trans.rollback();
		}
	}

	public void setIdProfessor(String idProfessor) {
		this.idProfessor = idProfessor;
	}

	public void setNomeProfessor(String nomeProfessor) {
		this.nomeProfessor = nomeProfessor;
	}

	public void setSemestreprofessor(String semestreprofessor) {
		this.semestreprofessor = semestreprofessor;
	}

	public String getIdProfessor() {
		return idProfessor;
	}

	public String getNomeProfessor() {
		return nomeProfessor;
	}

	public String getSemestreprofessor() {
		return semestreprofessor;
	}

}
