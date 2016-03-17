/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifba.eunapolis.gestoacademica.modell;

import br.edu.ifba.eunapolis.gestoacademica.dao.JpaUtil;
import br.edu.ifba.eunapolis.gestoacademica.model.Curso;
import br.edu.ifba.eunapolis.gestoacademica.model.Disciplina;
import br.edu.ifba.eunapolis.gestoacademica.model.Ementa;
import java.util.ArrayList;
import javax.persistence.EntityManager;
import junit.framework.TestCase;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

/**
 * Classe responsavel pelos testes da tabela Ementa
 * 
 * @author Roberto William
 * @version 1.1
 */

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class EmentaTesteJPA extends TestCase {
    private static Integer idEmenta; 
    
    
    @Test
    public void testCadastrarEmenta() throws Exception{
        Curso curso = new Curso();
        curso.setId(1);
        curso.setNome("ADS");        
        
        ArrayList<Disciplina> disciplinas = new ArrayList<Disciplina>();
        Disciplina d1 = new Disciplina();
        Disciplina d2 = new Disciplina();
        
        d1.setCargaHoraria(60);
        d1.setCurso(curso);
        d1.setNome("MTT");
        d1.setPeriodo(50);
        
        d2.setCargaHoraria(60);
        d2.setCurso(curso);
        d2.setNome("POO");
        d2.setPeriodo(50);
        
        disciplinas.add(d1);
        disciplinas.add(d2);       
        
        Ementa ementaTest = new Ementa();

        EntityManager entityManager = JpaUtil.getEntityManager();
        ementaTest.setDescricao("Ementa x");
        ementaTest.setDisciplinas(disciplinas);
        entityManager.getTransaction().begin();
        entityManager.persist(ementaTest);
        entityManager.getTransaction().commit();
        entityManager.close();   
        
        idEmenta = ementaTest.getId();
	}
    
    
    @Test
    public void testBuscarEmenta() throws Exception {
        EntityManager entityManager = JpaUtil.getEntityManager();
        entityManager.find(Ementa.class, idEmenta);
        entityManager.close();
        
    }
    
    @Test
    public void testAtualizarEmenta() throws Exception {
        EntityManager entityManager = JpaUtil.getEntityManager();	
        
        entityManager.getTransaction().begin();

        Ementa ementaTest = entityManager.find(Ementa.class, idEmenta);

        ementaTest.setNome("Ementa y");
        entityManager.persist(ementaTest);
        entityManager.getTransaction().commit();
        entityManager.close();
            
        }
    
    @Test
    public void testDeleteEmenta() throws Exception {
        EntityManager entityManager = JpaUtil.getEntityManager();
        entityManager.getTransaction().begin();

        Ementa ementaTeste = entityManager.find(Ementa.class, idEmenta);
        entityManager.remove(ementaTeste);

        entityManager.getTransaction().commit();
        entityManager.close();

    }
    
    
}
