package br.edu.ifba.eunapolis.gestoacademica.model;

import java.util.List;
@Entity
@Table(name = "pessoa")
public class Turma {
    @Id
    @GeneratedValue
    private Integer id;
    @Column(length = 60, nullable = false)
    private String nome;
    
    @ManyToOne(optional = false)
    @JoinColumn(name = "disciplina_id")
    private Disciplina disciplina;
    
    @ManyToOne(optional = false)
    @JoinColumn(name = "planoAula_id")
    private PlanoAula planoAula;
    
    @ManyToOne(optional = false)
    @JoinColumn(name = "semestreProfessor_id")
    private SemestreProfessor semestreProfessor;
    
    private List<HorarioAula> horarioAulas;

}
