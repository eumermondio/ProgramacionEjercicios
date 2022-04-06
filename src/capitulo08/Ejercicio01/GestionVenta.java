package capitulo08.Ejercicio01;

import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridBagConstraints;
import javax.swing.JTextField;
import javax.swing.JToggleButton;

import capitulo07.EjercicioCRUDCompleto.ConnectionManager;

import java.awt.Insets;
import java.sql.Connection;
import java.sql.ResultSet;

import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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
import javax.swing.JComboBox;

public class GestionVenta extends JPanel {

	private static JTextField jtfId;
	private JLabel lblGestionDeVentas;
	private JLabel lblNewLabel;
	private JLabel lblCliente;
	private JLabel lblConce;
	private static JTextField jtfCliente;
	private static JTextField jtfConce;
	private JPanel panel;
	private JButton button;
	private JButton button_1;
	private JButton button_2;
	private JButton button_3;
	private JButton btnNuevo;
	private JButton btnGuardar;
	private JButton btnBorrar;
	private JButton btnNewButton_1;
	private JToggleButton tglbtnNewToggleButton;

	// Variable que actúa como Singleton
	private static GestionVenta instance = null;
	private JLabel lblCoche;
	private JTextField jtfCoche;
	private JLabel lblFecha;
	private JTextField jtfFecha;
	private JLabel lblPrecio;
	private JTextField jtfPrecio;
	private JComboBox<Cliente> comboBoxCliente;
	private JComboBox<Concesionario> comboBoxConce;
	private JComboBox<Coche> comboBoxCoche;

	// Método que devuelve el singleton
	public static GestionVenta getInstance() {
		if (instance == null) {
			instance = new GestionVenta();
		}
		return instance;
	}

	public GestionVenta() {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 0, 0, 0, 0, 0, 0, 0, 0 };
		gridBagLayout.rowHeights = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		gridBagLayout.columnWeights = new double[] { 0.0, 1.0, 1.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		gridBagLayout.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE };
		this.setLayout(gridBagLayout);

		lblGestionDeVentas = new JLabel("GESTION DE VENTAS");
		GridBagConstraints gbc_lblGestionDeVentas = new GridBagConstraints();
		gbc_lblGestionDeVentas.gridwidth = 3;
		gbc_lblGestionDeVentas.insets = new Insets(0, 0, 5, 5);
		gbc_lblGestionDeVentas.gridx = 0;
		gbc_lblGestionDeVentas.gridy = 0;
		this.add(lblGestionDeVentas, gbc_lblGestionDeVentas);

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
		gbc_jtfId.gridwidth = 2;
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

		lblCliente = new JLabel("Cliente:");
		GridBagConstraints gbc_lblCliente = new GridBagConstraints();
		gbc_lblCliente.anchor = GridBagConstraints.EAST;
		gbc_lblCliente.insets = new Insets(0, 0, 5, 5);
		gbc_lblCliente.gridx = 0;
		gbc_lblCliente.gridy = 2;
		this.add(lblCliente, gbc_lblCliente);

		jtfCliente = new JTextField();
		jtfCliente.setEnabled(false);
		GridBagConstraints gbc_jtfCliente = new GridBagConstraints();
		gbc_jtfCliente.insets = new Insets(5, 0, 5, 5);
		gbc_jtfCliente.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfCliente.gridx = 1;
		gbc_jtfCliente.gridy = 2;
		this.add(jtfCliente, gbc_jtfCliente);
		jtfCliente.setColumns(10);

		comboBoxCliente = new JComboBox();
		GridBagConstraints gbc_comboBoxCliente = new GridBagConstraints();
		gbc_comboBoxCliente.insets = new Insets(5, 0, 5, 5);
		gbc_comboBoxCliente.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBoxCliente.gridx = 2;
		gbc_comboBoxCliente.gridy = 2;
		add(comboBoxCliente, gbc_comboBoxCliente);

		lblConce = new JLabel("Concesionario:");
		GridBagConstraints gbc_lblConce = new GridBagConstraints();
		gbc_lblConce.anchor = GridBagConstraints.EAST;
		gbc_lblConce.insets = new Insets(0, 0, 5, 5);
		gbc_lblConce.gridx = 0;
		gbc_lblConce.gridy = 3;
		this.add(lblConce, gbc_lblConce);

		jtfConce = new JTextField();
		jtfConce.setEnabled(false);
		GridBagConstraints gbc_jtfConce = new GridBagConstraints();
		gbc_jtfConce.insets = new Insets(5, 0, 5, 5);
		gbc_jtfConce.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfConce.gridx = 1;
		gbc_jtfConce.gridy = 3;
		this.add(jtfConce, gbc_jtfConce);
		jtfConce.setColumns(10);

		comboBoxConce = new JComboBox();
		GridBagConstraints gbc_comboBoxConce = new GridBagConstraints();
		gbc_comboBoxConce.insets = new Insets(5, 0, 5, 5);
		gbc_comboBoxConce.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBoxConce.gridx = 2;
		gbc_comboBoxConce.gridy = 3;
		add(comboBoxConce, gbc_comboBoxConce);

