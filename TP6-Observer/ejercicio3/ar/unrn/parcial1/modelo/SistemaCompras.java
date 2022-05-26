package ar.unrn.parcial1.modelo;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

public class SistemaCompras extends Observable implements RepositorioCompras {

	private PersistenciaCompras persistencia;
	private TipoRegistro tipoRegistro;
	private ServiciosDeCompras servicio;

	public SistemaCompras(PersistenciaCompras persistencia, TipoRegistro tipoRegistro, ServiciosDeCompras servicio) {

		this.persistencia = persistencia;
		this.tipoRegistro = tipoRegistro;
		this.servicio = servicio;
	}

	@Override
	public void nuevaCompra(String cantidad, String remera, LocalDateTime fecha, String email) {

		Compra compra = new Compra(cantidad, remera, email);

		// compra.nuevaCompra(this.tipoRegistro.crear(cantidad, fecha,
		// compra.calcular(fecha, cantidad)));

		this.persistencia.registrar(this.tipoRegistro.crear(cantidad, fecha, compra.calcular(fecha, cantidad)));

		String contenidoMail = "Este es el detalle de su compra --> " + System.lineSeparator() + System.lineSeparator()
				+ ". La fecha y hora de su compra fue: "
				+ DateTimeFormatter.ofLocalizedDateTime(FormatStyle.SHORT).format(fecha) + System.lineSeparator()
				+ ". La cantidad de remeras que compro son: " + cantidad + " remeras" + System.lineSeparator()
				+ ". El monto total de su compra es de: " + compra.calcular(fecha, cantidad) + System.lineSeparator()
				+ System.lineSeparator()

				+ "Muchas Gracias!!!";

		this.servicio.enviarMail(email, "Detalle de Compra", contenidoMail);

	}

	@Override
	public double montoTotal(String cantidad, String remera, LocalDateTime fecha, String email) {
		Compra posibleCompra = new Compra(cantidad, remera, email);
		return posibleCompra.calcular(fecha, cantidad);
	}

}
