package ar.unrn.parcial1.modelo;

import java.time.LocalDateTime;

public class Compra extends Observable {

	private Cantidad cantRemeras;
	private Remeras remera;
	private Email email;

	public Compra(String cantRemeras, String remera, String email/* , List<Observer> observadores */) {

		this.cantRemeras = new Cantidad(cantRemeras);

		this.email = new Email(email);

		if (remera.equals("Remera Lisa")) {
			this.remera = new Lisa();
		}
		if (remera.equals("Remera Estampada")) {
			this.remera = new Estampada();
		}
//		for (Observer observer : observadores) {
//			this.agregarObservador(observer);
//		}

	}

	public double calcular(LocalDateTime fechaCompra, String cantidad) {

		return remera.calcularPrecio(fechaCompra, Integer.parseInt(cantidad));
	}

	public void nuevaCompra(String valor) {
		this.notificar(valor);

	}

}
