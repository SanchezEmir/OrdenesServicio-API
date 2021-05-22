package pe.edu.idat.app.servicios;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.idat.app.dtos.OrdenServicioDTO;
import pe.edu.idat.app.entidad.Cliente;
import pe.edu.idat.app.entidad.OrdenServicio;
import pe.edu.idat.app.entidad.Tecnico;
import pe.edu.idat.app.entidad.enums.Estado;
import pe.edu.idat.app.entidad.enums.Prioridad;
import pe.edu.idat.app.repositorio.OrdenServicioRepositorio;
import pe.edu.idat.app.servicios.exceptions.ObjectNotFoundException;

@Service
public class OrdenServicioService {

	@Autowired
	private OrdenServicioRepositorio osRepositorio;

	@Autowired
	private TecnicoServicio tecServicio;

	@Autowired
	private ClienteServicio cliServicio;

	public OrdenServicio findById(Integer id) {
		Optional<OrdenServicio> obj = osRepositorio.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto no encontrado ! Id: " + id + ", Tipo: " + OrdenServicio.class.getName()));
	}

	public List<OrdenServicio> findAll() {
		return osRepositorio.findAll();
	}

	public OrdenServicio create(@Valid OrdenServicioDTO obj) {
		return fromDTO(obj);
	}

	public OrdenServicio update(@Valid OrdenServicioDTO obj) {
		findById(obj.getId());
		return fromDTO(obj);
	}

	private OrdenServicio fromDTO(OrdenServicioDTO obj) {
		OrdenServicio newObj = new OrdenServicio();
		newObj.setId(obj.getId());
		newObj.setObservaciones(obj.getObservaciones());
		newObj.setPrioridad(Prioridad.toEnum(obj.getPrioridad()));
		newObj.setEstado(Estado.toEnum(obj.getEstado()));

		Tecnico tec = tecServicio.findById(obj.getTecnico());
		Cliente cli = cliServicio.findById(obj.getCliente());

		newObj.setTecnico(tec);
		newObj.setCliente(cli);
		
		if(newObj.getEstado().getCod().equals(2)) {
			newObj.setFechaCierre(LocalDateTime.now());
		}
		
		return osRepositorio.save(newObj);

	}

}
