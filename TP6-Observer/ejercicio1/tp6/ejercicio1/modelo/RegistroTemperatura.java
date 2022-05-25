package tp6.ejercicio1.modelo;

public class RegistroTemperatura implements Observer {

	private PersistenciaTemperatura persistencia;

	public RegistroTemperatura(PersistenciaTemperatura persistencia) {

		this.persistencia = persistencia;
	}

	@Override
	public void actualizar(String valor) {
		persistencia.guardar("La temperatura es: " + valor + System.lineSeparator());

	}

}
