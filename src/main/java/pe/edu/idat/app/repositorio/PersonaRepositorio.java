package pe.edu.idat.app.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import pe.edu.idat.app.entidad.Persona;

@Repository
public interface PersonaRepositorio extends JpaRepository<Persona, Integer> {

	@Query("SELECT obj FROM Persona obj WHERE obj.dni =:dni")
	Persona findByDNI(@Param("dni") String dni);

}
