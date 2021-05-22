package pe.edu.idat.app.servicios;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.idat.app.dtos.ClienteDTO;
import pe.edu.idat.app.entidad.Cliente;
import pe.edu.idat.app.entidad.Persona;
import pe.edu.idat.app.repositorio.ClienteRepositorio;
import pe.edu.idat.app.repositorio.PersonaRepositorio;
import pe.edu.idat.app.servicios.exceptions.DataIntegratyViolationException;
import pe.edu.idat.app.servicios.exceptions.ObjectNotFoundException;

@Service
public class ClienteServicio {

	@Autowired
	private ClienteRepositorio tecRepositorio;

	@Autowired
	private PersonaRepositorio perRepositorio;

	public Cliente findById(Integer id) {
		Optional<Cliente> obj = tecRepositorio.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto no encontrado! Id: " + id + ", Tipo: " + Cliente.class.getName()));
	}

	public List<Cliente> findAll() {
		return tecRepositorio.findAll();
	}

	public Cliente create(ClienteDTO objDTO) {

		if (findByDNI(objDTO) != null) {
			throw new DataIntegratyViolationException("DNI ya esta registrado en la base de datos");
		}

		return tecRepositorio.save(new Cliente(null, objDTO.getName(), objDTO.getDni(), objDTO.getTelefono()));

//		Cliente newObj = new Cliente(null, objDTO.getName(), objDTO.getDni(), objDTO.getTelefono());
//		return tecRepositorio.save(newObj);
	}

	public Cliente update(Integer id, @Valid ClienteDTO objDTO) {
		Cliente oldObj = findById(id);

		if (findByDNI(objDTO) != null && findByDNI(objDTO).getId() != id) {
			throw new DataIntegratyViolationException("DNI ya esta registrado en la base de datos");
		}

		oldObj.setName(objDTO.getName());
		oldObj.setDni(objDTO.getDni());
		oldObj.setTelefono(objDTO.getTelefono());

		return tecRepositorio.save(oldObj);
	}

	public void eliminar(Integer id) {
		Cliente obj = findById(id);

		if (obj.getList().size() > 0) {
			throw new DataIntegratyViolationException("No se puede eliminar, Cliente esta asignado a una orden de servicio.");
		}

		tecRepositorio.deleteById(id);
	}

	private Persona findByDNI(ClienteDTO objDTO) {
		Persona obj = perRepositorio.findByDNI(objDTO.getDni());

		if (obj != null) {
			return obj;
		}

		return null;
	}

}
