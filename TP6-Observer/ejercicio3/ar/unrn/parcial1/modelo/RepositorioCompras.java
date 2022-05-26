package ar.unrn.parcial1.modelo;

import java.time.LocalDateTime;

public interface RepositorioCompras {

	void nuevaCompra(String cantidad, String remera, LocalDateTime fecha, String email);

	double montoTotal(String cantidad, String remera, LocalDateTime fecha, String email);

}
