package ar.unrn.parcial1.modelo;

import java.time.LocalDateTime;

public interface TipoRegistro {

	public String crear(String cantidad, LocalDateTime fecha, Double montoTotal);

}
