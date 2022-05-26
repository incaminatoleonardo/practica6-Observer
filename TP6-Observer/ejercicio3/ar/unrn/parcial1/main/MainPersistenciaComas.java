package ar.unrn.parcial1.main;

import java.awt.EventQueue;

import ar.unrn.parcial1.modelo.PersistenciaCompras;
import ar.unrn.parcial1.modelo.RegistroConComas;
import ar.unrn.parcial1.modelo.RepositorioCompras;
import ar.unrn.parcial1.modelo.ServiciosDeCompras;
import ar.unrn.parcial1.modelo.SistemaCompras;
import ar.unrn.parcial1.modelo.TipoRegistro;
import ar.unrn.parcial1.persistencia.EnDiscoRegistroDeCompra;
import ar.unrn.parcial1.servicios.ServicioMails;
import ar.unrn.parcial1.ui.UIComprarRemera;

public class MainPersistenciaComas {

	public static void main(String[] args) {

		String pathCasa = "C:\\Users\\Frodo\\Desktop\\Uni\\Objetos 2\\compras.txt";

		PersistenciaCompras persistenciaCompras = new EnDiscoRegistroDeCompra(pathCasa);
		TipoRegistro registroComas = new RegistroConComas();
		ServiciosDeCompras servicioMail = new ServicioMails();

		RepositorioCompras sistemaCompra = new SistemaCompras(persistenciaCompras, registroComas, servicioMail);

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIComprarRemera frame = new UIComprarRemera(sistemaCompra);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

	}

}
