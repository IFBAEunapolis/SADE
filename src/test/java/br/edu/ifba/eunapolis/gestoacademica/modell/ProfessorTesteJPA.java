
package br.edu.ifba.eunapolis.gestoacademica.modell;
import br.edu.ifba.eunapolis.gestoacademica.dao.JpaUtil;
import javax.persistence.EntityManager;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import br.edu.ifba.eunapolis.gestoacademica.model.Professor;
import junit.framework.TestCase;

/**
 * Classe responsavel pelos testes da tabela professor
 * 
 * @author Luana Almeida
 * @version 1.1
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ProfessorTesteJPA extends TestCase {
	
	private static Integer idProfessorSalvo; 
	
	
	
	@Test
	public void testAdicionar() throws Exception {
		
		Professor professorTeste = new Professor("ProfessorTeste");

		EntityManager entityManager = JpaUtil.getEntityManager();
		entityManager.getTransaction().begin();
		entityManager.persist(professorTeste);
		entityManager.getTransaction().commit();
		entityManager.close();

		idProfessorSalvo = professorTeste.getId();
	}
	
	@Test
	public void testBuscar() throws Exception {

		EntityManager entityManager = JpaUtil.getEntityManager();

		entityManager.find(Professor.class, idProfessorSalvo);

		entityManager.close();
		
	}

	@Test
	public void testAtualizar() throws Exception {

		EntityManager entityManager = JpaUtil.getEntityManager();
		
		entityManager.getTransaction().begin();

		Professor professorTeste = entityManager.find(Professor.class, idProfessorSalvo);

		professorTeste.setNome("ProfessorTesteAtualizando");

		entityManager.persist(professorTeste);
		
		entityManager.getTransaction().commit();
		entityManager.close();

	}
	@Test
	public void testDelete() throws Exception {

		EntityManager entityManager = JpaUtil.getEntityManager();
		entityManager.getTransaction().begin();

		Professor professorTeste = entityManager.find(Professor.class, idProfessorSalvo);
		entityManager.remove(professorTeste);

		entityManager.getTransaction().commit();
		entityManager.close();

	}

}
