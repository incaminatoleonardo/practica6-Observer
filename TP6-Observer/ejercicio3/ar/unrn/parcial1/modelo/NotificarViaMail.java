package ar.unrn.parcial1.modelo;

public class NotificarViaMail implements Observer {

	private ServiciosDeCompras servicio;

	public NotificarViaMail(ServiciosDeCompras servicio) {

		this.servicio = servicio;
	}

	@Override
	public void actualizar(String valor) {
		servicio.enviarMail("Mail del usuario, no se como traerlo", "asunto- es estatico asi que no hay problema",
				valor);

	}

}
