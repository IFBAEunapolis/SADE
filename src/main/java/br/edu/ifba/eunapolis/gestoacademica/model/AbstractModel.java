/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
