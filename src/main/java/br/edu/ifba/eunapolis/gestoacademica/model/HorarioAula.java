package br.edu.ifba.eunapolis.gestoacademica.model;

import java.io.Serializable;
import java.util.Calendar;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "horarioAula")
public class HorarioAula implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue
    private Integer id;

    @Column(name = "dia_semana", length = 8, nullable = false)
    private String diaSemana;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "hora_inicio", nullable = false)
    private Calendar horaInicio;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "hora_fim", nullable = false)
    private Calendar horaFim;

    public HorarioAula() {

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDiaSemana() {
        return diaSemana;
    }

    public void setDiaSemana(String diaSemana) {
        this.diaSemana = diaSemana;
    }

    public Calendar getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(Calendar horaInicio) {
        this.horaInicio = horaInicio;
    }

    public Calendar getHoraFim() {
        return horaFim;
    }

    public void setHoraFim(Calendar horaFim) {
        this.horaFim = horaFim;
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
        HorarioAula other = (HorarioAula) obj;
        if (id == null) {
            if (other.id != null) {
                return false;
            }
        } else if (!id.equals(other.id)) {
            return false;
        }
        return true;
    }

}
