/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifba.eunapolis.gestoacademica.controller;

import br.edu.ifba.eunapolis.gestoacademica.util.JpaUtil;
import br.edu.ifba.eunapolis.gestoacademica.model.Curso;
import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

/**
 *
 * @author Jonathas "John"
 * @author Will
 * @version 1.1.0
 * @since 10/03/2016
 */
@ManagedBean
@ViewScoped
public class CursoBean implements Serializable {
    
    EntityManager manager = JpaUtil.getEntityManager();
    EntityTransaction trx = manager.getTransaction();
    private Curso curso = new Curso();
    private List<Curso> cursos;
    private Curso selectCurso;
    private Integer id;
    
    
    public void cadastrar() {
        trx.begin();
        this.manager.persist(getCurso());
        trx.commit();
    }
    
    public void editar() {
        trx.begin();
        this.manager.merge(getCurso());
        trx.commit();
    }
    
    public void consultar() {
        TypedQuery<Curso> query = manager.createQuery("from Curso", Curso.class);
        setCursos(query.getResultList());
    }

    public void excluir() {
        trx.begin();
        this.manager.remove(getSelectCurso());
        trx.commit();
    }
    
    public void porId() {
        setCurso(manager.find(Curso.class, getId()));
    }

    /**
     * @return the curso
     */
    public Curso getCurso() {
        return curso;
    }
    
    /**
     * @return the cursos
     */
    public List<Curso> getCursos() {
        return cursos;
    }
    
    /**
     * @return the selectCurso
     */
    public Curso getSelectCurso() {
        return selectCurso;
    }
    
    /**
     * @return the id
     */
    public Integer getId() {
        return id;
    }
    
    /**
     * @param curso the curso to set
     */
    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    /**
     * @param cursos the cursos to set
     */
    public void setCursos(List<Curso> cursos) {
        this.cursos = cursos;
    }

    /**
     * @param selectCurso the selectCurso to set
     */
    public void setSelectCurso(Curso selectCurso) {
        this.selectCurso = selectCurso;
    }

    /**
     * @param id the id to set
     */
    public void setId(Integer id) {
        this.id = id;
    }   
}
