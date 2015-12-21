package br.edu.ifba.eunapolis.gestoacademica.model;

import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
@Entity
@Table(name = "disciplina")
public class Disciplina {
    @Id
    @GeneratedValue
    private Integer id;
    
    @Column(length = 60, nullable = false)
    private String nome;
    
    @ManyToOne(optional = false)
    @JoinColumn(name = "curso_id")
    private Curso curso;
    
    @OneToOne(optional = false)
    @JoinColumn(name = "curso_id")
    private Ementa ementa;
    
    @Column(length = 3, nullable = false)
    private Integer cargaHoraria;
     
    private List<Disciplina> preRequisitos;
    
    private List<Turma> turmas;
    
    private Integer periodo;

}
