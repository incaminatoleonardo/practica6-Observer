package ar.unrn.parcial1.modelo;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.HashMap;
import java.util.List;

public class SistemaCompras extends Observable implements RepositorioCompras {

	private TipoRegistro tipoRegistro;

	public SistemaCompras(TipoRegistro tipoRegistro, List<Observer> observadores) {

		this.tipoRegistro = tipoRegistro;

		for (Observer observer : observadores) {
			this.agregarObservador(observer);
		}
	}

	@Override
	public void nuevaCompra(String cantidad, String remera, LocalDateTime fecha, String email) {

		Compra compra = new Compra(cantidad, remera, email);

		// notificar aca, usar el hasmap para enviar los datos

		HashMap<String, String> map = new HashMap<String, String>();

		String contenidoMail = "Este es el detalle de su compra --> " + System.lineSeparator() + System.lineSeparator()
				+ ". La fecha y hora de su compra fue: "
				+ DateTimeFormatter.ofLocalizedDateTime(FormatStyle.SHORT).format(fecha) + System.lineSeparator()
				+ ". La cantidad de remeras que compro son: " + cantidad + " remeras" + System.lineSeparator()
				+ ". El monto total de su compra es de: " + compra.calcular(fecha, cantidad) + System.lineSeparator()
				+ System.lineSeparator()

				+ "Muchas Gracias!!!";

		map.put("Registro", this.tipoRegistro.crear(cantidad, fecha, compra.calcular(fecha, cantidad)));
		map.put("Email", email);
		map.put("Asunto", "Detalle de Compra");
		map.put("ContenidoEmail", contenidoMail);

		this.notificar(map);

	}

	@Override
	public double montoTotal(String cantidad, String remera, LocalDateTime fecha, String email) {
		Compra posibleCompra = new Compra(cantidad, remera, email);
		return posibleCompra.calcular(fecha, cantidad);
	}

}
