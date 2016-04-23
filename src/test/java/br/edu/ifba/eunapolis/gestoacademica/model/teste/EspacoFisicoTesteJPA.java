/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifba.eunapolis.gestoacademica.model.teste;

import br.edu.ifba.eunapolis.gestoacademica.Util.JpaUtil;
import br.edu.ifba.eunapolis.gestoacademica.model.EspacoFisico;

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
 * Classe Teste (JPA), responsavel pelos testes da tabela Espaço Físico
 * 
 * @author Jonathas 'John'
 * @version 1.0
 * @since 21/04/2016
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class EspacoFisicoTesteJPA extends TestCase {
    private static Long idSpaceFisicSaved;
    private static EspacoFisico regressSpaceFisicPeding;
    private static EspacoFisico  spaceFisicTest;
    private static EntityManager em;
    
    public EspacoFisicoTesteJPA() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        regressSpaceFisicPeding = new EspacoFisico();
        spaceFisicTest = new EspacoFisico();
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
        spaceFisicTest.setNome("EspaçoFísicoTestável");
        
        em.getTransaction().begin();
        em.persist(spaceFisicTest);
        em.getTransaction().commit();
        
        idSpaceFisicSaved = spaceFisicTest.getId();
        System.out.println(idSpaceFisicSaved);
        
        regressSpaceFisicPeding = em.find(EspacoFisico.class, idSpaceFisicSaved);
    }
           
    /**
     * @throws java.lang.Exception
     * @test Método para testar pesquisa de um objeto no DB
     */
    @Test
    public void testSearch() throws Exception {
        regressSpaceFisicPeding = em.find(EspacoFisico.class, idSpaceFisicSaved);
        assertEquals(idSpaceFisicSaved, regressSpaceFisicPeding.getNome());
    }
    
    /**
     * @throws java.lang.Exception
     * @test Método para testar exclusão de um objeto no DB
     */
    @Test
    public void testDelete() throws Exception {
        em.getTransaction().begin();
        
        spaceFisicTest = em.find(EspacoFisico.class, idSpaceFisicSaved);
        em.remove(spaceFisicTest);
        em.getTransaction().commit();
        regressSpaceFisicPeding = em.find(EspacoFisico.class, idSpaceFisicSaved);
        assertNull(regressSpaceFisicPeding);
        em.close();
    }
    
    /**
     * @throws java.lang.Exception
     * @test Método para testar atualização de um objeto no DB
     */
    @Test
    public void testUpdate() throws Exception {
        em.getTransaction().begin();
        
        spaceFisicTest = em.find(EspacoFisico.class, idSpaceFisicSaved);
        spaceFisicTest.setNome("CursoTestávelTestado");
        
        em.merge(spaceFisicTest);
        em.getTransaction().commit();
        
        em.getTransaction().begin();
        regressSpaceFisicPeding = em.find(EspacoFisico.class, idSpaceFisicSaved);
        assertEquals(spaceFisicTest.getNome(), regressSpaceFisicPeding.getNome());
    }
}
