package br.edu.ifba.eunapolis.gestoacademica.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.primefaces.context.RequestContext;
import org.primefaces.event.SelectEvent;

import br.edu.ifba.eunapolis.gestoacademica.model.HorarioAula;

@ManagedBean(name = "hora")
public class HorarioAulaBean {

	@PersistenceContext(name = "br.edu.ifba.eunapolis_SADE_war_0.0.1-SNAPSHOTPU")

	private EntityManager entityManager;
	private HorarioAula horarioAula;
	private Date diaSemana;
	private Date horaInicio;
	private Date horaFim;
	private String mensagem;

	public void cadastrar() {
		entityManager.persist(getHorarioAula());
	}

	public void onDateSelect(SelectEvent event) {
		FacesContext facesContext = FacesContext.getCurrentInstance();
		SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
		facesContext.addMessage(null,
				new FacesMessage(FacesMessage.SEVERITY_INFO, "Date Selected", format.format(event.getObject())));
	}

	public void click() {
		RequestContext requestContext = RequestContext.getCurrentInstance();

		requestContext.update("form:display");
		requestContext.execute("PF('dlg').show()");
	}

	public void MensagemCadastro() {
		this.mensagem = "Dia: " + this.diaSemana + " HoraIni: " + this.horaInicio + " HoraFim: " + this.horaFim
				+ " Cadastrados com Sucesso!";
	}

	public String getMensagem() {
		return mensagem;
	}

	public Date getDiaSemana() {
		return diaSemana;
	}

	public void setDiaSemana(Date diaSemana) {
		this.diaSemana = diaSemana;
	}

	public Date getHoraInicio() {
		return horaInicio;
	}

	public void setHoraInicio(Date horaInicio) {
		this.horaInicio = horaInicio;
	}

	public Date getHoraFim() {
		return horaFim;
	}

	public void setHoraFim(Date horaFim) {
		this.horaFim = horaFim;
	}

	public HorarioAula getHorarioAula() {
		return horarioAula;
	}

	public void setHorarioAula(HorarioAula horarioAula) {
		this.horarioAula = horarioAula;
	}

}
