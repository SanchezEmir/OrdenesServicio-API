package pe.edu.idat.app.entidad.enums;

public enum Prioridad {

	BAJA(0, "BAJA"), MEDIA(1, "MEDIA"), ALTA(2, "ALTA");

	private Integer cod;
	private String descripcion;

	private Prioridad(Integer cod, String descripcion) {
		this.cod = cod;
		this.descripcion = descripcion;
	}

	public Integer getCod() {
		return cod;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public static Prioridad toEnum(Integer cod) {
		if (cod == null) {
			return null;
		}
		for (Prioridad x : Prioridad.values()) {
			if (cod.equals(x.getCod())) {
				return x;
			}
		}

		throw new IllegalArgumentException("Prioridad incorrecto" + cod);
	}

}
