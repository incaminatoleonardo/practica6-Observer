package ar.unrn.parcial1.ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDateTime;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import ar.unrn.parcial1.modelo.RepositorioCompras;

public class UIComprarRemera extends JFrame {

	private JPanel contentPane;
	private JTextField textCantRemeras;
	private JTextField textEmail;

	private RepositorioCompras repo;

	public UIComprarRemera(RepositorioCompras repo) {
		setTitle("Comprar Remera");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblCantRemeras = new JLabel("Cantidad de Remeras:");
		lblCantRemeras.setBounds(42, 40, 132, 35);
		contentPane.add(lblCantRemeras);

		textCantRemeras = new JTextField();
		textCantRemeras.setBounds(247, 47, 44, 20);
		contentPane.add(textCantRemeras);
		textCantRemeras.setColumns(10);

		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setBounds(52, 86, 62, 35);
		contentPane.add(lblEmail);

		textEmail = new JTextField();
		textEmail.setBounds(193, 93, 194, 20);
		contentPane.add(textEmail);
		textEmail.setColumns(10);

		JLabel lblTipoRemera = new JLabel("Tipo de remera:");
		lblTipoRemera.setBounds(42, 140, 106, 35);
		contentPane.add(lblTipoRemera);

		JComboBox<String> comboBoxTipoRemera = new JComboBox<String>();
		comboBoxTipoRemera.addItem("Remera Lisa");
		comboBoxTipoRemera.addItem("Remera Estampada");
		comboBoxTipoRemera.setBounds(193, 146, 194, 22);
		contentPane.add(comboBoxTipoRemera);

		// Boton Confirmar Compra
		JButton btnConfirmarCompra = new JButton("Comfirmar Compra");
		// Accion Comfirmar Compra
		btnConfirmarCompra.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnConfirmarCompra.setEnabled(false);
				guardarCompra();
				btnConfirmarCompra.setEnabled(true);
			}

			private void guardarCompra() {

				String remera = comboBoxTipoRemera.getItemAt(comboBoxTipoRemera.getSelectedIndex());
				// persistir compra

				try {
					repo.nuevaCompra(textCantRemeras.getText(), remera, LocalDateTime.now(), textEmail.getText());
					JOptionPane.showMessageDialog(btnConfirmarCompra, "Compra realizada con exito");
				} catch (Exception e) {

					JOptionPane.showMessageDialog(btnConfirmarCompra, e.getMessage());
					return;
				}

			}
		});
		btnConfirmarCompra.setBounds(227, 216, 168, 23);
		contentPane.add(btnConfirmarCompra);

		// Boton Calcular Monto
		JButton btnCalcularMonto = new JButton("Calcular Precio");
		// Accion Calcular Monto
		btnCalcularMonto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				btnCalcularMonto.setEnabled(false);
				cualcularMonto();
				btnCalcularMonto.setEnabled(true);

			}

			private void cualcularMonto() {

				String remera = comboBoxTipoRemera.getItemAt(comboBoxTipoRemera.getSelectedIndex());
				// devuelve cartel con monto calculado
				try {
					JOptionPane.showMessageDialog(btnCalcularMonto, "El precio total es de: " + repo
							.montoTotal(textCantRemeras.getText(), remera, LocalDateTime.now(), textEmail.getText()));
				} catch (Exception e) {

					JOptionPane.showMessageDialog(btnCalcularMonto, e.getMessage());
					return;
				}

			}
		});
		btnCalcularMonto.setBounds(68, 216, 122, 23);
		contentPane.add(btnCalcularMonto);
	}
}
