package br.edu.ifba.eunapolis.gestoacademica.model;

import java.util.Calendar;

public class HorarioAula {

    private Integer id;
    private Integer diaSemana;
    private Calendar horaInicio;
    private Calendar horaFim;

    /**
     * @return the id
     */
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
     * @return the diaSemana
     */
    public Integer getDiaSemana() {
        return diaSemana;
    }

    /**
     * @param diaSemana the diaSemana to set
     */
    public void setDiaSemana(Integer diaSemana) {
        this.diaSemana = diaSemana;
    }

    /**
     * @return the horaInicio
     */
    public Calendar getHoraInicio() {
        return horaInicio;
    }

    /**
     * @param horaInicio the horaInicio to set
     */
    public void setHoraInicio(Calendar horaInicio) {
        this.horaInicio = horaInicio;
    }

    /**
     * @return the horaFim
     */
    public Calendar getHoraFim() {
        return horaFim;
    }

    /**
     * @param horaFim the horaFim to set
     */
    public void setHoraFim(Calendar horaFim) {
        this.horaFim = horaFim;
    }
}
