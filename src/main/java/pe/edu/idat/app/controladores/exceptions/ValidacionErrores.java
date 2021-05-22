package pe.edu.idat.app.controladores.exceptions;

import java.util.ArrayList;
import java.util.List;

public class ValidacionErrores extends ErrorEstandar {

	private static final long serialVersionUID = 1L;

	private List<FieldMensaje> errores = new ArrayList<>();

	public ValidacionErrores() {
		super();
	}

	public ValidacionErrores(Long timestamp, Integer status, String error) {
		super(timestamp, status, error);
	}

	public List<FieldMensaje> getErrores() {
		return errores;
	}

	public void addErrores(String fieldNombre, String mensaje) {
		this.errores.add(new FieldMensaje(fieldNombre, mensaje));
	}
	
	
	
	
	
	
	
	
	

}
