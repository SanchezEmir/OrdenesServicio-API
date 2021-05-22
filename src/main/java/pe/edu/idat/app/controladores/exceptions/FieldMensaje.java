package pe.edu.idat.app.controladores.exceptions;

import java.io.Serializable;

public class FieldMensaje implements Serializable {

	private static final long serialVersionUID = 1L;

	private String fieldNombre;

	private String mensaje;

	public FieldMensaje() {
		super();
	}

	public FieldMensaje(String fieldNombre, String mensaje) {
		super();
		this.fieldNombre = fieldNombre;
		this.mensaje = mensaje;
	}

	public String getFieldNombre() {
		return fieldNombre;
	}

	public void setFieldNombre(String fieldNombre) {
		this.fieldNombre = fieldNombre;
	}

	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

}
