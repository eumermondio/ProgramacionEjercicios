package capitulo08.ejercicio01;

import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridBagConstraints;
import javax.swing.JTextField;

import java.awt.Insets;
import java.sql.Connection;
import java.sql.ResultSet;

import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JPanel;
import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.FlowLayout;
import javax.swing.JProgressBar;
import javax.swing.JToolBar;

import capitulo07.ejercicioCRUDCompleto.ConnectionManager;

import javax.swing.JDesktopPane;

public class GestionConcesionario extends JPanel {

	private static JTextField jtfId;
	private JLabel lblGestionDeConcesionarios;
	private JLabel lblNewLabel;
	private JLabel lblCif;
	private JLabel lblNombre;
	private static JTextField jtfCif;
	private static JTextField jtfNombre;
	private JPanel panel;
	private JButton button;
	private JButton button_1;
	private JButton button_2;
	private JButton button_3;
	private JButton btnNuevo;
	private JButton btnGuardar;
	private JButton btnBorrar;

	// Variable que actúa como Singleton
	private static GestionConcesionario instance = null;
	private JLabel lblLocalidad;
	private static JTextField jtfLocalidad;

	// Método que devuelve el singleton
	public static GestionConcesionario getInstance() {
		if (instance == null) {
			instance = new GestionConcesionario();
		}
		return instance;
	}

