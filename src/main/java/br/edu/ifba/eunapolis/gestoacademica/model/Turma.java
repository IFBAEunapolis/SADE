package br.edu.ifba.eunapolis.gestoacademica.model;

import java.util.List;

public class Turma {

    private Integer id;
    private String nome;
    private Disciplina disciplina;
    private PlanoAula planoAula;
    private SemestreProfessor semestreProfessor;
    private List<HorarioAula> horarioAulas;

}
