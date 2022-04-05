package capitulo08.Ejercicio01;

import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridBagConstraints;
import javax.swing.JTextField;

import capitulo07.EjercicioCRUDCompleto.ConnectionManager;

import java.awt.Insets;
import java.sql.Connection;
import java.sql.ResultSet;

import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JPanel;
import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.FlowLayout;
import javax.swing.JProgressBar;
import javax.swing.JCheckBox;

public class GestionCliente extends JPanel {

	private static JTextField jtfId;
	private JLabel lblGestionDeClientes;
	private JLabel lblNewLabel;
	private JLabel lblNombre;
	private JLabel lblApellidos;
	private static JTextField jtfNombre;
	private static JTextField jtfApellidos;
	private JPanel panel;
	private JButton button;
	private JButton button_1;
	private JButton button_2;
	private JButton button_3;
	private JButton btnNuevo;
	private JButton btnGuardar;
	private JButton btnBorrar;

	// Variable que actúa como Singleton
	private static GestionCliente instance = null;
	private JLabel lblLocalidad;
	private JTextField jtfLocalidad;
	private JLabel lblDni;
	private JTextField jtfDni;
	private JLabel lblFechaNac;
	private JTextField jtfFechaNac;
	private JCheckBox chckbxNewCheckBox;
	private JLabel lblActivo;

	// Método que devuelve el singleton
	public static GestionCliente getInstance() {
		if (instance == null) {
			instance = new GestionCliente();
		}
		return instance;
	}

	public GestionCliente() {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 0, 0, 0, 0, 0, 0, 0, 0 };
		gridBagLayout.rowHeights = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		gridBagLayout.columnWeights = new double[] { 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		gridBagLayout.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE };
		this.setLayout(gridBagLayout);

		lblGestionDeClientes = new JLabel("GESTION DE CLIENTES");
		GridBagConstraints gbc_lblGestionDeClientes = new GridBagConstraints();
		gbc_lblGestionDeClientes.gridwidth = 2;
		gbc_lblGestionDeClientes.insets = new Insets(0, 0, 5, 5);
		gbc_lblGestionDeClientes.gridx = 0;
		gbc_lblGestionDeClientes.gridy = 0;
		this.add(lblGestionDeClientes, gbc_lblGestionDeClientes);

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
		gbc_lblNewLabel.gridx = 6;
		gbc_lblNewLabel.gridy = 0;
		this.add(lblNewLabel, gbc_lblNewLabel);

		lblNombre = new JLabel("Nombre:");
		GridBagConstraints gbc_lblNombre = new GridBagConstraints();
		gbc_lblNombre.anchor = GridBagConstraints.EAST;
		gbc_lblNombre.insets = new Insets(0, 0, 5, 5);
		gbc_lblNombre.gridx = 0;
		gbc_lblNombre.gridy = 2;
		this.add(lblNombre, gbc_lblNombre);

		jtfNombre = new JTextField();
		GridBagConstraints gbc_jtfNombre = new GridBagConstraints();
		gbc_jtfNombre.insets = new Insets(5, 0, 5, 5);
		gbc_jtfNombre.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfNombre.gridx = 1;
		gbc_jtfNombre.gridy = 2;
		this.add(jtfNombre, gbc_jtfNombre);
		jtfNombre.setColumns(10);

		lblApellidos = new JLabel("Apellidos:");
		GridBagConstraints gbc_lblApellidos = new GridBagConstraints();
		gbc_lblApellidos.anchor = GridBagConstraints.EAST;
		gbc_lblApellidos.insets = new Insets(0, 0, 5, 5);
		gbc_lblApellidos.gridx = 0;
		gbc_lblApellidos.gridy = 3;
		this.add(lblApellidos, gbc_lblApellidos);

		jtfApellidos = new JTextField();
		GridBagConstraints gbc_jtfApellidos = new GridBagConstraints();
		gbc_jtfApellidos.insets = new Insets(5, 0, 5, 5);
		gbc_jtfApellidos.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfApellidos.gridx = 1;
		gbc_jtfApellidos.gridy = 3;
		this.add(jtfApellidos, gbc_jtfApellidos);
		jtfApellidos.setColumns(10);

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

		lblDni = new JLabel("DNI:");
		GridBagConstraints gbc_lblDni = new GridBagConstraints();
		gbc_lblDni.anchor = GridBagConstraints.EAST;
		gbc_lblDni.insets = new Insets(0, 0, 5, 5);
		gbc_lblDni.gridx = 0;
		gbc_lblDni.gridy = 5;
		add(lblDni, gbc_lblDni);

		jtfDni = new JTextField();
		GridBagConstraints gbc_jtfDni = new GridBagConstraints();
		gbc_jtfDni.insets = new Insets(5, 0, 5, 5);
		gbc_jtfDni.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfDni.gridx = 1;
		gbc_jtfDni.gridy = 5;
		add(jtfDni, gbc_jtfDni);
		jtfDni.setColumns(10);

		lblFechaNac = new JLabel("Fecha nacimiento:");
		GridBagConstraints gbc_lblFechaNac = new GridBagConstraints();
		gbc_lblFechaNac.anchor = GridBagConstraints.EAST;
		gbc_lblFechaNac.insets = new Insets(0, 0, 5, 5);
		gbc_lblFechaNac.gridx = 0;
		gbc_lblFechaNac.gridy = 6;
		add(lblFechaNac, gbc_lblFechaNac);

		jtfFechaNac = new JTextField();
		GridBagConstraints gbc_jtfFechaNac = new GridBagConstraints();
		gbc_jtfFechaNac.insets = new Insets(5, 0, 5, 5);
		gbc_jtfFechaNac.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfFechaNac.gridx = 1;
		gbc_jtfFechaNac.gridy = 6;
		add(jtfFechaNac, gbc_jtfFechaNac);
		jtfFechaNac.setColumns(10);

