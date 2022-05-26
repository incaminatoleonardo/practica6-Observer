package ar.unrn.parcial1.modelo;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

public class RegistroConComas implements TipoRegistro {

	@Override
	public String crear(String cantidad, LocalDateTime fecha, Double montoTotal) {

		return DateTimeFormatter.ofLocalizedDateTime(FormatStyle.SHORT).format(fecha) + ", " + cantidad + ", "
				+ montoTotal + System.lineSeparator();
	}

}
