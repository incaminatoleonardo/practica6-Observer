package ar.unrn.parcial1.modelo;

public class RegistroCompras implements Observer {

	private PersistenciaCompras persistencia;

	public RegistroCompras(PersistenciaCompras persistencia) {

		this.persistencia = persistencia;
	}

	@Override
	public void actualizar(String valor) {
		persistencia.registrar(valor);

	}

}
