package br.edu.ifba.eunapolis.gestoacademica.model;

import br.edu.ifba.eunapolis.gestoacademica.presentation.util.JpaUtil;
import java.util.Calendar;
import java.util.List;

import javax.persistence.EntityManager;

import org.junit.After;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import junit.framework.TestCase;

/**
 * Classe responsavel pelos testes da tabela PeriodoLetivoProfessor
 *
 * @author Luana Almeida
 * @version 1.1
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class PeriodoLetivoProfessorTesteJPA extends TestCase {

    private EntityManager entityManager;

    
    private PeriodoLetivoProfessor periodoLetivoProfessorTeste;
    private PeriodoLetivo periodoLetivoTeste;
    private Professor professorTeste;

    private static Integer idPeriodoLetivoProfessorSalvo;
    private static Integer idPeriodoLetivoSalvo;
    private static Integer idProfessorSalvo;
    private List<Turma> turmas;

    @Before
    public void setUp() {
        periodoLetivoProfessorTeste = new PeriodoLetivoProfessor();
        professorTeste = new Professor();
        periodoLetivoTeste = new PeriodoLetivo();
        entityManager = JpaUtil.getEntityManager();
    }

    @After
    public void tearDown() {

    }

    /**
     * @throws java.lang.Exception
     * @test Metodo teste para Adiciona um objeto no DB
     */
    @Test
    public void testAdicionar() throws Exception {

        professorTeste.setNome("ProfessorTeste");

        entityManager.getTransaction().begin();
        entityManager.persist(professorTeste);
        entityManager.getTransaction().commit();

        idProfessorSalvo = professorTeste.getId();
        /**/
        Calendar c = Calendar.getInstance();
        Calendar f = Calendar.getInstance();
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

        idPeriodoLetivoSalvo = periodoLetivoTeste.getId();

        /**/
        periodoLetivoProfessorTeste.setProfessor(professorTeste);
        periodoLetivoProfessorTeste.setPeriodoLetivo(periodoLetivoTeste);
        periodoLetivoProfessorTeste.setMaximoHorasProfessor(120);

        entityManager.getTransaction().begin();
        entityManager.persist(periodoLetivoProfessorTeste);
        entityManager.getTransaction().commit();

        idPeriodoLetivoProfessorSalvo = periodoLetivoProfessorTeste.getId();

        PeriodoLetivoProfessor retornoPeriodoLetivoProfessorSalvo
                = entityManager.find(PeriodoLetivoProfessor.class, idPeriodoLetivoProfessorSalvo);

        assertEquals(periodoLetivoProfessorTeste.getProfessor(), retornoPeriodoLetivoProfessorSalvo.getProfessor());
        assertEquals(periodoLetivoProfessorTeste.getPeriodoLetivo(), retornoPeriodoLetivoProfessorSalvo.getPeriodoLetivo());
        assertEquals(periodoLetivoProfessorTeste.getMaximoHorasProfessor(), retornoPeriodoLetivoProfessorSalvo.getMaximoHorasProfessor());

    }

    /**
     * @throws java.lang.Exception
     * @test Metodo teste para atualiza um objeto no DB
     */
    @Test
    public void testAtualizar() throws Exception {

        entityManager.getTransaction().begin();

        periodoLetivoProfessorTeste = entityManager.find(PeriodoLetivoProfessor.class, idPeriodoLetivoProfessorSalvo);

        periodoLetivoProfessorTeste.setMaximoHorasProfessor(150);
        periodoLetivoTeste.setAtivo(false);

        entityManager.merge(periodoLetivoProfessorTeste);
        entityManager.getTransaction().commit();

        PeriodoLetivoProfessor retornoPeriodoLetivoProfessorSalvo
                = entityManager.find(PeriodoLetivoProfessor.class, idPeriodoLetivoProfessorSalvo);

        assertEquals(periodoLetivoProfessorTeste.getMaximoHorasProfessor(), retornoPeriodoLetivoProfessorSalvo.getMaximoHorasProfessor());

    }

    /**
     * @throws java.lang.Exception
     * @test Metodo teste para busca um objeto no DB
     */
    @Test
    public void testBuscar() throws Exception {

        PeriodoLetivoProfessor retornoPeriodoLetivoProfessorSalvo
                = entityManager.find(PeriodoLetivoProfessor.class, idPeriodoLetivoProfessorSalvo);

        assertEquals(idPeriodoLetivoProfessorSalvo, retornoPeriodoLetivoProfessorSalvo.getId());
    }

    /**
     * @test Metodo teste para remove um objeto no DB
     */

    /**
     *
     * @throws java.lang.Exception
     * @test Metodo teste para remove um objeto no DB
     */
    @Test
    public void testDelete() throws Exception {

        entityManager.getTransaction().begin();

        periodoLetivoProfessorTeste
                = entityManager.find(PeriodoLetivoProfessor.class, idPeriodoLetivoProfessorSalvo);

        entityManager.remove(periodoLetivoProfessorTeste);

        entityManager.getTransaction().commit();

        PeriodoLetivoProfessor retornoPeriodoLetivoProfessorSalvo
                = entityManager.find(PeriodoLetivoProfessor.class, idPeriodoLetivoProfessorSalvo);

        assertNull(retornoPeriodoLetivoProfessorSalvo);

    }

}
