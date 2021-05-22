package pe.edu.idat.app.dtos;

import java.io.Serializable;

import javax.validation.constraints.NotEmpty;

import pe.edu.idat.app.entidad.Tecnico;

public class TecnicoDTO implements Serializable {

	static final long serialVersionUID = 1L;

	private Integer id;
	
	@NotEmpty(message = "Campo nombre es requerido")
	private String nombre;
	
	@NotEmpty(message = "Campo DNI es requerido")
	private String dni;
	
	@NotEmpty(message = "Campo telefono es requerido")
	private String telefono;

	public TecnicoDTO() {
		super();
	}

	public TecnicoDTO(Tecnico obj) {
		super();
		this.id = obj.getId();
		this.nombre = obj.getName();
		this.dni = obj.getDni();
		this.telefono = obj.getTelefono();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return nombre;
	}

	public void setName(String name) {
		this.nombre = name;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

}
