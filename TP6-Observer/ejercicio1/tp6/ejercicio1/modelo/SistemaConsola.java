package tp6.ejercicio1.modelo;

public class SistemaConsola implements RepositorioTemperatura {

	@Override
	public boolean muyFria(String valor) {

		int temperatura = convertirAEntero(valor);
		if (temperatura < 12) {
			return true;
		}
		return false;
	}

	@Override
	public boolean muyCaliente(String valor) {

		int temperatura = convertirAEntero(valor);
		if (temperatura > 17) {
			return true;
		}
		return false;
	}

	private int convertirAEntero(String valor) {

		String[] entero = valor.split("c");
		return Integer.parseInt(entero[0].trim());
	}

}
