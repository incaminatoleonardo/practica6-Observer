package tp6.ejercicio1.modelo;

import java.util.List;

public class Medidor extends Observable {

	private String temperatura;
	private ClimaOnline clima;

	public Medidor(ClimaOnline clima, List<Observer> observadores) {
		this.clima = clima;
		for (Observer observer : observadores) {
			this.agregarObservador(observer);
		}
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
