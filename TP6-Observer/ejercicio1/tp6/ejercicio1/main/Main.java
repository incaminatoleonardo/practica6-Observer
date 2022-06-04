package tp6.ejercicio1.main;

import java.io.File;
import java.util.List;

import tp6.ejercicio1.modelo.Medidor;
import tp6.ejercicio1.modelo.RegistroTemperatura;
import tp6.ejercicio1.modelo.SistemaConsola;
import tp6.ejercicio1.modelo.WeatherChannelService;
import tp6.ejercicio1.persistencia.EnDiscoPersistirTemperatura;
import tp6.ejercicio1.ui.ConsolaNotificacionTemperatura;

public class Main {

	public static void main(String[] args) {

		File file = new File(
				"C:\\Users\\Frodo\\Desktop\\Uni\\Objetos 2\\RegistrosDeTrabajos\\tp6-RegistroTemperatura.txt");

//		Medidor medidor = new Medidor(List.of(new ConsolaNotificacionTemperatura(new SistemaConsola()),
//				new RegistroTemperatura(new EnDiscoPersistirTemperatura(file))), new WeatherChannelService());

		Medidor medidor = new Medidor(List.of(new ConsolaNotificacionTemperatura(new SistemaConsola()),
				new RegistroTemperatura(new EnDiscoPersistirTemperatura(file))), new WeatherChannelService());

		medidor.leerTemperatura();
	}

}
