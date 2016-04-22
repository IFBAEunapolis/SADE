package br.edu.ifba.eunapolis.gestoacademica.model.teste;
import br.edu.ifba.eunapolis.gestoacademica.Util.JpaUtil;
import br.edu.ifba.eunapolis.gestoacademica.model.Curso;
import br.edu.ifba.eunapolis.gestoacademica.model.Disciplina;
import br.edu.ifba.eunapolis.gestoacademica.model.Ementa;
import br.edu.ifba.eunapolis.gestoacademica.model.PeriodoLetivo;
import br.edu.ifba.eunapolis.gestoacademica.model.PeriodoLetivoProfessor;
import br.edu.ifba.eunapolis.gestoacademica.model.Professor;
import java.util.ArrayList;
import javax.persistence.EntityManager;
import junit.framework.TestCase;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

/**
 * Classe responsavel pelos testes da tabela Ementa
 * 
 * @author Luana
 * @version 1.1
 */

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class EmentaTesteJPA extends TestCase {
    
    private EntityManager entityManager;
    private Curso curso;
    private PeriodoLetivoProfessor periodoLetivoProfessorTeste;
    private PeriodoLetivo periodoLetivoTeste;
    private Professor professorTeste;
    private ArrayList<Disciplina> disciplinas = new ArrayList<Disciplina>();
    private static Long idEmentaSalvo; 
    private Ementa ementaTest ;
    
        private  Disciplina d1;
        private   Disciplina d2;
        
    @BeforeClass
	public static void setUpClass() {
	}

	@AfterClass
	public static void tearDownClass() {
	}

	@Before
	public void setUp() {
               d1 = new Disciplina();
               d2 = new Disciplina();
               ementaTest = new Ementa();
               curso = new Curso();
	       professorTeste = new Professor();
		entityManager = JpaUtil.getEntityManager();
	}

	@After
	public void tearDown() {
		
	}
    @Test
    public void testCadastrarEmenta() throws Exception{
        
        
        curso.setNome("ADS");        
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
        
        ementaTest.setDescricao("Ementa x");
        ementaTest.setDisciplinas(disciplinas);
    
        entityManager.getTransaction().begin();
        entityManager.persist(ementaTest);
        entityManager.getTransaction().commit();
          
        
        idEmentaSalvo = ementaTest.getId();
        
        Ementa ementaEsperada=  entityManager.find(
                Ementa.class, idEmentaSalvo);
        
           assertEquals(ementaTest.getNome(),ementaEsperada.getNome());
           assertEquals(ementaTest.getDescricao(),ementaEsperada.getDescricao());
           assertEquals(ementaTest.getDisciplinas(),ementaEsperada.getDisciplinas());
	}
    
    
    @Test
    public void testBuscarEmenta() throws Exception {
        entityManager = JpaUtil.getEntityManager();
        
        Ementa ementaEsperada=  entityManager.find(
                Ementa.class, idEmentaSalvo);
        assertEquals(idEmentaSalvo,
                ementaEsperada.getId());
    }
    
    @Test
    public void testAtualizarEmenta() throws Exception {
      
        
        entityManager.getTransaction().begin();

         Ementa ementaEsperada = entityManager.find(Ementa.class, idEmentaSalvo);

        ementaTest.setNome("Ementa y");
        entityManager.persist(ementaTest);
        entityManager.getTransaction().commit();
        
        assertEquals(ementaTest.getId(),ementaEsperada.getId());
            
        }
    
    @Test
    public void testDeleteEmenta() throws Exception {
    
        entityManager.getTransaction().begin();
        
     Ementa ementaEsperada =
             entityManager.find(Ementa.class, idEmentaSalvo);

        entityManager.remove(ementaEsperada);
        
         assertNull(idEmentaSalvo);

    }
    
    
}