		lblActivo = new JLabel("Activo:");
		GridBagConstraints gbc_lblActivo = new GridBagConstraints();
		gbc_lblActivo.anchor = GridBagConstraints.EAST;
		gbc_lblActivo.insets = new Insets(0, 0, 5, 5);
		gbc_lblActivo.gridx = 0;
		gbc_lblActivo.gridy = 7;
		add(lblActivo, gbc_lblActivo);

		chckbxNewCheckBox = new JCheckBox("");
		GridBagConstraints gbc_chckbxNewCheckBox = new GridBagConstraints();
		gbc_chckbxNewCheckBox.anchor = GridBagConstraints.WEST;
		gbc_chckbxNewCheckBox.insets = new Insets(5, 0, 5, 5);
		gbc_chckbxNewCheckBox.gridx = 1;
		gbc_chckbxNewCheckBox.gridy = 7;
		add(chckbxNewCheckBox, gbc_chckbxNewCheckBox);

		panel = new JPanel();
		panel.setBackground(Color.LIGHT_GRAY);
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.insets = new Insets(5, 0, 0, 0);
		gbc_panel.gridwidth = 7;
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 0;
		gbc_panel.gridy = 8;
		this.add(panel, gbc_panel);

		button_1 = new JButton("<");
		button_1.setToolTipText("Cargar anterior cliente");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mostrarCliente(ControladorCliente.findAnteriorCliente(Integer.parseInt(jtfId.getText())));
			}
		});

		button = new JButton("<<");
		button.setToolTipText("Cargar primer cliente");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mostrarCliente(ControladorCliente.findPrimerCliente());
			}
		});
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		panel.add(button);
		panel.add(button_1);

		button_2 = new JButton(">");
		button_2.setToolTipText("Cargar siguiente cliente");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mostrarCliente(ControladorCliente.findSiguienteCliente(Integer.parseInt(jtfId.getText())));
			}
		});
		panel.add(button_2);

		button_3 = new JButton(">>");
		button_3.setToolTipText("Cargar último cliente");
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mostrarCliente(ControladorCliente.findUltimoCliente());
			}
		});
		panel.add(button_3);

		btnNuevo = new JButton("Nuevo");
		btnNuevo.setToolTipText("Crear nuevo cliente");
		btnNuevo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				nuevoCliente();
			}
		});
		panel.add(btnNuevo);
		btnGuardar = new JButton("Guardar");
		btnGuardar.setToolTipText("Guardar nuevo cliente o actualizar cliente");
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//////////////////////////
				SimpleDateFormat sdfEntrada = new SimpleDateFormat("yyyy-MM-dd");
				Date date = new Date();
				try {
					date = sdfEntrada.parse(jtfFechaNac.getText());
				} catch (ParseException ex) {
					ex.printStackTrace();
				}

				SimpleDateFormat sdfSalida = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				//////////////////
				Cliente c = new Cliente(Integer.parseInt(jtfId.getText()), jtfNombre.getText(), jtfApellidos.getText(),
						jtfLocalidad.getText(), jtfDni.getText(), sdfSalida.format(date),
						chckbxNewCheckBox.isSelected());
				if (ControladorCliente.actualizarCliente(c) == 1) {
					ImageIcon icono = new ImageIcon("./src/capitulo08/Ejercicio01/res/check.png");
					JOptionPane.showMessageDialog(null, "Actualización o inserción correcta", "Gestion de cliente",
							JOptionPane.INFORMATION_MESSAGE, icono);
				}
				mostrarCliente(ControladorCliente.findUltimoCliente());
			}
		});
		mostrarCliente(ControladorCliente.findPrimerCliente());
		panel.add(btnGuardar);

		btnBorrar = new JButton("Borrar");
		btnBorrar.setToolTipText("Eliminar cliente");
		btnBorrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// yes = 0 no = 1
				if (JOptionPane.showConfirmDialog(null, "¿Desea eliminar el registro?", "Gestión de cliente",
						JOptionPane.YES_NO_OPTION) == 0) {
					if (ControladorCliente.borrarCliente(Integer.parseInt(jtfId.getText())) == 1) {
						ImageIcon icono = new ImageIcon("./src/capitulo08/Ejercicio01/res/check.png");
						JOptionPane.showMessageDialog(null, "Borrado correcto", "Gestion de cliente",
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
	public void mostrarCliente(Cliente c) {
		if (c != null) {
			jtfId.setText("" + c.getId());
			jtfNombre.setText(c.getNombre());
			jtfApellidos.setText(c.getApellidos());
			jtfLocalidad.setText(c.getLocalidad());
			jtfDni.setText(c.getDni());
			jtfFechaNac.setText("" + c.getFechaNac());
			chckbxNewCheckBox.setSelected(c.isActivo());
		}
		if (ControladorCliente.findAnteriorCliente(Integer.parseInt(jtfId.getText())) == null) {
			button.setEnabled(false);
			button_1.setEnabled(false);
		} else {
			button.setEnabled(true);
			button_1.setEnabled(true);
		}
		if (ControladorCliente.findSiguienteCliente(Integer.parseInt(jtfId.getText())) == null) {
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
	public void nuevoCliente() {
		jtfId.setText("0");
		jtfNombre.setText("");
		jtfApellidos.setText("");
		jtfLocalidad.setText("");
		jtfDni.setText("");
		jtfFechaNac.setText("");
		chckbxNewCheckBox.setSelected(false);

	}
}