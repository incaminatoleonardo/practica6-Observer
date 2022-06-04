package ar.unrn.parcial1.modelo;

import java.util.HashMap;

public class NotificarViaMail implements Observer {

	private ServiciosDeCompras servicio;

	public NotificarViaMail(ServiciosDeCompras servicio) {

		this.servicio = servicio;
	}

	@Override
	public void actualizar(HashMap<String, String> map) {
		servicio.enviarMail(map.get("Email"), map.get("Asunto"), map.get("ContenidoEmail"));

	}

}