	public GestionConcesionario() {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 0, 0, 0, 0, 0 };
		gridBagLayout.rowHeights = new int[] { 0, 0, 0, 0, 0, 0, 0 };
		gridBagLayout.columnWeights = new double[] { 0.0, 1.0, 0.0, 0.0, Double.MIN_VALUE };
		gridBagLayout.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE };
		this.setLayout(gridBagLayout);

		lblGestionDeConcesionarios = new JLabel("GESTION DE CONCESIONARIOS");
		GridBagConstraints gbc_lblGestionDeConcesionarios = new GridBagConstraints();
		gbc_lblGestionDeConcesionarios.gridwidth = 2;
		gbc_lblGestionDeConcesionarios.insets = new Insets(0, 0, 5, 5);
		gbc_lblGestionDeConcesionarios.gridx = 0;
		gbc_lblGestionDeConcesionarios.gridy = 0;
		this.add(lblGestionDeConcesionarios, gbc_lblGestionDeConcesionarios);

		JLabel lblId = new JLabel("Id:");
		GridBagConstraints gbc_lblId = new GridBagConstraints();
		gbc_lblId.insets = new Insets(0, 0, 5, 5);
		gbc_lblId.anchor = GridBagConstraints.EAST;
		gbc_lblId.gridx = 0;
		gbc_lblId.gridy = 1;
		this.add(lblId, gbc_lblId);

		jtfId = new JTextField();
		jtfId.setEnabled(false);
		GridBagConstraints gbc_jtfId = new GridBagConstraints();
		gbc_jtfId.insets = new Insets(0, 0, 5, 5);
		gbc_jtfId.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfId.gridx = 1;
		gbc_jtfId.gridy = 1;
		this.add(jtfId, gbc_jtfId);
		jtfId.setColumns(10);

		lblNewLabel = new JLabel("      ");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel.gridx = 3;
		gbc_lblNewLabel.gridy = 0;
		this.add(lblNewLabel, gbc_lblNewLabel);

		lblCif = new JLabel("Cif:");
		GridBagConstraints gbc_lblCif = new GridBagConstraints();
		gbc_lblCif.anchor = GridBagConstraints.EAST;
		gbc_lblCif.insets = new Insets(0, 0, 5, 5);
		gbc_lblCif.gridx = 0;
		gbc_lblCif.gridy = 2;
		this.add(lblCif, gbc_lblCif);

		jtfCif = new JTextField();
		GridBagConstraints gbc_jtfCif = new GridBagConstraints();
		gbc_jtfCif.insets = new Insets(5, 0, 5, 5);
		gbc_jtfCif.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfCif.gridx = 1;
		gbc_jtfCif.gridy = 2;
		this.add(jtfCif, gbc_jtfCif);
		jtfCif.setColumns(10);

		lblNombre = new JLabel("Nombre:");
		GridBagConstraints gbc_lblNombre = new GridBagConstraints();
		gbc_lblNombre.anchor = GridBagConstraints.EAST;
		gbc_lblNombre.insets = new Insets(0, 0, 5, 5);
		gbc_lblNombre.gridx = 0;
		gbc_lblNombre.gridy = 3;
		this.add(lblNombre, gbc_lblNombre);

		jtfNombre = new JTextField();
		GridBagConstraints gbc_jtfNombre = new GridBagConstraints();
		gbc_jtfNombre.insets = new Insets(5, 0, 5, 5);
		gbc_jtfNombre.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfNombre.gridx = 1;
		gbc_jtfNombre.gridy = 3;
		this.add(jtfNombre, gbc_jtfNombre);
		jtfNombre.setColumns(10);

		lblLocalidad = new JLabel("Localidad:");
		GridBagConstraints gbc_lblLocalidad = new GridBagConstraints();
		gbc_lblLocalidad.anchor = GridBagConstraints.EAST;
		gbc_lblLocalidad.insets = new Insets(0, 0, 5, 5);
		gbc_lblLocalidad.gridx = 0;
		gbc_lblLocalidad.gridy = 4;
		add(lblLocalidad, gbc_lblLocalidad);

		jtfLocalidad = new JTextField();
		GridBagConstraints gbc_jtfLocalidad = new GridBagConstraints();
		gbc_jtfLocalidad.insets = new Insets(5, 0, 5, 5);
		gbc_jtfLocalidad.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfLocalidad.gridx = 1;
		gbc_jtfLocalidad.gridy = 4;
		add(jtfLocalidad, gbc_jtfLocalidad);
		jtfLocalidad.setColumns(10);

		panel = new JPanel();
		panel.setBackground(Color.LIGHT_GRAY);
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.insets = new Insets(5, 0, 0, 0);
		gbc_panel.gridwidth = 4;
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 0;
		gbc_panel.gridy = 5;
		this.add(panel, gbc_panel);

		button_1 = new JButton("<");
		button_1.setToolTipText("Cargar anterior concesionario");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mostrarConcesionario(
						ControladorConcesionario.findAnteriorConcesionario(Integer.parseInt(jtfId.getText())));
			}
		});

		button = new JButton("<<");
		button.setToolTipText("Cargar primer concesionario");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mostrarConcesionario(ControladorConcesionario.findPrimerConcesionario());
			}
		});
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		panel.add(button);
		panel.add(button_1);

		button_2 = new JButton(">");
		button_2.setToolTipText("Cargar siguiente concesionario");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mostrarConcesionario(
						ControladorConcesionario.findSiguienteConcesionario(Integer.parseInt(jtfId.getText())));
			}
		});
		panel.add(button_2);

		button_3 = new JButton(">>");
		button_3.setToolTipText("Cargar último concesionario");
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mostrarConcesionario(ControladorConcesionario.findUltimoConcesionario());
			}
		});
		panel.add(button_3);

		btnNuevo = new JButton("Nuevo");
		btnNuevo.setToolTipText("Crear nuevo concesionario");
		btnNuevo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				nuevoConcesionario();
			}
		});
		panel.add(btnNuevo);
		btnGuardar = new JButton("Guardar");
		btnGuardar.setToolTipText("Guardar nuevo concesionario o actualizar concesionario");
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Concesionario c = new Concesionario(Integer.parseInt(jtfId.getText()), jtfCif.getText(),
						jtfNombre.getText(), jtfLocalidad.getText());
				if (ControladorConcesionario.actualizarConcesionario(c) == 1) {
					ImageIcon icono = new ImageIcon("./src/capitulo08/Ejercicio01/res/check.png");
					JOptionPane.showMessageDialog(null, "Actualización o inserción correcta",
							"Gestion de concesionarios", JOptionPane.INFORMATION_MESSAGE, icono);
				}
				mostrarConcesionario(ControladorConcesionario.findUltimoConcesionario());
			}
		});
		mostrarConcesionario(ControladorConcesionario.findPrimerConcesionario());
		panel.add(btnGuardar);

		btnBorrar = new JButton("Borrar");
		btnBorrar.setToolTipText("Eliminar concesionario");
		btnBorrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// yes = 0 no = 1
				if (JOptionPane.showConfirmDialog(null, "¿Desea eliminar el registro?", "Gestión de concesionarios",
						JOptionPane.YES_NO_OPTION) == 0) {
					if (ControladorConcesionario.borrarConcesionario(Integer.parseInt(jtfId.getText())) == 1) {
						ImageIcon icono = new ImageIcon("./src/capitulo08/Ejercicio01/res/check.png");
						JOptionPane.showMessageDialog(null, "Borrado correcto", "Gestion de concesionarios",
								JOptionPane.INFORMATION_MESSAGE, icono);
					}
				}
			}
		});
		panel.add(btnBorrar);
	}

	/**
	 * 
	 * @param f
	 */
	public void mostrarConcesionario(Concesionario c) {
		if (c != null) {
			jtfId.setText("" + c.getId());
			jtfCif.setText(c.getCif());
			jtfNombre.setText(c.getNombre());
			jtfLocalidad.setText(c.getLocalidad());
		}
		if (ControladorConcesionario.findAnteriorConcesionario(Integer.parseInt(jtfId.getText())) == null) {
			button.setEnabled(false);
			button_1.setEnabled(false);
		} else {
			button.setEnabled(true);
			button_1.setEnabled(true);
		}
		if (ControladorConcesionario.findSiguienteConcesionario(Integer.parseInt(jtfId.getText())) == null) {
			button_2.setEnabled(false);
			button_3.setEnabled(false);
		} else {
			button_2.setEnabled(true);
			button_3.setEnabled(true);
		}
	}

	/**
	 * 
	 */
	public void nuevoConcesionario() {
		jtfId.setText("0");
		jtfCif.setText("");
		jtfNombre.setText("");
		jtfLocalidad.setText("");
	}
}