		lblCoche = new JLabel("Coche:");
		GridBagConstraints gbc_lblCoche = new GridBagConstraints();
		gbc_lblCoche.anchor = GridBagConstraints.EAST;
		gbc_lblCoche.insets = new Insets(0, 0, 5, 5);
		gbc_lblCoche.gridx = 0;
		gbc_lblCoche.gridy = 4;
		add(lblCoche, gbc_lblCoche);

		jtfCoche = new JTextField();
		jtfCoche.setEnabled(false);
		GridBagConstraints gbc_jtfCoche = new GridBagConstraints();
		gbc_jtfCoche.insets = new Insets(5, 0, 5, 5);
		gbc_jtfCoche.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfCoche.gridx = 1;
		gbc_jtfCoche.gridy = 4;
		add(jtfCoche, gbc_jtfCoche);
		jtfCoche.setColumns(10);

		comboBoxCoche = new JComboBox();
		GridBagConstraints gbc_comboBoxCoche = new GridBagConstraints();
		gbc_comboBoxCoche.insets = new Insets(5, 0, 5, 5);
		gbc_comboBoxCoche.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBoxCoche.gridx = 2;
		gbc_comboBoxCoche.gridy = 4;
		add(comboBoxCoche, gbc_comboBoxCoche);

		lblFecha = new JLabel("Fecha:");
		GridBagConstraints gbc_lblFecha = new GridBagConstraints();
		gbc_lblFecha.anchor = GridBagConstraints.EAST;
		gbc_lblFecha.insets = new Insets(0, 0, 5, 5);
		gbc_lblFecha.gridx = 0;
		gbc_lblFecha.gridy = 5;
		add(lblFecha, gbc_lblFecha);

		jtfFecha = new JTextField();
		GridBagConstraints gbc_jtfFecha = new GridBagConstraints();
		gbc_jtfFecha.gridwidth = 2;
		gbc_jtfFecha.insets = new Insets(5, 0, 5, 5);
		gbc_jtfFecha.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfFecha.gridx = 1;
		gbc_jtfFecha.gridy = 5;
		add(jtfFecha, gbc_jtfFecha);
		jtfFecha.setColumns(10);

		lblPrecio = new JLabel("Precio:");
		GridBagConstraints gbc_lblPrecio = new GridBagConstraints();
		gbc_lblPrecio.anchor = GridBagConstraints.EAST;
		gbc_lblPrecio.insets = new Insets(0, 0, 5, 5);
		gbc_lblPrecio.gridx = 0;
		gbc_lblPrecio.gridy = 6;
		add(lblPrecio, gbc_lblPrecio);

