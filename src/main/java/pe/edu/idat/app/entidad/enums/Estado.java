package pe.edu.idat.app.entidad.enums;

public enum Estado {

	ABIERTO(0, "ABIERTO"), PROGRESO(1, "PROGRESO"), CERRADO(2, "CERRADO");

	private Integer cod;
	private String descripcion;

	private Estado(Integer cod, String descripcion) {
		this.cod = cod;
		this.descripcion = descripcion;
	}

	public Integer getCod() {
		return cod;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public static Estado toEnum(Integer cod) {
		if (cod == null) {
			return null;
		}
		for (Estado x : Estado.values()) {
			if (cod.equals(x.getCod())) {
				return x;
			}
		}

		throw new IllegalArgumentException("eSTADO incorrecto" + cod);
	}

}
