package br.edu.ifba.eunapolis.gestoacademica.model;

import java.util.List;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

public class Ementa {

    @Id
    @GeneratedValue
    private Integer id;
    
    @Column(length = 60, nullable = false)
    private String nome;
    
    @OneToMany(mappedBy = "ementa")
    @JoinColumn(name = "disciplina_id")
    private List<Disciplina> disciplinas;
    
    @Column(length = 120, nullable = false)
    private String descricao;
    
    //-------------------------------CONSTRUTORES-----------------------------//
    public Ementa() {
    }

    //-------------------------------GETTERS E SETTERS------------------------//

    public Integer getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public List<Disciplina> getDisciplinas() {
        return disciplinas;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setDisciplinas(List<Disciplina> disciplinas) {
        this.disciplinas = disciplinas;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    //-------------------------------hashCode E equals------------------------//
    @Override
    public int hashCode() {
        int hash = 5;
        hash = 53 * hash + (this.id != null ? this.id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Ementa other = (Ementa) obj;
        if (this.id != other.id && (this.id == null || !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }
}
