package tp6.ejercicio2.main;

import java.io.File;
import java.util.List;

import tp6.ejercicio2.modelo.DecoradorMedidor;
import tp6.ejercicio2.modelo.Mediciones;
import tp6.ejercicio2.modelo.Medidor;
import tp6.ejercicio2.modelo.RegistroTemperatura;
import tp6.ejercicio2.modelo.SistemaConsola;
import tp6.ejercicio2.modelo.WeatherChannelService;
import tp6.ejercicio2.persistencia.EnDiscoPersistirTemperatura;
import tp6.ejercicio2.ui.ConsolaNotificacionTemperatura;

public class Main {

	public static void main(String[] args) {

		File file = new File(
				"C:\\Users\\Frodo\\Desktop\\Uni\\Objetos 2\\RegistrosDeTrabajos\\tp6-RegistroTemperatura2.txt");

//		Medidor medidor = new Medidor(List.of(new ConsolaNotificacionTemperatura(new SistemaConsola()),
//				new RegistroTemperatura(new EnDiscoPersistirTemperatura(file))), new WeatherChannelService());

		Mediciones medidor = new DecoradorMedidor(
				List.of(new ConsolaNotificacionTemperatura(new SistemaConsola()),
						new RegistroTemperatura(new EnDiscoPersistirTemperatura(file))),
				new Medidor(new WeatherChannelService()));

		medidor.leerTemperatura();

	}

}
