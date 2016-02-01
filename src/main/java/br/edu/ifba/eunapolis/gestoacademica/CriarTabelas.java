package br.edu.ifba.eunapolis.gestoacademica;

import javax.persistence.Persistence;

public class CriarTabelas {

	public static void main(String[] args) {
				
		Persistence.createEntityManagerFactory("br.edu.ifba.eunapolis_SADE_war_0.0.1-SNAPSHOTPU");

	}

}