		jtfPrecio = new JTextField();
		GridBagConstraints gbc_jtfPrecio = new GridBagConstraints();
		gbc_jtfPrecio.gridwidth = 2;
		gbc_jtfPrecio.insets = new Insets(5, 0, 5, 5);
		gbc_jtfPrecio.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfPrecio.gridx = 1;
		gbc_jtfPrecio.gridy = 6;
		add(jtfPrecio, gbc_jtfPrecio);
		jtfPrecio.setColumns(10);

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
		button_1.setToolTipText("Cargar anterior venta");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mostrarVenta(ControladorVenta.findAnteriorVenta(Integer.parseInt(jtfId.getText())));
			}
		});

		button = new JButton("<<");
		button.setToolTipText("Cargar primera venta");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mostrarVenta(ControladorVenta.findPrimerVenta());
			}
		});
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		panel.add(button);
		panel.add(button_1);

		button_2 = new JButton(">");
		button_2.setToolTipText("Cargar siguiente venta");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mostrarVenta(ControladorVenta.findSiguienteVenta(Integer.parseInt(jtfId.getText())));
			}
		});
		panel.add(button_2);

		button_3 = new JButton(">>");
		button_3.setToolTipText("Cargar última venta");
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mostrarVenta(ControladorVenta.findUltimoVenta());
			}
		});
		panel.add(button_3);

		btnNuevo = new JButton("Nuevo");
		btnNuevo.setToolTipText("Crear nueva venta");
		btnNuevo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				nuevaVenta();
			}
		});
		panel.add(btnNuevo);
		btnGuardar = new JButton("Guardar");
		btnGuardar.setToolTipText("Guardar nueva venta o actualizar venta");
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//////////////////////////
				SimpleDateFormat sdfEntrada = new SimpleDateFormat("yyyy-MM-dd");
				Date date = new Date();
				try {
					date = sdfEntrada.parse(jtfFecha.getText());
				} catch (ParseException ex) {
					ex.printStackTrace();
				}

				SimpleDateFormat sdfSalida = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				//////////////////
				Venta v = new Venta(Integer.parseInt(jtfId.getText()),
						((Cliente) comboBoxCliente.getSelectedItem()).getId(),
						((Concesionario) comboBoxConce.getSelectedItem()).getId(),
						((Coche) comboBoxCoche.getSelectedItem()).getId(), sdfSalida.format(date),
						Float.parseFloat(jtfPrecio.getText()));
				if (ControladorVenta.actualizarVenta(v) == 1) {
					ImageIcon icono = new ImageIcon("./src/capitulo08/Ejercicio01/res/check.png");
					JOptionPane.showMessageDialog(null, "Actualización o inserción correcta", "Gestion de venta",
							JOptionPane.INFORMATION_MESSAGE, icono);
				}
				mostrarVenta(ControladorVenta.findUltimoVenta());
			}
		});
		mostrarVenta(ControladorVenta.findPrimerVenta());
		panel.add(btnGuardar);

		btnBorrar = new JButton("Borrar");
		btnBorrar.setToolTipText("Eliminar venta");
		btnBorrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// yes = 0 no = 1
				if (JOptionPane.showConfirmDialog(null, "¿Desea eliminar el registro?", "Gestión de venta",
						JOptionPane.YES_NO_OPTION) == 0) {
					if (ControladorVenta.borrarVenta(Integer.parseInt(jtfId.getText())) == 1) {
						ImageIcon icono = new ImageIcon("./src/capitulo08/Ejercicio01/res/check.png");
						JOptionPane.showMessageDialog(null, "Borrado correcto", "Gestion de venta",
								JOptionPane.INFORMATION_MESSAGE, icono);
					}
				}
			}
		});
		panel.add(btnBorrar);
		btnNewButton_1 = new JButton("Recargar listas");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				comboBoxCoche.removeAllItems();
				comboBoxCliente.removeAllItems();
				comboBoxConce.removeAllItems();
				mostrarComboBox();
				btnNewButton_1.setFocusPainted(false);
			}
		});
		tglbtnNewToggleButton = new JToggleButton("Desactivar listas");
		tglbtnNewToggleButton.setSelected(true);
		tglbtnNewToggleButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				comboBoxCoche.setEnabled(!comboBoxCoche.isEnabled());
				comboBoxCliente.setEnabled(!comboBoxCliente.isEnabled());
				comboBoxConce.setEnabled(!comboBoxConce.isEnabled());
				tglbtnNewToggleButton.setFocusPainted(false);
				if (tglbtnNewToggleButton.getText().equalsIgnoreCase("Desactivar listas")) {
					tglbtnNewToggleButton.setText("Activar listas");
				} else {
					tglbtnNewToggleButton.setText("Desactivar listas");

				}
			}
		});
		panel.add(tglbtnNewToggleButton);
		panel.add(btnNewButton_1);
		mostrarComboBox();
	}

	/**
	 * 
	 * @param f
	 */
	public void mostrarVenta(Venta v) {
		if (v != null) {
			jtfId.setText("" + v.getId());
			mostrarNombreCliente(v);
			mostrarNombreConce(v);
			mostrarNombreCoche(v);
			jtfFecha.setText(v.getFecha());
			jtfPrecio.setText("" + v.getPrecio());
		}
		if (ControladorVenta.findAnteriorVenta(Integer.parseInt(jtfId.getText())) == null) {
			button.setEnabled(false);
			button_1.setEnabled(false);
		} else {
			button.setEnabled(true);
			button_1.setEnabled(true);
		}
		if (ControladorVenta.findSiguienteVenta(Integer.parseInt(jtfId.getText())) == null) {
			button_2.setEnabled(false);
			button_3.setEnabled(false);
		} else {
			button_2.setEnabled(true);
			button_3.setEnabled(true);
		}
	}

	/**
	 * 
	 * @param c
	 */
	public void mostrarComboBox() {
		List<Cliente> clientes = new ArrayList<Cliente>();
		ControladorVenta.listadoClientes(clientes);
		for (Cliente c : clientes) {
			comboBoxCliente.addItem(c);
		}
		List<Concesionario> conces = new ArrayList<Concesionario>();
		ControladorVenta.listadoConcesionarios(conces);
		for (Concesionario c : conces) {
			comboBoxConce.addItem(c);
		}
		List<Coche> coches = new ArrayList<Coche>();
		ControladorVenta.listadoCoches(coches);
		for (Coche c : coches) {
			comboBoxCoche.addItem(c);
		}
	}

	/**
	 * 
	 */
	public void mostrarNombreCliente(Venta v) {
		jtfCliente.setText(ControladorVenta.findApllNomCliente(v.getIdCli()));
	}

	/**
	 * 
	 */
	public void mostrarNombreCoche(Venta v) {
		jtfCoche.setText(ControladorVenta.findNombreCoche(v.getIdCoche()));
	}

	/**
	 * 
	 */
	public void mostrarNombreConce(Venta v) {
		jtfConce.setText(ControladorVenta.findNombreConce(v.getIdConce()));
	}

	/**
	 * 
	 */
	public void nuevaVenta() {
		jtfId.setText("0");
		jtfCliente.setText("");
		jtfConce.setText("");
		jtfCoche.setText("");
		jtfFecha.setText("");
		jtfPrecio.setText("");
	}
}