package pe.edu.idat.app.dtos;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.validation.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonFormat;

import pe.edu.idat.app.entidad.OrdenServicio;
import pe.edu.idat.app.entidad.enums.Estado;
import pe.edu.idat.app.entidad.enums.Prioridad;

public class OrdenServicioDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer id;
	
	@JsonFormat(pattern = "dd/MM/yyy HH:mm")
	private LocalDateTime fechaApertura;
	
	@JsonFormat(pattern = "dd/MM/yyy HH:mm")
	private LocalDateTime fechaCierre;
	
	private Integer prioridad;
	
	@NotEmpty(message = "El campo de OBSERVACIONES es requerido")
	private String observaciones;
	
	private Integer estado;
	
	private Integer tecnico;
	
	private Integer cliente;

	public OrdenServicioDTO() {
		super();
	}

	public OrdenServicioDTO(OrdenServicio obj) {
		super();
		this.id = obj.getId();
		this.fechaApertura = obj.getFechaApertura();
		this.fechaCierre = obj.getFechaCierre();
		this.prioridad = obj.getPrioridad().getCod();
		this.observaciones = obj.getObservaciones();
		this.estado = obj.getEstado().getCod();
		this.tecnico = obj.getTecnico().getId();
		this.cliente = obj.getCliente().getId();
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

	public void setPrioridad(Integer prioridad) {
		this.prioridad = prioridad;
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

	public void setEstado(Integer estado) {
		this.estado = estado;
	}

	public Integer getTecnico() {
		return tecnico;
	}

	public void setTecnico(Integer tecnico) {
		this.tecnico = tecnico;
	}

	public Integer getCliente() {
		return cliente;
	}

	public void setCliente(Integer cliente) {
		this.cliente = cliente;
	}

}
