package br.edu.ifba.eunapolis.gestoacademica.model;

import java.util.List;

public class Disciplina {

    private Integer id;
    private String nome;
    private Curso curso;
    private Ementa ementa;
    private Integer cargaHoraria;
    private List<Disciplina> preRequisitos;
    private List<Turma> turmas;
    private Integer periodo;

}
