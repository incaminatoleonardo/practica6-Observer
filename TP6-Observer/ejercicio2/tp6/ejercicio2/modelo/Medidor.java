package tp6.ejercicio2.modelo;

public class Medidor implements Mediciones {

	private String temperatura;
	private ClimaOnline clima;

	public Medidor(ClimaOnline clima) {
		this.clima = clima;
	}

//	public String leerTemperatura() {
//		// leo la temperatura del servicio web
//		this.temperatura = this.clima.temperatura();
//
//		return this.temperatura;
//	}

	public String leerTemperatura() {
		// leo la temperatura del servicio web
		this.temperatura = this.clima.temperatura();

		// this.notificar(this.temperatura);
		return this.temperatura;
	}

}
