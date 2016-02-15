package br.edu.ifba.eunapolis.gestoacademica.modell;

import br.edu.ifba.eunapolis.gestoacademica.dao.JpaUtil;
import javax.persistence.EntityManager;

import org.junit.Test;

import br.edu.ifba.eunapolis.gestoacademica.model.Professor;
import br.edu.ifba.eunapolis.gestoacademica.model.Semestre;
import br.edu.ifba.eunapolis.gestoacademica.model.SemestreProfessor;
/**
 * Classe responsavel pelos testes da tabela SemestreProfessor
 * 
 * @author Luana
 * @version 1.0
 * */
public class SemestreProfessorTesteJPA {

      /**
       * Salva um objeto do tipo SemestreProfessor no banco.
       * 
       */
	
	@Test
	public void testSalvar() throws Exception {
		
		SemestreProfessor semestreProfessorTeste = new SemestreProfessor();
		
		EntityManager entityManager = JpaUtil.getEntityManager();
		entityManager.getTransaction().begin();
		
		Professor professor = entityManager.find(Professor.class, 2);
		Semestre semestre = entityManager.find(Semestre.class, 2);
		
		semestreProfessorTeste.setProfessor(professor);
		semestreProfessorTeste.setSemestre(semestre);
		semestreProfessorTeste.setMaximoHorasProfessor(120);
		semestreProfessorTeste.setTurmas(null);
		
		entityManager.persist(semestreProfessorTeste);
		entityManager.getTransaction().commit();
		entityManager.close();

	}
	
	/**
       * Busca um objeto do tipo SemestreProfessor no banco de Dados
       * 
       */

	@Test
	public void testbuscar() throws Exception {

		EntityManager entityManager = JpaUtil.getEntityManager();

		entityManager.find(SemestreProfessor.class, 4);

		entityManager.close();

	}

         /**
       * Atualiza um objeto do tipo SemestreProfessor no banco de Dados
       * 
       */
	@Test
	public void testAtualizar() throws Exception {

		EntityManager entityManager = JpaUtil.getEntityManager();
		entityManager.getTransaction().begin();

		SemestreProfessor semestreProfessorTeste
		= entityManager.find(SemestreProfessor.class, 2);
      
		Semestre semestre = entityManager.find(Semestre.class,4);
		
		semestreProfessorTeste.setSemestre(semestre);
		semestreProfessorTeste.setMaximoHorasProfessor(150);
		semestreProfessorTeste.setTurmas(null);

		entityManager.persist(semestreProfessorTeste);
		entityManager.getTransaction().commit();
		entityManager.close();

	}
       /**
       * Deleta  um objeto do tipo semestre no banco de Dados
       * 
       */

	
	@Test
	public void testdelete() throws Exception {

		EntityManager entityManager = JpaUtil.getEntityManager();
		entityManager.getTransaction().begin();

		SemestreProfessor semestreProfessorTeste = entityManager.find(SemestreProfessor.class, 6);
		entityManager.remove(semestreProfessorTeste);

		entityManager.getTransaction().commit();
		entityManager.close();

	}
 
}
