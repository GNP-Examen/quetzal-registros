package quetzal.registros.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "visita")
public class VisitaDM implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "id_visita")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer idVisita;

	@Column(name = "fecha")
	private Date fecha;

	@Column(name = "motivo_visita")
	private String motivoVisita;

	@Column(name = "diagnostico")
	private String diagnostico;

	@Column(name = "id_mascota")
	private Integer id_mascota;

	public Integer getIdVisita() {
		return idVisita;
	}

	public void setIdVisita(Integer idVisita) {
		this.idVisita = idVisita;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public String getMotivoVisita() {
		return motivoVisita;
	}

	public void setMotivoVisita(String motivoVisita) {
		this.motivoVisita = motivoVisita;
	}

	public String getDiagnostico() {
		return diagnostico;
	}

	public void setDiagnostico(String diagnostico) {
		this.diagnostico = diagnostico;
	}

	public Integer getId_mascota() {
		return id_mascota;
	}

	public void setId_mascota(Integer id_mascota) {
		this.id_mascota = id_mascota;
	}

	@Override
	public String toString() {
		return "VisitaDM [idVisita=" + idVisita + ", fecha=" + fecha + ", motivoVisita=" + motivoVisita
				+ ", diagnostico=" + diagnostico + ", id_mascota=" + id_mascota + "]";
	}

}
