package pe.edu.idat.app.entidad;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Tecnico extends Persona implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@JsonIgnore
	@OneToMany(mappedBy = "tecnico")
	private List<OrdenServicio> list = new ArrayList<>();

	public Tecnico() {
		super();
	}

	public Tecnico(Integer id, String name, String dni, String telefono) {
		super(id, name, dni, telefono);
	}

	public List<OrdenServicio> getList() {
		return list;
	}

	public void setList(List<OrdenServicio> list) {
		this.list = list;
	}

}
