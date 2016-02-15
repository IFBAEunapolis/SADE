package br.edu.ifba.eunapolis.gestoacademica.modell;

import br.edu.ifba.eunapolis.gestoacademica.dao.JpaUtil;
import javax.persistence.EntityManager;

import org.junit.Test;

import br.edu.ifba.eunapolis.gestoacademica.model.Professor;
import junit.framework.TestCase;

/**
 * Classe responsavel pelos testes da tabela professor
 * 
 * @author Luana
 * @version 1.0
 */
public class ProfessorTesteJPA extends TestCase {
       /**
       * Salva um objeto do tipo professor no banco.
       * 
       */
	
	@Test
	public void testSalvar() throws Exception {
		
		Professor professorTeste = new Professor("ProfessorTeste");

		EntityManager entityManager = JpaUtil.getEntityManager();
		entityManager.getTransaction().begin();
		entityManager.persist(professorTeste);
		entityManager.getTransaction().commit();
		entityManager.close();

	}
        
        /**
       * Busca um objeto no banco de Dados
       * 
       */

	@Test
	public void testbuscar() throws Exception {

		EntityManager entityManager = JpaUtil.getEntityManager();

		entityManager.find(Professor.class, 1);

		entityManager.close();

	}

        /**
       * Atualiza um objeto do tipo professor no banco de Dados
       * 
       */
	@Test
	public void testAtualizar() throws Exception {

		EntityManager entityManager = JpaUtil.getEntityManager();
		entityManager.getTransaction().begin();

		Professor professorTeste = entityManager.find(Professor.class, 1);

		professorTeste.setNome("ProfessorTesteAtualizando");

		entityManager.persist(professorTeste);
		entityManager.getTransaction().commit();
		entityManager.close();

	}
       /**
       * Deleta um objeto do tipo professor no banco de Dados
       * 
       */
	@Test
	public void testdelete() throws Exception {

		EntityManager entityManager = JpaUtil.getEntityManager();
		entityManager.getTransaction().begin();

		Professor professorTeste = entityManager.find(Professor.class, 1);
		entityManager.remove(professorTeste);

		entityManager.getTransaction().commit();
		entityManager.close();

	}

}
