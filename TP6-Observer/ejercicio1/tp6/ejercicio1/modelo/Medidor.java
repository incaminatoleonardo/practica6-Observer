package tp6.ejercicio1.modelo;

import java.util.List;

public class Medidor extends Observable {

	private String temperatura;
	private ClimaOnline clima;

	public Medidor(List<Observer> observadores, ClimaOnline clima) {
		super(observadores);
		this.clima = clima;
	}

//	public String leerTemperatura() {
//		// leo la temperatura del servicio web
//		this.temperatura = this.clima.temperatura();
//
//
//		return this.temperatura;
//	}

	public void leerTemperatura() {
		// leo la temperatura del servicio web
		this.temperatura = this.clima.temperatura();

		this.notificar(this.temperatura);

	}

}
