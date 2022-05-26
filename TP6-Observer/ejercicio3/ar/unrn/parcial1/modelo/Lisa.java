package ar.unrn.parcial1.modelo;

import java.time.LocalDateTime;

public class Lisa extends Remeras {

	private double precio = 2000;

	@Override
	public double calcularPrecio(LocalDateTime fecha, int cantidadRemeras) {

		if (fecha.getHour() >= 8 && fecha.getHour() < 10) { // Yo considero que a partir de las 10 horas ya no se
															// realiza el descuento
			return (cantidadRemeras * precio) - (cantidadRemeras * precio * 5 / 100);
		}

		return cantidadRemeras * precio;
	}

}
