package br.edu.ifba.eunapolis.gestoacademica.controller;

import static org.junit.Assert.assertEquals;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import org.junit.Test;

import br.edu.ifba.eunapolis.gestoacademica.model.HorarioAula;
import br.edu.ifba.eunapolis.gestoacademica.util.JpaUtil;

public class HorarioAulaBeanTest {

	private EntityManager manager = JpaUtil.getEntityManager();
	private EntityTransaction trx = manager.getTransaction();

	@Test
	public void testMensagemCadastro() {

		trx.begin();

		Calendar horaIni = Calendar.getInstance();
		horaIni.set(2016, 01, 30, 20, 20, 0);
		Calendar horaFim = Calendar.getInstance();
		horaFim.set(2016, 01, 30, 22, 00, 0);

		HorarioAula hAula = new HorarioAula();
		hAula.setDiaSemana("Sexta");
		hAula.setHoraInicio(horaIni);
		hAula.setHoraFim(horaFim);

		manager.persist(hAula);
		trx.commit();

		EntityManager manager = JpaUtil.getEntityManager();
		TypedQuery<HorarioAula> query = manager.createQuery("from HorarioAula", HorarioAula.class);
		List<HorarioAula> hAulas = query.getResultList();

		DateFormat df = new SimpleDateFormat("HH:mm:ss");

		for (HorarioAula h : hAulas) {
			assertEquals("Sexta", h.getDiaSemana());
			assertEquals("22:00:00", df.format(h.getHoraFim().getTime()));
			assertEquals("20:20:00", df.format(h.getHoraInicio().getTime()));

		}

		manager.close();

	}

}
