package ar.unrn.parcial1.modelo;

public class StubServicioMails implements ServiciosDeCompras {

	private int mailsEnviados;

	@Override
	public void enviarMail(String email, String asunto, String contenido) {
		this.mailsEnviados = this.mailsEnviados + 1;

	}

	public int mailsEnviados() {
		return this.mailsEnviados;
	}
}
