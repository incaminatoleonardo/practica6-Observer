package ar.unrn.parcial1.modelo;

import java.time.LocalDateTime;

public class Estampada extends Remeras {

	private double precio = 2500;

	@Override
	public double calcularPrecio(LocalDateTime fecha, int cantidadRemeras) {

		if (fecha.getDayOfWeek().toString().equalsIgnoreCase("SATURDAY") && cantidadRemeras > 3) {
			return (cantidadRemeras * precio) - (cantidadRemeras * precio * 12 / 100);
		}
		if (fecha.getDayOfWeek().toString().equalsIgnoreCase("SUNDAY")) {
			return (cantidadRemeras * precio) - (cantidadRemeras * precio * 10 / 100);
		}

		return cantidadRemeras * precio;
	}

}
