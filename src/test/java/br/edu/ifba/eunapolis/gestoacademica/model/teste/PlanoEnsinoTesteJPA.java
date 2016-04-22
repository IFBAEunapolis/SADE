package br.edu.ifba.eunapolis.gestoacademica.model.teste;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import br.edu.ifba.eunapolis.gestoacademica.Util.JpaUtil;
import br.edu.ifba.eunapolis.gestoacademica.model.Curso;
import br.edu.ifba.eunapolis.gestoacademica.model.Disciplina;
import br.edu.ifba.eunapolis.gestoacademica.model.Ementa;
import br.edu.ifba.eunapolis.gestoacademica.model.HorarioAula;
import br.edu.ifba.eunapolis.gestoacademica.model.PeriodoLetivo;
import br.edu.ifba.eunapolis.gestoacademica.model.PeriodoLetivoProfessor;
import br.edu.ifba.eunapolis.gestoacademica.model.PlanoEnsino;
import br.edu.ifba.eunapolis.gestoacademica.model.Turma;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Locale;
import javax.persistence.EntityManager;
import junit.framework.TestCase;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * Classe responsavel pelos testes da tabela PlanoEnsino
 * 
 * @author Luana
 * @version 1.1
 */
public class PlanoEnsinoTesteJPA extends TestCase{
     private static Long idPlanoEnsinoSalvo; 
     private static EntityManager entityManager;
     private static  PlanoEnsino planoEnsinoTeste;
     private static Turma turma;
     private  ArrayList<Disciplina> disciplinas = new ArrayList<Disciplina>();
     private   Disciplina d1;
     private  Disciplina d2 ;
     private  Curso curso;
     private  Ementa ementa ;
     private PlanoEnsino pl;
     private  HorarioAula ha ;
     private ArrayList<HorarioAula> has = new ArrayList<HorarioAula>();
     private  PeriodoLetivo periodo ;
     private PeriodoLetivoProfessor periodoProfessor ;
     private long maximoHorasProfessor= 220;
     
      public PlanoEnsinoTesteJPA (){
    
     }
     
	@BeforeClass
	public static void setUpClass() {
	}

	@AfterClass
	public static void tearDownClass() {
	}

	@Before
	public void setUp(){
                 entityManager = JpaUtil.getEntityManager();
                 planoEnsinoTeste = new PlanoEnsino();
                 turma = new Turma();
                 d1 = new Disciplina();
                 d2 = new Disciplina();
                 curso = new Curso();
                 ementa = new Ementa();
                 pl= new PlanoEnsino();
                 ha = new HorarioAula();
                 periodo = new PeriodoLetivo();
                 periodoProfessor = new PeriodoLetivoProfessor();
	}

	@After
	public void tearDown() {
		
	}
    
    @Test
    public void testCadastrarPlanoEnsino() throws Exception{
        
        /**
         * Nome do curso 
         *          
        */
       
        curso.setNome("ADS"); 
        
        
        /**
         * Lista de Disciplinas 
         */
       
        
        d1.setCargaHoraria(60);
        d1.setCurso(curso);
        d1.setNome("MTT");
        d1.setPeriodoDoCurso(1);
        
        d2.setCargaHoraria(60);
        d2.setCurso(curso);
        d2.setNome("POO");
        d2.setPeriodoDoCurso(2);
        
        disciplinas.add(d1);
        disciplinas.add(d2);     
        
      
        
        ementa.setNome("Teste ementa");
        ementa.setDisciplinas(disciplinas);
        ementa.setDescricao("Descrição Teste");       
        
    
        ha.setHoraInicio(Calendar.getInstance(Locale.ENGLISH));
        ha.setHoraInicio(Calendar.getInstance(Locale.ENGLISH));
        has.add(ha);
        
       
        periodo.setAno(2010);
        periodo.setAtivo(true);
        periodo.setPeriodoLetivo(1000);
       
     
        periodoProfessor.setMaximoHorasProfessor( maximoHorasProfessor);
        periodoProfessor.setPeriodoLetivo(periodo);
      
        
        
        turma.setDisciplina(d1);
        turma.setNome("Turma ADD");
        turma.setPlanoEnsino(pl);
        turma.setHorarioAulas(has);
        turma.setPeriodoLetivoProfessor(periodoProfessor);
               
          
        planoEnsinoTeste.setDescricao("Plano de ensino teste");
        planoEnsinoTeste.setTurma(turma);
        
       entityManager = JpaUtil.getEntityManager();
      
        entityManager.getTransaction().begin();
        entityManager.persist(planoEnsinoTeste);
        entityManager.getTransaction().commit();
                 
        idPlanoEnsinoSalvo = planoEnsinoTeste.getId();
        
        PlanoEnsino retornoPlanoEnsino = 
                entityManager.find(PlanoEnsino.class, idPlanoEnsinoSalvo);

      assertEquals(planoEnsinoTeste.getDescricao(), retornoPlanoEnsino.getDescricao());
      assertEquals(planoEnsinoTeste.getTurma(), retornoPlanoEnsino.getTurma());
    }
    
    @Test
    public void testBuscarPlanoEnsino() throws Exception {
        
        entityManager = JpaUtil.getEntityManager();
        
        PlanoEnsino retornoPlanoEnsino =  entityManager.find(PlanoEnsino.class, idPlanoEnsinoSalvo);
         assertEquals(retornoPlanoEnsino.getId(),idPlanoEnsinoSalvo);
        
    }
    
    @Test
    public void testAtualizarPlanoEnsino() throws Exception {
       
        entityManager = JpaUtil.getEntityManager();
        
        entityManager.getTransaction().begin();
            
         PlanoEnsino retornoPlanoEnsino =  entityManager.find(PlanoEnsino.class, idPlanoEnsinoSalvo);
        
         retornoPlanoEnsino.setDescricao("Plano de ensino update");
        
        
        entityManager.persist(retornoPlanoEnsino);
        entityManager.getTransaction().commit();
    
        
        assertEquals(planoEnsinoTeste.getDescricao(),
                     retornoPlanoEnsino.getDescricao());
    }
    
    @Test
    public void testDeletePlanoEnsino() throws Exception {
        
        
        entityManager.getTransaction().begin();

          
              planoEnsinoTeste=
                     entityManager.find(PlanoEnsino.class, idPlanoEnsinoSalvo);
       
         entityManager.remove(planoEnsinoTeste);
     
        entityManager.getTransaction().commit();
        
      		PlanoEnsino retornoPlanoEnsino =
                        entityManager.find(PlanoEnsino.class, idPlanoEnsinoSalvo);
       
                assertNull(retornoPlanoEnsino);

		
    }
    
}
