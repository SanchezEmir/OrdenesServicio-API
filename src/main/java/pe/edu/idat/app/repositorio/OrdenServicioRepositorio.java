package pe.edu.idat.app.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pe.edu.idat.app.entidad.OrdenServicio;

@Repository
public interface OrdenServicioRepositorio extends JpaRepository<OrdenServicio, Integer>{

}
