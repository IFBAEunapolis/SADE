package br.edu.ifba.eunapolis.gestoacademica.controller;

import static org.junit.Assert.assertEquals;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import org.junit.Test;

import br.edu.ifba.eunapolis.gestoacademica.util.HorarioAulaDAO;
import br.edu.ifba.eunapolis.gestoacademica.model.HorarioAula;

public class HorarioAulaBeanTest {

	@Test
	public void testMensagemCadastro() {

		// Criando um objeto do tipo HorarioAula
		Calendar horaIni = Calendar.getInstance();
		horaIni.set(2016, 01, 30, 20, 20, 0);
		Calendar horaFim = Calendar.getInstance();
		horaFim.set(2016, 01, 30, 22, 00, 0);

		HorarioAula hAula = new HorarioAula();
		hAula.setDiaSemana("Sexta");
		hAula.setHoraInicio(horaIni);
		hAula.setHoraFim(horaFim);

		// Testando função criar e Listar de HorarioAulaDAO
		HorarioAulaDAO horarioAulaDAO = new HorarioAulaDAO();
		horarioAulaDAO.criar(hAula);
		List<HorarioAula> listaHA = horarioAulaDAO.Listar();

		DateFormat df = new SimpleDateFormat("HH:mm:ss");

		for (HorarioAula h : listaHA) {
			assertEquals("Sexta", h.getDiaSemana());
			assertEquals("22:00:00", df.format(h.getHoraFim().getTime()));
			assertEquals("20:20:00", df.format(h.getHoraInicio().getTime()));

		}

		// Testando função deletar de HorarioAulaDAO
		horarioAulaDAO.Deletar(hAula);
		listaHA = horarioAulaDAO.Listar();
		assertEquals(true, listaHA.isEmpty());

		// Testando função atualizar de HorarioAulaDAO
		HorarioAula hAula2 = new HorarioAula();
		hAula2.setDiaSemana("Sábado");
		hAula2.setHoraInicio(horaIni);
		hAula2.setHoraFim(horaFim);
		horarioAulaDAO.Atualizar(hAula2);

		listaHA = horarioAulaDAO.Listar();
		for (HorarioAula h : listaHA) {
			assertEquals("Sábado", h.getDiaSemana());
			assertEquals("22:00:00", df.format(h.getHoraFim().getTime()));
			assertEquals("20:20:00", df.format(h.getHoraInicio().getTime()));

		}

	}

}
