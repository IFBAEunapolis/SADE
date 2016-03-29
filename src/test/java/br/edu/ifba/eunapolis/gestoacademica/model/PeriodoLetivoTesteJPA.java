package br.edu.ifba.eunapolis.gestoacademica.model;
import br.edu.ifba.eunapolis.gestoacademica.util.JpaUtil;
import java.util.Calendar;

import javax.persistence.EntityManager;

import org.junit.After;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import junit.framework.TestCase;

/**
 * Classe responsavel pelos testes da tabela PeridoLetivo
 * 
 * @author Luana Almeida
 * @version 1.1
 */

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class PeriodoLetivoTesteJPA extends TestCase {
	private EntityManager entityManager;
	private PeriodoLetivo periodoLetivoTeste;
	private PeriodoLetivo retornoPeriodoLetivoEsperdo;
	private Calendar c;
	private Calendar f;
	private static Integer idSemestreSalvo;

	@Before
	public void setUp() {
		retornoPeriodoLetivoEsperdo = new PeriodoLetivo();
		periodoLetivoTeste = new PeriodoLetivo();
		entityManager = JpaUtil.getEntityManager();
		f = Calendar.getInstance();
		c = Calendar.getInstance();
	}

	@After
	public void tearDown() {

	}

	/**
         * @throws java.lang.Exception
	 * @test Metodo teste para adicionar um objeto no DB
	 */

	@Test
	public void testAdiciona() throws Exception {

		c.set(02, 02, 2016);
		f.set(02, 06, 2016);

		periodoLetivoTeste.setAno(2016);
		periodoLetivoTeste.setInicio(c);
		periodoLetivoTeste.setFim(f);
		periodoLetivoTeste.setAtivo(true);
		periodoLetivoTeste.setPeriodoLetivo(4);

		entityManager.getTransaction().begin();
		entityManager.persist(periodoLetivoTeste);
		entityManager.getTransaction().commit();

		idSemestreSalvo = periodoLetivoTeste.getId();

		retornoPeriodoLetivoEsperdo = entityManager.find(PeriodoLetivo.class, idSemestreSalvo);

		assertEquals(periodoLetivoTeste.getAno(), retornoPeriodoLetivoEsperdo.getAno());
		assertEquals(periodoLetivoTeste.getInicio(), retornoPeriodoLetivoEsperdo.getInicio());
		assertEquals(periodoLetivoTeste.getFim(), retornoPeriodoLetivoEsperdo.getFim());
		assertEquals(periodoLetivoTeste.getPeriodoLetivo(), retornoPeriodoLetivoEsperdo.getPeriodoLetivo());
		assertEquals(periodoLetivoTeste.getAtivo(), retornoPeriodoLetivoEsperdo.getAtivo());

	}

	/**
         * @throws java.lang.Exception
	 * @test Metodo teste para atualizar um objeto no DB
	 */
	@Test
	public void testAtualiza() throws Exception {
		entityManager.getTransaction().begin();

		periodoLetivoTeste = entityManager.find(PeriodoLetivo.class, idSemestreSalvo);

		c.set(2016, Calendar.FEBRUARY, 03);
		f.set(2016, Calendar.AUGUST, 20);

		periodoLetivoTeste.setAno(2016);
		periodoLetivoTeste.setInicio(c);
		periodoLetivoTeste.setFim(f);
		periodoLetivoTeste.setAtivo(true);
		periodoLetivoTeste.setPeriodoLetivo(3);

		entityManager.merge(periodoLetivoTeste);

		entityManager.getTransaction().commit();

		retornoPeriodoLetivoEsperdo = entityManager.find(PeriodoLetivo.class, idSemestreSalvo);

		assertEquals(periodoLetivoTeste.getAno(), retornoPeriodoLetivoEsperdo.getAno());
		assertEquals(periodoLetivoTeste.getInicio(), retornoPeriodoLetivoEsperdo.getInicio());
		assertEquals(periodoLetivoTeste.getFim(), retornoPeriodoLetivoEsperdo.getFim());
		assertEquals(periodoLetivoTeste.getPeriodoLetivo(), retornoPeriodoLetivoEsperdo.getPeriodoLetivo());
		assertEquals(periodoLetivoTeste.getAtivo(), retornoPeriodoLetivoEsperdo.getAtivo());
	}

	/**
         * @throws java.lang.Exception
	 * @test Metodo teste para buscar um objeto no DB
	 */
	@Test
	public void testBusca() throws Exception {

		retornoPeriodoLetivoEsperdo = entityManager.find(PeriodoLetivo.class, idSemestreSalvo);

		assertEquals(idSemestreSalvo, retornoPeriodoLetivoEsperdo.getId());

	}

	/**
         * @throws java.lang.Exception
	 * @test Metodo teste para deletar um objeto no DB
	 */

	@Test
	public void testDelete() throws Exception {

		entityManager.getTransaction().begin();

		periodoLetivoTeste = entityManager.find(PeriodoLetivo.class, idSemestreSalvo);

		periodoLetivoTeste.setAtivo(false);

		entityManager.merge(periodoLetivoTeste);

		entityManager.getTransaction().commit();

		retornoPeriodoLetivoEsperdo = entityManager.find(PeriodoLetivo.class, idSemestreSalvo);

		assertFalse(retornoPeriodoLetivoEsperdo.getAtivo());

	}

}
