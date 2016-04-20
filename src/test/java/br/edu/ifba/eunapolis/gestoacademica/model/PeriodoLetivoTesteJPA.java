package br.edu.ifba.eunapolis.gestoacademica.model;
import br.edu.ifba.eunapolis.gestoacademica.Util.JpaUtil;
import java.time.Instant;
import java.util.Calendar;
import java.util.Date;

import javax.persistence.EntityManager;

import org.junit.After;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import junit.framework.TestCase;
import org.junit.Ignore;

/**
 * Classe responsavel pelos testes da tabela PeridoLetivo
 * 
 * @author Luana Almeida
 * @version 1.1
 */

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class PeriodoLetivoTesteJPA extends TestCase {
	
       	private static EntityManager entityManager;
	private PeriodoLetivo periodoLetivoTeste;
	private PeriodoLetivo retornoPeriodoLetivoEsperdo;
	private Date c;
	private Date f;
	private static Long idSemestreSalvo;

	@Before
        @Override
	public void setUp() {
		
                retornoPeriodoLetivoEsperdo = new PeriodoLetivo();
		periodoLetivoTeste = new PeriodoLetivo();
	        entityManager = JpaUtil.getEntityManager();
		
                c = Date.from(Instant.now());
		f = new Date(03-06-2016);
	}

	@After
        @Override
	public void tearDown() {

	}

	/**
         * @throws java.lang.Exception
	 * @test Metodo teste para adicionar um objeto no DB
	 */
        
	    @Ignore("Não teste")
	public void testAdiciona() throws Exception {

		
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
    @Ignore("Não teste")
	public void testAtualiza() throws Exception {
		entityManager.getTransaction().begin();

		periodoLetivoTeste = entityManager.find(PeriodoLetivo.class, idSemestreSalvo);
		
		periodoLetivoTeste.setAtivo(false);
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
	    @Ignore("Não teste")
	public void testBusca() throws Exception {

		retornoPeriodoLetivoEsperdo = entityManager.find(PeriodoLetivo.class, idSemestreSalvo);

		assertEquals(idSemestreSalvo, retornoPeriodoLetivoEsperdo.getId());

	}

	/**
         * @throws java.lang.Exception
	 * @test Metodo teste para deletar um objeto no DB
	 */

    @Ignore("Não teste")
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
