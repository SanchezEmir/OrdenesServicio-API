package pe.edu.idat.app.controladores;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import pe.edu.idat.app.dtos.ClienteDTO;
import pe.edu.idat.app.entidad.Cliente;
import pe.edu.idat.app.servicios.ClienteServicio;

@CrossOrigin("*")
@RestController
@RequestMapping(value = "/clientes")
public class ClienteControlador {

	@Autowired
	private ClienteServicio tecServicio;

	@GetMapping(value = "/{id}")
	public ResponseEntity<ClienteDTO> findById(@PathVariable Integer id) {
		ClienteDTO objDTO = new ClienteDTO(tecServicio.findById(id));
		return ResponseEntity.ok().body(objDTO);
	}

	@GetMapping
	public ResponseEntity<List<ClienteDTO>> findAll() {

		List<ClienteDTO> listDTO = tecServicio.findAll().stream().map(obj -> new ClienteDTO(obj))
				.collect(Collectors.toList());

		return ResponseEntity.ok().body(listDTO);

//		List<Cliente> list = tecServicio.findAll();
//		List<ClienteDTO> listDTO = new ArrayList<>();
//
//		for (Cliente obj : list) {
//			listDTO.add(new ClienteDTO(obj));
//		}
//
//		list.forEach(obj -> listDTO.add(new ClienteDTO(obj)));

		// CTRL + SHIFT + O
		// CTRL + SHIFT + F
		// CTRL + SHIFT + S

	}

	@PostMapping
	public ResponseEntity<ClienteDTO> create(@Valid @RequestBody ClienteDTO objDTO) {

		Cliente newObj = tecServicio.create(objDTO);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(newObj.getId()).toUri();

		return ResponseEntity.created(uri).build();

	}

	@PutMapping(value = "/{id}")
	public ResponseEntity<ClienteDTO> update(@PathVariable Integer id, @Valid @RequestBody ClienteDTO objDTO) {
		ClienteDTO newObj = new ClienteDTO(tecServicio.update(id, objDTO));
		return ResponseEntity.ok().body(newObj);
	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> eliminar(@PathVariable Integer id) {
		tecServicio.eliminar(id);
		return ResponseEntity.noContent().build();
	}

}
