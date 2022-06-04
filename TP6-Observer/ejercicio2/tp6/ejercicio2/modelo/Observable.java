package tp6.ejercicio2.modelo;

import java.util.ArrayList;
import java.util.List;

public class Observable {

	private List<Observer> observadores;

	public Observable(List<Observer> observadores) {

		this.observadores = new ArrayList<>();
		for (Observer observer : observadores) {
			this.agregarObservador(observer);
		}
	}

	public void agregarObservador(Observer observador) {

		this.observadores.add(observador);

	}

	public void notificar(String valor) {
		for (Observer observer : observadores) {
			observer.actualizar(valor);
		}
	}

}
