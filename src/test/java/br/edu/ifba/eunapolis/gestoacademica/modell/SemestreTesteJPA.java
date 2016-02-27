package br.edu.ifba.eunapolis.gestoacademica.modell;
import br.edu.ifba.eunapolis.gestoacademica.dao.JpaUtil;
import java.util.Calendar;

import javax.persistence.EntityManager;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import br.edu.ifba.eunapolis.gestoacademica.model.Semestre;

/**
 * Classe responsavel pelos testes da tabela Semestre
 * 
 * @author Luana Almeida
 * @version 1.1
 */

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class SemestreTesteJPA {
	
	private  static Integer idSemestreSalvo; 
	
	
	@Test
	public void testAdicionar() throws Exception {
		
		Calendar c  = Calendar.getInstance();
		Calendar f = Calendar.getInstance();
		c.set(02, 02, 2016);
		f.set(02, 06, 2016);
		
		Semestre semestreTeste = new Semestre();
	
		EntityManager entityManager = JpaUtil.getEntityManager();
		entityManager.getTransaction().begin();
		
		
		semestreTeste.setAno(2016);
		semestreTeste.setInicio(c);
		semestreTeste.setFim(f);
		semestreTeste.setAtivo(true);
		semestreTeste.setPeriodoLetivo(4);
		
		entityManager.persist(semestreTeste);
		
		entityManager.getTransaction().commit();
		entityManager.close();

		idSemestreSalvo =semestreTeste.getId(); 
		  
	} 
 
	@Test
	public void testBuscar() throws Exception {

		EntityManager entityManager = JpaUtil.getEntityManager();

		entityManager.find(Semestre.class, idSemestreSalvo);

		entityManager.close();

	}
	
	
	@Test
	public void testAtualizar() throws Exception {

		 Calendar c  = Calendar.getInstance();
		 Calendar f = Calendar.getInstance();
	     c.set(2016,Calendar.FEBRUARY, 03);
		 f.set(2016,Calendar.AUGUST, 20);
	
	   // DateFormat hI = DateFormat.getDateTimeInstance();
		
		EntityManager entityManager = JpaUtil.getEntityManager();
		entityManager.getTransaction().begin();

		Semestre semestreTeste = entityManager.find(Semestre.class, idSemestreSalvo);
		
		semestreTeste.setAno(2016);
		semestreTeste.setInicio(c);
		semestreTeste.setFim(f);
		semestreTeste.setAtivo(true);
		semestreTeste.setPeriodoLetivo(3);

		entityManager.persist(semestreTeste);
		entityManager.getTransaction().commit();
		entityManager.close();

	}

	
	@Test
	public void testDelete() throws Exception {

		EntityManager entityManager = JpaUtil.getEntityManager();
		entityManager.getTransaction().begin();

		Semestre semestreTeste = entityManager.find(Semestre.class, idSemestreSalvo);
		entityManager.remove(semestreTeste);

		entityManager.getTransaction().commit();
		entityManager.close();

	}
 
}
