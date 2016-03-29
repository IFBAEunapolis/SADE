package br.edu.ifba.eunapolis.gestoacademica.model;

import br.edu.ifba.eunapolis.gestoacademica.util.JpaUtil;
import java.util.Calendar;

import javax.persistence.EntityManager;

import org.junit.Test;

import br.edu.ifba.eunapolis.gestoacademica.model.Semestre;

/**
 * Classe responsavel pelos testes da tabela Semestre
 * 
 * @author Luana Almeida
 * @version 1.0
 */

public class SemestreTesteJPA {
	
      /**
       * Salva um objeto do tipo semestre no banco.
       * 
       */
	
	@Test
	public void testSalvar() throws Exception {
		
		Calendar c  = Calendar.getInstance();
		Calendar f = Calendar.getInstance();
		c.set(02, 02, 2016);
		f.set(02, 06, 2016);
		
		Semestre semestreTeste = new Semestre();
	
		EntityManager entityManager = JpaUtil.getEntityManager();
		entityManager.getTransaction().begin();
		
		semestreTeste.setId(null);
		semestreTeste.setAno(2016);
		semestreTeste.setInicio(c);
		semestreTeste.setFim(f);
		semestreTeste.setAtivo(true);
		semestreTeste.setPeriodoLetivo(4);
		
		entityManager.persist(semestreTeste);
		
		entityManager.getTransaction().commit();
		entityManager.close();

	} 
        
         /**
       * Busca um objeto do tipo semestre no banco de Dados
       * 
       */
 
	@Test
	public void testbuscar() throws Exception {

		EntityManager entityManager = JpaUtil.getEntityManager();

		entityManager.find(Semestre.class, 1);

		entityManager.close();

	}
	
         /**
       * Atualiza um objeto do tipo semestre no banco de Dados
       * 
       */
	
	@Test
	public void testAtualizar() throws Exception {

		 Calendar c  = Calendar.getInstance();
		 Calendar f = Calendar.getInstance();
	     c.set(2016,Calendar.FEBRUARY, 03);
		 f.set(2016,Calendar.AUGUST, 20);
	
	   // DateFormat hI = DateFormat.getDateTimeInstance();
		
		EntityManager entityManager = JpaUtil.getEntityManager();
		entityManager.getTransaction().begin();

		Semestre semestreTeste = entityManager.find(Semestre.class, 1);
		
		semestreTeste.setAno(2016);
		semestreTeste.setInicio(c);
		semestreTeste.setFim(f);
		semestreTeste.setAtivo(true);
		semestreTeste.setPeriodoLetivo(3);

		entityManager.persist(semestreTeste);
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

		Semestre semestreTeste = entityManager.find(Semestre.class, 1);
		entityManager.remove(semestreTeste);

		entityManager.getTransaction().commit();
		entityManager.close();

	}
 
}
