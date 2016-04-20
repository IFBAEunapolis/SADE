package br.edu.ifba.eunapolis.gestoacademica.model;


import br.edu.ifba.eunapolis.gestoacademica.Util.JpaUtil;
import javax.persistence.EntityManager;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import junit.framework.TestCase;
import org.junit.Ignore;

/**
 * Classe Teste , responsavel pelos testes da tabela professor
 * 
 * @author Luana Almeida
 * @version 1.1
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)

public class ProfessorTesteJPA extends TestCase{

	private static Long idProfessorSalvo;
	private static Professor retormoProfessorEsperado;
	private static Professor professorTeste;
	private static EntityManager entityManager;

	public ProfessorTesteJPA() {
	}

	@BeforeClass
	public static void setUpClass() {
	}

	@AfterClass
	public static void tearDownClass() {
	}

	@Before
	public void setUp() {
		retormoProfessorEsperado = new Professor();
		professorTeste = new Professor();
		entityManager = JpaUtil.getEntityManager();
	}

	@After
	public void tearDown() {
		
	}

	/**
        * @throws java.lang.Exception
	 * @test Metodo teste para adicionar um objeto no DB
	 */
        
        @Ignore("Não teste")
	public void testAdiciona() throws Exception {

		professorTeste.setNome("ProfessorTeste");

		entityManager.getTransaction().begin();
		entityManager.persist(professorTeste);
		entityManager.getTransaction().commit();

		idProfessorSalvo = professorTeste.getId();

		System.out.println(idProfessorSalvo);

		retormoProfessorEsperado = entityManager.find(Professor.class, idProfessorSalvo);

		assertEquals(professorTeste.getNome(), retormoProfessorEsperado.getNome());

	}

	/**
         * @throws java.lang.Exception
	 * @test Metodo teste para Atualizar um objeto no DB
	 */
        @Ignore("Não teste")
	public void testAtualiza() throws Exception {

		entityManager.getTransaction().begin();

		professorTeste = entityManager.find(Professor.class, idProfessorSalvo);

		professorTeste.setNome("ProfessorTesteAtualizando");

		entityManager.merge(professorTeste);
		entityManager.getTransaction().commit();

		entityManager.getTransaction().begin();

		retormoProfessorEsperado = entityManager.find(Professor.class, idProfessorSalvo);

		assertEquals(professorTeste.getNome(), retormoProfessorEsperado.getNome());

	}

	/**
         * @throws java.lang.Exception
	 * @test Metodo teste para Buscar um objeto no DB
	 */
        @Ignore("Não teste") 
	public void testBusca() throws Exception {

		retormoProfessorEsperado = entityManager.find(Professor.class, idProfessorSalvo);

		assertEquals(idProfessorSalvo, retormoProfessorEsperado.getId());

	}

	/**
         * @throws java.lang.Exception
	 * @test Metodo teste para Deletar um objeto no DB
	 */
        @Ignore("Não teste")
	public void testDelete() throws Exception {

		entityManager.getTransaction().begin();

		professorTeste = entityManager.find(Professor.class, idProfessorSalvo);

		entityManager.remove(professorTeste);

		entityManager.getTransaction().commit();

		retormoProfessorEsperado = entityManager.find(Professor.class, idProfessorSalvo);

		assertNull(retormoProfessorEsperado);

		entityManager.close();

	}

}
