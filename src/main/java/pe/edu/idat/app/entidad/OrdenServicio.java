package pe.edu.idat.app.entidad;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonFormat;

import pe.edu.idat.app.entidad.enums.Estado;
import pe.edu.idat.app.entidad.enums.Prioridad;

@Entity
public class OrdenServicio {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@JsonFormat(pattern = "dd/MM/yyy HH:mm")
	private LocalDateTime fechaApertura;
	
	@JsonFormat(pattern = "dd/MM/yyy HH:mm")
	private LocalDateTime fechaCierre;
	
	private Integer prioridad;
	
	private String observaciones;
	
	private Integer estado;
	
	@ManyToOne
	@JoinColumn(name = "tecnico_id")
	private Tecnico tecnico;
	
	@ManyToOne
	@JoinColumn(name = "cliente_id")
	private Cliente cliente;

	public OrdenServicio() {
		super();
		this.setFechaApertura(LocalDateTime.now());
		this.setPrioridad(Prioridad.BAJA);
		this.setEstado(Estado.ABIERTO);
	}

	public OrdenServicio(Integer id, Prioridad prioridad, String observaciones, Estado estado, Tecnico tecnico,
			Cliente cliente) {
		super();
		this.id = id;
		this.setFechaApertura(LocalDateTime.now());
		this.prioridad = (prioridad == null) ? 0 : prioridad.getCod();
		this.observaciones = observaciones;
		this.estado = (estado == null) ? 0 : estado.getCod();
		this.tecnico = tecnico;
		this.cliente = cliente;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public LocalDateTime getFechaApertura() {
		return fechaApertura;
	}

	public void setFechaApertura(LocalDateTime fechaApertura) {
		this.fechaApertura = fechaApertura;
	}

	public LocalDateTime getFechaCierre() {
		return fechaCierre;
	}

	public void setFechaCierre(LocalDateTime fechaCierre) {
		this.fechaCierre = fechaCierre;
	}

	public Prioridad getPrioridad() {
		return Prioridad.toEnum(this.prioridad);
	}

	public void setPrioridad(Prioridad prioridad) {
		this.prioridad = prioridad.getCod();
	}

	public String getObservaciones() {
		return observaciones;
	}

	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}

	public Estado getEstado() {
		return Estado.toEnum(this.estado);
	}

	public void setEstado(Estado estado) {
		this.estado = estado.getCod();
	}

	public Tecnico getTecnico() {
		return tecnico;
	}

	public void setTecnico(Tecnico tecnico) {
		this.tecnico = tecnico;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
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
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		OrdenServicio other = (OrdenServicio) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
