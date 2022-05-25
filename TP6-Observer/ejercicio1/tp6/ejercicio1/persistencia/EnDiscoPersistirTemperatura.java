package tp6.ejercicio1.persistencia;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

import tp6.ejercicio1.modelo.PersistenciaTemperatura;

public class EnDiscoPersistirTemperatura implements PersistenciaTemperatura {

	private File file;

	public EnDiscoPersistirTemperatura(File file) {

		this.file = file;
	}

	@Override
	public void guardar(String valor) {
		if (!file.exists()) {
			crearArchivo(file);
		}

		try {
			Files.write(Paths.get(file.getPath()), valor.getBytes(), StandardOpenOption.APPEND);
		} catch (IOException e) {
			throw new RuntimeException("No se pudo guardar en disco", e);
		}

	}

	private void crearArchivo(File file) {
		try {
			file.createNewFile();
		} catch (IOException e) {
			throw new RuntimeException("No se pudo crear el directorio", e);
		}

	}

}
