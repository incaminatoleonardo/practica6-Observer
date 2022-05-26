package ar.unrn.parcial1.modelo;

public class Cantidad {

	private int cantidad;

	public Cantidad(String cantidad) {

		int cant = 0;
		try {
			cant = Integer.parseInt(cantidad);
		} catch (Exception e) {
			throw new RuntimeException("Dege ingresar un valor numerico", e);
		}
		if (cant < 0 || cant == 0) {
			throw new RuntimeException("Dege ingresar un valor mayor a 0");
		}
		this.cantidad = cant;
	}

}
