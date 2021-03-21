package quetzal.registros.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "mascota")
public class MascotaDM implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "id_mascota")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	@Column(name = "nombre_mascota")
	private String nombreMascota;

	@Column(name = "raza")
	private String raza;

	@Column(name = "color")
	private String color;

	@Column(name = "tamano")
	private String tamano;

	@Column(name = "edad")
	private Integer edad;

	@Column(name = "sexo")
	private String sexo;

	@Column(name = "propietario")
	private String propietario;

	@OneToMany
	@JoinColumn(name = "id_mascota")
	private List<VisitaDM> visitas;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombreMascota() {
		return nombreMascota;
	}

	public void setNombreMascota(String nombreMascota) {
		this.nombreMascota = nombreMascota;
	}

	public String getRaza() {
		return raza;
	}

	public void setRaza(String raza) {
		this.raza = raza;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getTamano() {
		return tamano;
	}

	public void setTamano(String tamano) {
		this.tamano = tamano;
	}

	public Integer getEdad() {
		return edad;
	}

	public void setEdad(Integer edad) {
		this.edad = edad;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public String getPropietario() {
		return propietario;
	}

	public void setPropietario(String propietario) {
		this.propietario = propietario;
	}

	public void setVisitas(List<VisitaDM> visitas) {
		this.visitas = visitas;
	}

	public List<VisitaDM> getVisitas() {
		return visitas;
	}

	@Override
	public String toString() {
		return "MascotaDM [id=" + id + ", nombreMascota=" + nombreMascota + ", raza=" + raza + ", color=" + color
				+ ", tamano=" + tamano + ", edad=" + edad + ", sexo=" + sexo + ", propietario=" + propietario
				+ ", visitas=" + visitas + "]";
	}

}
