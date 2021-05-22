package pe.edu.idat.app.configuracion;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import pe.edu.idat.app.servicios.DBServicio;

@Configuration
@Profile("dev")
public class DevConfig {
	
	@Autowired
	private DBServicio dbservicio;
	
	@Value("${spring.jpa.hibernate.ddl-auto}")
	private String ddl;
	
	@Bean
	public boolean instanciaDB() {
		if(ddl.equals("create")) {
			this.dbservicio.instaciaDB();
		}
		
		return false;
	}

}
