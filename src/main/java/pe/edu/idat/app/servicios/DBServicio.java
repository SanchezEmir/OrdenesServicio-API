package pe.edu.idat.app.servicios;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.idat.app.entidad.Cliente;
import pe.edu.idat.app.entidad.OrdenServicio;
import pe.edu.idat.app.entidad.Tecnico;
import pe.edu.idat.app.entidad.enums.Estado;
import pe.edu.idat.app.entidad.enums.Prioridad;
import pe.edu.idat.app.repositorio.ClienteRepositorio;
import pe.edu.idat.app.repositorio.OrdenServicioRepositorio;
import pe.edu.idat.app.repositorio.TecnicoRepositorio;

@Service
public class DBServicio {

	@Autowired
	private TecnicoRepositorio tecnicoRepositorio;

	@Autowired
	private ClienteRepositorio clienteRepositorio;

	@Autowired
	private OrdenServicioRepositorio ordenservicioRepositorio;

	public void instaciaDB() {

		Tecnico t1 = new Tecnico(null, "Emir Sanchez", "72179450", "987546258");
		Tecnico t2 = new Tecnico(null, "Licas Reyes", "85487568", "999999999");
		Cliente c1 = new Cliente(null, "Betina Campos", "02548796", "965874562");
		
		OrdenServicio os1 = new OrdenServicio(null, Prioridad.ALTA, "Test de Orden de Servicio", Estado.PROGRESO, t1, c1);

		tecnicoRepositorio.saveAll(Arrays.asList(t1, t2));
		clienteRepositorio.saveAll(Arrays.asList(c1));
		ordenservicioRepositorio.saveAll(Arrays.asList(os1));

	}

}
