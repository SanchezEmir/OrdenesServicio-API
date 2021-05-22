package pe.edu.idat.app.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import pe.edu.idat.app.entidad.Tecnico;

@Repository
public interface TecnicoRepositorio extends JpaRepository<Tecnico, Integer>{

	@Query("SELECT obj FROM Tecnico obj WHERE obj.dni =:dni")
	Tecnico findByDNI(@Param("dni") String dni);
	
}
