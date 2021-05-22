package pe.edu.idat.app.servicios;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.idat.app.dtos.TecnicoDTO;
import pe.edu.idat.app.entidad.Persona;
import pe.edu.idat.app.entidad.Tecnico;
import pe.edu.idat.app.repositorio.PersonaRepositorio;
import pe.edu.idat.app.repositorio.TecnicoRepositorio;
import pe.edu.idat.app.servicios.exceptions.DataIntegratyViolationException;
import pe.edu.idat.app.servicios.exceptions.ObjectNotFoundException;

@Service
public class TecnicoServicio {

	@Autowired
	private TecnicoRepositorio tecRepositorio;

	@Autowired
	private PersonaRepositorio perRepositorio;

	public Tecnico findById(Integer id) {
		Optional<Tecnico> obj = tecRepositorio.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto no encontrado! Id: " + id + ", Tipo: " + Tecnico.class.getName()));
	}

	public List<Tecnico> findAll() {
		return tecRepositorio.findAll();
	}

	public Tecnico create(TecnicoDTO objDTO) {

		if (findByDNI(objDTO) != null) {
			throw new DataIntegratyViolationException("DNI ya esta registrado en la base de datos");
		}

		return tecRepositorio.save(new Tecnico(null, objDTO.getName(), objDTO.getDni(), objDTO.getTelefono()));

//		Tecnico newObj = new Tecnico(null, objDTO.getName(), objDTO.getDni(), objDTO.getTelefono());
//		return tecRepositorio.save(newObj);
	}

	public Tecnico update(Integer id, @Valid TecnicoDTO objDTO) {
		Tecnico oldObj = findById(id);

		if (findByDNI(objDTO) != null && findByDNI(objDTO).getId() != id) {
			throw new DataIntegratyViolationException("DNI ya esta registrado en la base de datos");
		}

		oldObj.setName(objDTO.getName());
		oldObj.setDni(objDTO.getDni());
		oldObj.setTelefono(objDTO.getTelefono());

		return tecRepositorio.save(oldObj);
	}

	public void eliminar(Integer id) {
		Tecnico obj = findById(id);

		if (obj.getList().size() > 0) {
			throw new DataIntegratyViolationException(
					"No se puede eliminar, Tecnico esta asignado a una orden de servicio.");
		}

		tecRepositorio.deleteById(id);
	}

	private Persona findByDNI(TecnicoDTO objDTO) {
		Persona obj = perRepositorio.findByDNI(objDTO.getDni());

		if (obj != null) {
			return obj;
		}

		return null;
	}

}
