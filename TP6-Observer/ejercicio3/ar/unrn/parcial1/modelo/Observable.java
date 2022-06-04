package ar.unrn.parcial1.modelo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Observable {

	private List<Observer> observadores;

	public Observable() {

		this.observadores = new ArrayList<>();
	}

	public void agregarObservador(Observer observador) {
		this.observadores.add(observador);
	}

	public void notificar(HashMap<String, String> map) {
		for (Observer observer : observadores) {
			observer.actualizar(map);
		}
	}

}
