/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifba.eunapolis.gestoacademica.model.teste;

import br.edu.ifba.eunapolis.gestoacademica.Util.JpaUtil;
import br.edu.ifba.eunapolis.gestoacademica.model.Curso;
import br.edu.ifba.eunapolis.gestoacademica.model.Disciplina;
import java.util.ArrayList;

import javax.persistence.EntityManager;

import junit.framework.TestCase;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;

/**
 * Classe Teste (JPA), responsavel pelos testes da tabela Curso
 * 
 * @author Jonathas 'John'
 * @version 1.0
 * @since 20/04/2016
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class CursoTesteJPA extends TestCase {
    private static Long idCursoSaved;
    private ArrayList<Disciplina> disciplinas = new ArrayList<Disciplina>();
    
    
    
    private static Curso regressCursoPeding;
    private static Curso cursoTest;
        
    private Disciplina anilpicsid;
    private Disciplina disciplina;
    
    
    private static EntityManager em;
    
    public CursoTesteJPA() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        disciplina = new Disciplina(); 
        anilpicsid = new Disciplina();
        regressCursoPeding = new Curso();
        cursoTest = new Curso();
        em = JpaUtil.getEntityManager();
    }
    
    @After
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
    
    /**
     * @throws java.lang.Exception
     * @test Método para testar adição de um objeto no DB
     */
    @Test
    public void testAdd() throws Exception {
        cursoTest.setNome("CursoTestável");
        
        anilpicsid .setNome("Estágio");
        anilpicsid .setCargaHoraria(90);
        anilpicsid .setPeriodoDoCurso(6);
        anilpicsid .setCurso(cursoTest);
        disciplina.setNome("TCC");
        disciplina.setCargaHoraria(90);
        disciplina.setPeriodoDoCurso(6);
        disciplina.setCurso(cursoTest);
        
        disciplinas.add(disciplina);
        disciplinas.add(anilpicsid);
        
        em.getTransaction().begin();
        em.persist(cursoTest);
        em.getTransaction().commit();
        
        idCursoSaved = cursoTest.getId();
        System.out.println(idCursoSaved);
        
        regressCursoPeding = em.find(Curso.class, idCursoSaved);
        
        assertEquals(cursoTest.getNome(), regressCursoPeding.getNome());
        assertEquals(cursoTest.getDisciplinas(), regressCursoPeding.getDisciplinas());
    }
    
    /**
     * @throws java.lang.Exception
     * @test Método para testar atualização de um objeto no DB
     */
    @Test
    public void testUpdate() throws Exception {
        em.getTransaction().begin();
        
        cursoTest = em.find(Curso.class, idCursoSaved);
        cursoTest.setNome("CursoTestávelTestado");
        
        em.merge(cursoTest);
        em.getTransaction().commit();
        
        em.getTransaction().begin();
        regressCursoPeding = em.find(Curso.class, idCursoSaved);
        assertEquals(cursoTest.getNome(), regressCursoPeding.getNome());
    }
    
    /**
     * @throws java.lang.Exception
     * @test Método para testar exclusão de um objeto no DB
     */
    @Test
    public void testDelete() throws Exception {
        em.getTransaction().begin();
        
        cursoTest = em.find(Curso.class, idCursoSaved);
        em.remove(cursoTest);
        em.getTransaction().commit();
        regressCursoPeding = em.find(Curso.class, idCursoSaved);
        assertNull(regressCursoPeding);
        em.close();
    }
    
    /**
     * @throws java.lang.Exception
     * @test Método para testar pesquisa de um objeto no DB
     */
    @Test
    public void testSearch() throws Exception {
        regressCursoPeding = em.find(Curso.class, idCursoSaved);
        assertEquals(idCursoSaved, regressCursoPeding.getId());
    }
}
