package ar.unrn.parcial1.persistencia;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

import ar.unrn.parcial1.modelo.PersistenciaCompras;

public class EnDiscoRegistroDeCompra implements PersistenciaCompras {

	private String pathCasa;
	private File fileCasa;

	public EnDiscoRegistroDeCompra(String pathCasa) {
		this.pathCasa = pathCasa;
		fileCasa = new File(pathCasa);

	}

	@Override
	public void registrar(String registro) {

		if (!fileCasa.isFile()) {
			crearTxt();
		}
		try {
			Files.write(Paths.get(pathCasa), registro.getBytes(), StandardOpenOption.APPEND);
		} catch (IOException e) {
			throw new RuntimeException("No se pudo guardar en disco", e);
		}

	}

	private void crearTxt() {
		try {
			fileCasa.createNewFile();
		} catch (IOException e) {
			throw new RuntimeException("No se pudo crear el directorio", e);
		}

	}

}
