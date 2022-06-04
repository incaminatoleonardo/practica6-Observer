package tp6.ejercicio2.modelo;

import java.util.List;

public class DecoradorMedidor extends Observable implements Mediciones {

	private Mediciones medidor;

	public DecoradorMedidor(List<Observer> observadores, Mediciones medidor) {
		super(observadores);
		this.medidor = medidor;

	}

	@Override
	public String leerTemperatura() {

		this.notificar(medidor.leerTemperatura());
		return medidor.leerTemperatura();
	}

}
