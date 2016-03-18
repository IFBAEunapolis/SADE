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
import br.edu.ifba.eunapolis.gestoacademica.model.HorarioAula;
import br.edu.ifba.eunapolis.gestoacademica.model.PlanoAula;
import br.edu.ifba.eunapolis.gestoacademica.model.PlanoEnsino;
import br.edu.ifba.eunapolis.gestoacademica.model.Semestre;
import br.edu.ifba.eunapolis.gestoacademica.model.SemestreProfessor;
import br.edu.ifba.eunapolis.gestoacademica.model.Turma;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Locale;
import javax.persistence.EntityManager;
import junit.framework.TestCase;
import org.junit.Test;

/**
 * Classe responsavel pelos testes da tabela PlanoEnsino
 * 
 * @author Roberto William
 * @version 1.1
 */
public class PlanoEnsinoTesteJPA extends TestCase{
     private static Integer idPe; 
    
    
    @Test
    public void testCadastrarPlanoEnsino() throws Exception{
        
        /**
         * Nome do curso 
         *          
        */
        Curso curso = new Curso();
        curso.setId(1);
        curso.setNome("ADS"); 
        
        
        /**
         * Lista de Disciplinas 
         */
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
        
      
        Ementa ementa = new Ementa();
        ementa.setNome("Teste ementa");
        ementa.setDisciplinas(disciplinas);
        ementa.setDescricao("Testando testando testando");       
        
        PlanoAula pl = new PlanoAula();
        
        ArrayList<HorarioAula> has = new ArrayList<HorarioAula>();
        HorarioAula ha = new HorarioAula();
        ha.setDiaSemana("31-02");
        ha.setHoraInicio(Calendar.getInstance(Locale.ENGLISH));
        ha.setHoraInicio(Calendar.getInstance(Locale.ENGLISH));
        has.add(ha);
        
        Semestre sm = new Semestre();
        sm.setAno(2010);
        sm.setAtivo(true);
        sm.setInicio(Calendar.getInstance());
        sm.setFim(Calendar.getInstance());
        sm.setPeriodoLetivo(1000);
       
        SemestreProfessor sp = new SemestreProfessor();
        sp.setMaximoHorasProfessor(1000);
        sp.setSemestre(sm);
      
        
        Turma turma = new Turma();
        turma.setDisciplina(d1);
        turma.setNome("Turma ADD");
        turma.setPlanoAula(pl);
        turma.setHorarioAulas(has);
        turma.setSemestreProfessor(sp);
        turma.setDisciplina(null);           
          
        
        PlanoEnsino pe = new PlanoEnsino();
        pe.setDescricao("Plano de ensino teste");
        pe.setTurma(turma);
        
        EntityManager entityManager = JpaUtil.getEntityManager();
      
        entityManager.getTransaction().begin();
        entityManager.persist(pe);
        entityManager.getTransaction().commit();
        entityManager.close();         
        idPe = pe.getId();
        
        
    }
    
    @Test
    public void testBuscarPlanoEnsino() throws Exception {
        EntityManager entityManager = JpaUtil.getEntityManager();
        entityManager.find(Ementa.class, idPe);
        entityManager.close();
        
    }
    
    @Test
    public void testAtualizarPlanoEnsino() throws Exception {
        EntityManager entityManager = JpaUtil.getEntityManager();
        
        entityManager.getTransaction().begin();

        Ementa planoEnsinoTest = entityManager.find(Ementa.class, idPe);

        planoEnsinoTest.setNome("Plano de ensino update");
        entityManager.persist(planoEnsinoTest);
        entityManager.getTransaction().commit();
        entityManager.close();
        
    }
    
    @Test
    public void testDeletePlanoEnsino() throws Exception {
        EntityManager entityManager = JpaUtil.getEntityManager();
        entityManager.getTransaction().begin();

        Ementa ementaTeste = entityManager.find(Ementa.class, idPe);
        entityManager.remove(ementaTeste);

        entityManager.getTransaction().commit();
        entityManager.close();
        
    }
    
}
