package ar.unrn.parcial1.modelo;

public class StubRegistroCompra implements PersistenciaCompras {

	private String registroCompra;

	@Override
	public void registrar(String registro) {
		this.registroCompra = registro;

	}

	public boolean sonIguales(String registro) {

		if (this.registroCompra.compareTo(registro) == 0) {
			return true;
		}

		return false;
	}

}
