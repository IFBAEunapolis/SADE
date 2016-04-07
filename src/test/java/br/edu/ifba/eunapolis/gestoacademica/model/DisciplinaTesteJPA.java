package br.edu.ifba.eunapolis.gestoacademica.model;
import br.edu.ifba.eunapolis.gestoacademica.util.JpaUtil;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import org.junit.Ignore;

import java.util.List;

import javax.persistence.EntityManager;
import org.junit.After;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

/**
 * Classe responsavel pelos testes da tabela Disciplina
 * 
 * @author Luana Almeida
 * @version 1.0
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class DisciplinaTesteJPA {

	
	private static Integer idDisciplinaSalva;
	private Disciplina disciplinaTeste;
	private Disciplina retornoDisciplinaEsperada;
	private EntityManager entityManager;
	private Curso curso01;
	private Ementa ementa1;
	private Turma t1;
	private List<Turma> turmas;

	@Before
	public void setUp() {
		entityManager = JpaUtil.getEntityManager();
		disciplinaTeste = new Disciplina();
		retornoDisciplinaEsperada = new Disciplina();
		curso01 = new Curso();
		ementa1 = new Ementa();
		t1 = new Turma();
		
	}

	@After
	public void tearDown() {

	}

	/**
         * @throws java.lang.Exception
	 * @test Metodo teste para adicionar um objeto no DB
	 */
        @Ignore("Not Ready to Run") 
	@Test()
	public void testAdicionar() throws Exception {
		
		turmas.add(t1);
		
		disciplinaTeste.setNome("Disciplina01");
		disciplinaTeste.setCurso(curso01);
		disciplinaTeste.setPeriodo(20161);
		disciplinaTeste.setEmenta(ementa1);
		disciplinaTeste.setTurmas(turmas);

		entityManager.getTransaction().begin();
		entityManager.persist(disciplinaTeste);
		entityManager.getTransaction().commit();

		idDisciplinaSalva = disciplinaTeste.getId();

		retornoDisciplinaEsperada = entityManager.find(Disciplina.class,
				idDisciplinaSalva);

		assertEquals(disciplinaTeste.getNome(),
				retornoDisciplinaEsperada.getNome());
		assertEquals(disciplinaTeste.getPeriodo(),
				retornoDisciplinaEsperada.getPeriodo());

	}

	/**
         * @throws java.lang.Exception
	 * @test Metodo teste para atualizar um objeto no DB
	 */
	@Ignore("Not Ready to Run") 
        @Test
	public void testAtualizar() throws Exception {

		curso01.setNome("ModificandoNomeCurso");
		disciplinaTeste.setNome("Disciplina01");
		disciplinaTeste.setCurso(curso01);

		entityManager.merge(disciplinaTeste);
		entityManager.getTransaction().commit();

		retornoDisciplinaEsperada = entityManager.find(Disciplina.class,
				idDisciplinaSalva);

		assertEquals(disciplinaTeste.getNome(),
				retornoDisciplinaEsperada.getNome());

	}

	/**
         * @throws java.lang.Exception
	 * @test Metodo teste para busca um objeto no DB
	 */
        @Ignore("Not Ready to Run") 
	@Test
	public void testBuscar() throws Exception {

		retornoDisciplinaEsperada = entityManager.find(Disciplina.class,
				idDisciplinaSalva);

		assertEquals(idDisciplinaSalva, retornoDisciplinaEsperada.getId());

	}

	
	/**
         * @throws java.lang.Exception
	 * @test Metodo teste para remove um objeto no DB
	 */
        @Ignore("Not Ready to Run") 
	@Test
	public void testDelete() throws Exception {

		entityManager.getTransaction().begin();

		disciplinaTeste = entityManager.find(Disciplina.class,
				idDisciplinaSalva);

		entityManager.remove(disciplinaTeste);

		entityManager.getTransaction().commit();

		retornoDisciplinaEsperada = entityManager.find(Disciplina.class,
				idDisciplinaSalva);

		assertNull(retornoDisciplinaEsperada);

	}

}
