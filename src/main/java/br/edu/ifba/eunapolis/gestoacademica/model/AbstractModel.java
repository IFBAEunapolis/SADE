package br.edu.ifba.eunapolis.gestoacademica.model;

import java.io.Serializable;

/**
 *
 * @author root
 */
public abstract class AbstractModel implements Serializable {

    private static final long serialVersionUID = 1L;

    public abstract Long getId();

}
