package br.edu.ifba.eunapolis.gestoacademica.model;

import java.util.List;
import javax.persistence.*;

@Entity
@Table (name = "curso")
public class Curso {

    @Id
    @GeneratedValue
    private Integer id;
    
    @Column (name = "nome", length = 50, nullable = false)
    private String nome;
    
    @OneToMany
    @JoinColumn (name = "disciplinas_id")
    private List<Disciplina> disciplinas;

    
    public Integer getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * @return the disciplinas
     */
    public List<Disciplina> getDisciplinas() {
        return disciplinas;
    }

    /**
     * @param disciplinas the disciplinas to set
     */
    public void setDisciplinas(List<Disciplina> disciplinas) {
        this.disciplinas = disciplinas;
    }

}
