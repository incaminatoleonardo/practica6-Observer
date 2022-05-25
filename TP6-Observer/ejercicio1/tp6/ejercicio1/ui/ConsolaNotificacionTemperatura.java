package tp6.ejercicio1.ui;

import tp6.ejercicio1.modelo.Observer;
import tp6.ejercicio1.modelo.RepositorioTemperatura;

public class ConsolaNotificacionTemperatura implements Observer {

	private RepositorioTemperatura repo;

	public ConsolaNotificacionTemperatura(RepositorioTemperatura repo) {

		this.repo = repo;
	}

	@Override
	public void actualizar(String valor) {

		System.out.println(valor);

		if (repo.muyFria(valor)) {
			System.out.println("Hace frio, se encenderá la caldera");
		}
		if (repo.muyCaliente(valor)) {
			System.out.println("Hace calor, se encenderá el aire acondicionado");
		}

	}

}
