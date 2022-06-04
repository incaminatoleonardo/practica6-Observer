package ar.unrn.parcial1.modelo;

import java.util.HashMap;

public class RegistroCompras implements Observer {

	private PersistenciaCompras persistencia;

	public RegistroCompras(PersistenciaCompras persistencia) {

		this.persistencia = persistencia;
	}

	@Override
	public void actualizar(HashMap<String, String> map) {
		persistencia.registrar(map.get("Registro"));

	}

}
