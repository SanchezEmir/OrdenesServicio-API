package pe.edu.idat.app.configuracion;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import pe.edu.idat.app.servicios.DBServicio;

@Configuration
@Profile("test")
public class TestConfig {
	
	@Autowired
	private DBServicio dbservicio;
	
	@Bean
	public void instanciaDB() {
		this.dbservicio.instaciaDB();
	}

}
