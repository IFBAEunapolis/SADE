package br.edu.ifba.eunapolis.gestoacademica.controller;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import br.edu.ifba.eunapolis.gestoacademica.dao.JpaUtil;
import br.edu.ifba.eunapolis.gestoacademica.model.Semestre;

@ManagedBean
@ViewScoped
public class ConsultaSemestreBean {
	
	private List<Semestre> semestres;
	private static final long serialVersionUID = 1L;
	private Integer idParaDeletar;
	
	public void consultar(){
		EntityManager manager = JpaUtil.getEntityManager();
		TypedQuery<Semestre> query = manager.createQuery(
		"from Semestre", Semestre.class);
		this.semestres = query.getResultList();
		manager.close();
	}
	
	public void deletarSemestre(){
		EntityManager manager = JpaUtil.getEntityManager();
		EntityTransaction tx = manager.getTransaction();
		tx.begin();
		Semestre semestre= manager.find(Semestre.class, this.idParaDeletar);
		manager.remove(semestre);
		tx.commit();
		manager.close();
	}

	public List<Semestre> getSemestres() {
		return semestres;
	}

	public Integer getIdParaDeletar() {
		return idParaDeletar;
	}

	public void setIdParaDeletar(Integer idParaDeletar) {
		this.idParaDeletar = idParaDeletar;
	}	

}
