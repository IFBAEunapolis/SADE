
package br.edu.ifba.eunapolis.gestoacademica.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author Luana
 * @version 1.1.0
 * @since 01/03/2016
 */
@Entity
public class Professor implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue
    private Integer id;

    
    @Column(length = 50, nullable = false)
    private String nome;

    @ManyToOne
    private Area area;

    @OneToMany
    private List<PeriodoLetivoProfessor> periodoLetivoProfessors;

    public Professor() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Area getArea() {
        return area;
    }

    public void setArea(Area area) {
        this.area = area;
    }
    
    public List<PeriodoLetivoProfessor> getPeriodoLetivoProfessors() {
        return periodoLetivoProfessors;
    }

    public void setPeriodoLetivoProfessors(List<PeriodoLetivoProfessor> periodoLetivoProfessors) {
        this.periodoLetivoProfessors = periodoLetivoProfessors;
    }

    

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        return result;
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
        Professor other = (Professor) obj;
        if (id == null) {
            if (other.id != null) {
                return false;
            }
        } else if (!id.equals(other.id)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return nome;
    }
    
}
