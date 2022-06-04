package ar.unrn.parcial1.modelo;

import java.time.LocalDateTime;

public class Compra {

	private Cantidad cantRemeras;
	private Remeras remera;
	private Email email;

	public Compra(String cantRemeras, String remera, String email) {

		this.cantRemeras = new Cantidad(cantRemeras);

		this.email = new Email(email);

		if (remera.equals("Remera Lisa")) {
			this.remera = new Lisa();
		}
		if (remera.equals("Remera Estampada")) {
			this.remera = new Estampada();
		}

	}

	public double calcular(LocalDateTime fechaCompra, String cantidad) {

		return remera.calcularPrecio(fechaCompra, Integer.parseInt(cantidad));
	}

}
