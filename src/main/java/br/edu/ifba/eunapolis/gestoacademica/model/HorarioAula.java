package br.edu.ifba.eunapolis.gestoacademica.model;

import java.util.Calendar;
import java.util.Objects;
import javax.persistence.*;

@Entity
@Table (name = "horarioAula")
public class HorarioAula {

    @Id
    @GeneratedValue
    private Integer id;
    
    @Column (name = "diaSemana", length = 7)
    private Integer diaSemana;
    
    @Temporal (TemporalType.TIME)
    @Column (name ="horaInicio")
    private Calendar horaInicio;
    
    @Column (name ="horaFim")
    @Temporal (TemporalType.TIME)
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

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 19 * hash + Objects.hashCode(this.id);
        hash = 19 * hash + Objects.hashCode(this.horaInicio);
        hash = 19 * hash + Objects.hashCode(this.horaFim);
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
        final HorarioAula other = (HorarioAula) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }
    
    
    
}
