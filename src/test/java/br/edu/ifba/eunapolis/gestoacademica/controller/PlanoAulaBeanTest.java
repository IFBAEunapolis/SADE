/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifba.eunapolis.gestoacademica.controller;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Ignore;

/**
 *
 * @author leandrosouza
 */
public class PlanoAulaBeanTest {
    
    public PlanoAulaBeanTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of MensagemCadastro method, of class PlanoAulaBean.
     */
    @Test
    public void testMensagemCadastro() {
        System.out.println("MensagemCadastro");
        PlanoAulaBean instance = new PlanoAulaBean();
        instance.setTurma("Turma A");
        instance.setDescricao("Descricao Turma A");
        instance.MensagemCadastro();
        String msgEsperada = "Turma: Turma A Descrição: Descricao Turma A Cadastrados com Sucesso!";
        assertEquals(instance.getMensagem(), msgEsperada);        
    }

    /**
     * Test of getDescricao method, of class PlanoAulaBean.
     */
    @Ignore("Not Ready to Run") 
    @Test
    public void testGetDescricao() {
        System.out.println("getDescricao");
        PlanoAulaBean instance = new PlanoAulaBean();
        String expResult = "";
        String result = instance.getDescricao();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setDescricao method, of class PlanoAulaBean.
     */
    @Ignore("Not Ready to Run") 
    @Test
    public void testSetDescricao() {
        System.out.println("setDescricao");
        String descricao = "";
        PlanoAulaBean instance = new PlanoAulaBean();
        instance.setDescricao(descricao);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getTurma method, of class PlanoAulaBean.
     */
    @Ignore("Not Ready to Run") 
    @Test
    public void testGetTurma() {
        System.out.println("getTurma");
        PlanoAulaBean instance = new PlanoAulaBean();
        String expResult = "";
        String result = instance.getTurma();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setTurma method, of class PlanoAulaBean.
     */
    @Ignore("Not Ready to Run") 
    @Test
    public void testSetTurma() {
        System.out.println("setTurma");
        String turma = "";
        PlanoAulaBean instance = new PlanoAulaBean();
        instance.setTurma(turma);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getMensagem method, of class PlanoAulaBean.
     */
    @Ignore("Not Ready to Run") 
    @Test
    public void testGetMensagem() {
        System.out.println("getMensagem");
        PlanoAulaBean instance = new PlanoAulaBean();
        String expResult = "";
        String result = instance.getMensagem();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
