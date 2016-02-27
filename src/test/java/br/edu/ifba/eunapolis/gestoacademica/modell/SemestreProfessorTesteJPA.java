package br.edu.ifba.eunapolis.gestoacademica.modell;
import br.edu.ifba.eunapolis.gestoacademica.dao.JpaUtil;
import java.util.Calendar;

import javax.persistence.EntityManager;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import br.edu.ifba.eunapolis.gestoacademica.model.Professor;
import br.edu.ifba.eunapolis.gestoacademica.model.Semestre;
import br.edu.ifba.eunapolis.gestoacademica.model.SemestreProfessor;
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class SemestreProfessorTesteJPA {

	private static Integer idSemestreProfessorSalvo;
	private static Integer idProfessorSalvo;
	private static Integer idSemestreSalvo;

	@Test
	public void testAdicionar() throws Exception {

		Professor professorTeste = new Professor("ProfessorTeste");
		
		EntityManager entityManager = JpaUtil.getEntityManager();
		entityManager.getTransaction().begin();

		entityManager.persist(professorTeste);
		
		entityManager.close();
		
		idProfessorSalvo = professorTeste.getId();
   
		Semestre semestreTeste = new Semestre();
		Calendar c  = Calendar.getInstance();
		Calendar f = Calendar.getInstance();
		c.set(02, 02, 2016);
		f.set(02, 06, 2016);
		
		semestreTeste.setId(null);
		semestreTeste.setAno(2016);
		semestreTeste.setInicio(c);
		semestreTeste.setFim(f);
		semestreTeste.setAtivo(true);
		semestreTeste.setPeriodoLetivo(4);
		
		
		EntityManager entityManager2 = JpaUtil.getEntityManager();
		entityManager2.getTransaction().begin();
		
		entityManager2.persist(semestreTeste);

		entityManager2.getTransaction().commit();

		entityManager2.close();

		idSemestreSalvo = semestreTeste.getId();
		
		SemestreProfessor semestreProfessorTeste = new SemestreProfessor();
      
		EntityManager entityManager3 = JpaUtil.getEntityManager();
		entityManager3.getTransaction().begin();

		Semestre semestre = entityManager3.find(Semestre.class, idSemestreSalvo);

		Professor professor = entityManager3.find(Professor.class, idProfessorSalvo);

		semestreProfessorTeste.setProfessor(professor);
		semestreProfessorTeste.setSemestre(semestre);
		semestreProfessorTeste.setMaximoHorasProfessor(120);
		semestreProfessorTeste.setTurmas(null);

		entityManager3.persist(semestreProfessorTeste);
		entityManager3.getTransaction().commit();
		entityManager3.close();

		idSemestreProfessorSalvo = semestreProfessorTeste.getId();
	}
	

	@Test
	public void testBuscar() throws Exception {

		EntityManager entityManager = JpaUtil.getEntityManager();

		entityManager.find(SemestreProfessor.class, idSemestreProfessorSalvo);

		entityManager.close();

	}
	
	@Test
	public void testAtualizar() throws Exception {

		EntityManager entityManager = JpaUtil.getEntityManager();
		entityManager.getTransaction().begin();

		SemestreProfessor semestreProfessorTeste = entityManager.find(SemestreProfessor.class,
				idSemestreProfessorSalvo);

		Semestre semestre = entityManager.find(Semestre.class, idSemestreSalvo);

		semestreProfessorTeste.setSemestre(semestre);
		semestreProfessorTeste.setMaximoHorasProfessor(150);
		semestreProfessorTeste.setTurmas(null);

		entityManager.persist(semestreProfessorTeste);
		entityManager.getTransaction().commit();
		entityManager.close();

	}
 
	@Test
	public void testDelete() throws Exception {

		EntityManager entityManager = JpaUtil.getEntityManager();
		entityManager.getTransaction().begin();

		SemestreProfessor semestreProfessorTeste = entityManager.find(SemestreProfessor.class,
				idSemestreProfessorSalvo);
		entityManager.remove(semestreProfessorTeste);

		entityManager.getTransaction().commit();
		entityManager.close();

	}
	

}
