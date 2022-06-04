package tp6.ejercicio2.modelo;

import java.util.Random;

public class WeatherChannelService implements ClimaOnline {

	@Override
	public String temperatura() {
		int temp = new Random().nextInt(40);// lo cambie a 40 para q sea mas realista
		return temp + " c";
	}

}
