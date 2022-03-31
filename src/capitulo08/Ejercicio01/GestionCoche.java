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

import javax.swing.JPanel;
import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.FlowLayout;
import javax.swing.JProgressBar;

public class GestionCoche extends JPanel {

	private static JTextField jtfId;
	private JLabel lblGestionDeFabricantes;
	private JLabel lblNewLabel;
	private JLabel lblFabricante;
	private JLabel lblBastidor;
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
	private static GestionCoche instance = null;
	private JLabel lblModelo;
	private JTextField jtfModelo;
	private JLabel lblColor;
	private JTextField jtfColor;

	// Método que devuelve el singleton
	public static GestionCoche getInstance() {
		if (instance == null) {
			instance = new GestionCoche();
		}
		return instance;
	}

	public GestionCoche() {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 0, 0, 0, 0, 0, 0 };
		gridBagLayout.rowHeights = new int[] { 0, 0, 0, 0, 0, 0, 0, 0 };
		gridBagLayout.columnWeights = new double[] { 0.0, 1.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		gridBagLayout.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE };
		this.setLayout(gridBagLayout);

		lblGestionDeFabricantes = new JLabel("GESTION DE COCHES");
		GridBagConstraints gbc_lblGestionDeFabricantes = new GridBagConstraints();
		gbc_lblGestionDeFabricantes.gridwidth = 2;
		gbc_lblGestionDeFabricantes.insets = new Insets(0, 0, 5, 5);
		gbc_lblGestionDeFabricantes.gridx = 0;
		gbc_lblGestionDeFabricantes.gridy = 0;
		this.add(lblGestionDeFabricantes, gbc_lblGestionDeFabricantes);

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
		gbc_lblNewLabel.gridx = 4;
		gbc_lblNewLabel.gridy = 0;
		this.add(lblNewLabel, gbc_lblNewLabel);

		lblFabricante = new JLabel("Fabricante:");
		GridBagConstraints gbc_lblFabricante = new GridBagConstraints();
		gbc_lblFabricante.anchor = GridBagConstraints.EAST;
		gbc_lblFabricante.insets = new Insets(0, 0, 5, 5);
		gbc_lblFabricante.gridx = 0;
		gbc_lblFabricante.gridy = 2;
		this.add(lblFabricante, gbc_lblFabricante);

		jtfCif = new JTextField();
		GridBagConstraints gbc_jtfCif = new GridBagConstraints();
		gbc_jtfCif.insets = new Insets(5, 0, 5, 5);
		gbc_jtfCif.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfCif.gridx = 1;
		gbc_jtfCif.gridy = 2;
		this.add(jtfCif, gbc_jtfCif);
		jtfCif.setColumns(10);

		lblBastidor = new JLabel("Bastidor:");
		GridBagConstraints gbc_lblBastidor = new GridBagConstraints();
		gbc_lblBastidor.anchor = GridBagConstraints.EAST;
		gbc_lblBastidor.insets = new Insets(0, 0, 5, 5);
		gbc_lblBastidor.gridx = 0;
		gbc_lblBastidor.gridy = 3;
		this.add(lblBastidor, gbc_lblBastidor);

		jtfNombre = new JTextField();
		GridBagConstraints gbc_jtfNombre = new GridBagConstraints();
		gbc_jtfNombre.insets = new Insets(5, 0, 5, 5);
		gbc_jtfNombre.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfNombre.gridx = 1;
		gbc_jtfNombre.gridy = 3;
		this.add(jtfNombre, gbc_jtfNombre);
		jtfNombre.setColumns(10);

		lblModelo = new JLabel("Modelo:");
		GridBagConstraints gbc_lblModelo = new GridBagConstraints();
		gbc_lblModelo.anchor = GridBagConstraints.EAST;
		gbc_lblModelo.insets = new Insets(0, 0, 5, 5);
		gbc_lblModelo.gridx = 0;
		gbc_lblModelo.gridy = 4;
		add(lblModelo, gbc_lblModelo);

		jtfModelo = new JTextField();
		GridBagConstraints gbc_jtfModelo = new GridBagConstraints();
		gbc_jtfModelo.insets = new Insets(5, 0, 5, 5);
		gbc_jtfModelo.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfModelo.gridx = 1;
		gbc_jtfModelo.gridy = 4;
		add(jtfModelo, gbc_jtfModelo);
		jtfModelo.setColumns(10);

		lblColor = new JLabel("Color:");
		GridBagConstraints gbc_lblColor = new GridBagConstraints();
		gbc_lblColor.anchor = GridBagConstraints.EAST;
		gbc_lblColor.insets = new Insets(0, 0, 5, 5);
		gbc_lblColor.gridx = 0;
		gbc_lblColor.gridy = 5;
		add(lblColor, gbc_lblColor);
		
		jtfColor = new JTextField();
		GridBagConstraints gbc_jtfColor = new GridBagConstraints();
		gbc_jtfColor.insets = new Insets(0, 0, 5, 5);
		gbc_jtfColor.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfColor.gridx = 1;
		gbc_jtfColor.gridy = 5;
		add(jtfColor, gbc_jtfColor);
		jtfColor.setColumns(10);

		panel = new JPanel();
		panel.setBackground(Color.LIGHT_GRAY);
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.insets = new Insets(5, 0, 0, 0);
		gbc_panel.gridwidth = 5;
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 0;
		gbc_panel.gridy = 6;
		this.add(panel, gbc_panel);

		button_1 = new JButton("<");
		button_1.setToolTipText("Cargar anterior fabricante");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				listarAnteriorFabricante();
				comprobarEstadoBotones();
			}
		});

		button = new JButton("<<");
		button.setToolTipText("Cargar primer fabricante");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				listarPrimerFabricante();
				comprobarEstadoBotones();
			}
		});
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		panel.add(button);
		panel.add(button_1);

		button_2 = new JButton(">");
		button_2.setToolTipText("Cargar siguiente fabricante");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				listarSiguienteFabricante();
				comprobarEstadoBotones();
			}
		});
		panel.add(button_2);

		button_3 = new JButton(">>");
		button_3.setToolTipText("Cargar último fabricante");
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				listarUltimoFabricante();
				comprobarEstadoBotones();
			}
		});
		panel.add(button_3);

		btnNuevo = new JButton("Nuevo");
		btnNuevo.setToolTipText("Crear nuevo fabricante");
		btnNuevo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				nuevoFabricante();
			}
		});
		panel.add(btnNuevo);
		btnGuardar = new JButton("Guardar");
		btnGuardar.setToolTipText("Guardar nuevo fabricante o actualizar fabricante");
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actualizarFabricantes();
				listarUltimoFabricante();
			}
		});
		listarPrimerFabricante();
		comprobarEstadoBotones();
		panel.add(btnGuardar);

		btnBorrar = new JButton("Borrar");
		btnBorrar.setToolTipText("Eliminar fabricante");
		btnBorrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Dialogo dialog = new Dialogo();
					dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					dialog.setVisible(true);
				} catch (Exception ex) {
					ex.printStackTrace();
				}
			}

		});
		panel.add(btnBorrar);
	}

	/**
	 * 
	 */
	public void listarPrimerFabricante() {
		try {
			Connection con = ConnectionManager.getConexion();
			Statement s = con.createStatement();
			ResultSet rs = s.executeQuery("select * from fabricante order by id limit 1");
			if (rs.next()) {
				jtfId.setText(rs.getString(1));
				jtfCif.setText(rs.getString(2));
				jtfNombre.setText(rs.getString(3));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	/**
	 * 
	 */
	public void comprobarEstadoBotones() {
		try {
			Connection con = ConnectionManager.getConexion();
			Statement s = con.createStatement();
			ResultSet rs = s.executeQuery("select id from fabricante order by id limit 1");
			// Menor id
			if (rs.next()) {
				if (jtfId.getText().equalsIgnoreCase(rs.getString(1))) {
					button.setEnabled(false);
					button_1.setEnabled(false);
				} else {
					button.setEnabled(true);
					button_1.setEnabled(true);
				}
			}
			ResultSet rs2 = s.executeQuery("select id from fabricante order by id desc limit 1");
			// Mayor id
			if (rs2.next()) {
				if (jtfId.getText().equalsIgnoreCase(rs2.getString(1))) {
					button_2.setEnabled(false);
					button_3.setEnabled(false);
				} else {
					button_2.setEnabled(true);
					button_3.setEnabled(true);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	/**
	 * 
	 */
	public void actualizarFabricantes() {
		int rowAffected;
		int id = 0;
		try {
			Connection con = ConnectionManager.getConexion();
			Statement s = con.createStatement();
			ResultSet rs = s.executeQuery("select max(id) from fabricante;");
			if (rs.next()) {
				id = (rs.getInt(1) + 1);
			}
			// si entra en este if quiere decir k voy a insertar
			if (jtfId.getText().equalsIgnoreCase("0")) {
				rowAffected = s.executeUpdate("insert into fabricante values(" + id + "," + "'" + jtfCif.getText() + "'"
						+ "," + "'" + jtfNombre.getText() + "'" + ");");
				if (rowAffected >= 1) {
					ImageIcon icono = new ImageIcon("./src/capitulo08/Ejercicio01/res/check.png");
					JOptionPane.showMessageDialog(null, "Actualización o inserción correcta", "Gestion de fabricantes",
							JOptionPane.INFORMATION_MESSAGE, icono);
				} else {
					JOptionPane.showMessageDialog(null, "Actualización o inserción incorrecta",
							"Gestion de fabricantes", 2);
				}
			} else {
				// si entra en este else quiere decir k voy a actualizar
				rowAffected = s.executeUpdate("update fabricante set nombre = " + "'" + jtfNombre.getText() + "'" + ","
						+ "cif = " + "'" + jtfCif.getText() + "'" + " where id = " + jtfId.getText() + ";");
				if (rowAffected >= 1) {
					ImageIcon icono = new ImageIcon("./src/capitulo08/Ejercicio01/res/check.png");
					JOptionPane.showMessageDialog(null, "Actualización o inserción correcta", "Gestion de fabricantes",
							JOptionPane.INFORMATION_MESSAGE, icono);
				} else {
					JOptionPane.showMessageDialog(null, "Actualización o inserción incorrecta",
							"Gestion de fabricantes", 2);
				}
			}
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Actualización o inserción incorrecta", "Gestion de fabricantes", 2);
		}
	}

	/**
	 * 
	 */
	public void listarUltimoFabricante() {
		try {
			Connection con = ConnectionManager.getConexion();
			Statement s = con.createStatement();
			ResultSet rs = s.executeQuery("select * from fabricante order by id desc limit 1");
			if (rs.next()) {
				jtfId.setText(rs.getString(1));
				jtfCif.setText(rs.getString(2));
				jtfNombre.setText(rs.getString(3));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	/**
	 * 
	 */
	public void listarSiguienteFabricante() {
		String id = "";
		id = jtfId.getText();
		try {
			Connection con = ConnectionManager.getConexion();
			Statement s = con.createStatement();
			ResultSet rs = s.executeQuery("select * from fabricante where id > " + id + " order by id asc limit 1");
			if (rs.next()) {
				jtfId.setText(rs.getString(1));
				jtfCif.setText(rs.getString(2));
				jtfNombre.setText(rs.getString(3));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	/**
	 * 
	 */
	public void listarAnteriorFabricante() {
		String id = "";
		id = jtfId.getText();
		try {
			Connection con = ConnectionManager.getConexion();
			Statement s = con.createStatement();
			ResultSet rs = s.executeQuery("select * from fabricante where id < " + id + " order by id desc limit 1");
			if (rs.next()) {
				jtfId.setText(rs.getString(1));
				jtfCif.setText(rs.getString(2));
				jtfNombre.setText(rs.getString(3));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public static void borrarFabricante() {
		String id = "";
		int rowAffected;
		try {
			Connection con = ConnectionManager.getConexion();
			Statement s = con.createStatement();
			id = jtfId.getText();

			ResultSet rs = s.executeQuery("select id from fabricante order by id limit 1");
			// Menor id
			if (rs.next()) {
				if (jtfId.getText().equalsIgnoreCase(rs.getString(1))) {
					ResultSet rs3 = s
							.executeQuery("select * from fabricante where id > " + id + " order by id asc limit 1");
					if (rs3.next()) {
						jtfId.setText(rs3.getString(1));
						jtfCif.setText(rs3.getString(2));
						jtfNombre.setText(rs3.getString(3));
					}
				}
			} else {
				jtfId.setText("0");
				jtfCif.setText("");
				jtfNombre.setText("");
			}
			ResultSet rs2 = s.executeQuery("select id from fabricante order by id desc limit 1");
			// Mayor id
			if (rs2.next()) {
				if (jtfId.getText().equalsIgnoreCase(rs2.getString(1))) {
					ResultSet rs4 = s
							.executeQuery("select * from fabricante where id < " + id + " order by id desc limit 1");
					if (rs4.next()) {
						jtfId.setText(rs4.getString(1));
						jtfCif.setText(rs4.getString(2));
						jtfNombre.setText(rs4.getString(3));
					}
				}
			} else {
				jtfId.setText("0");
				jtfCif.setText("");
				jtfNombre.setText("");
			}
			rowAffected = s.executeUpdate("delete from fabricante where id = " + id + ";");
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "No se pudo borrar el registro", "Gestion de fabricantes", 0);
		}
	}

	/**
	 * 
	 */
	public void nuevoFabricante() {
		jtfId.setText("0");
		jtfCif.setText("");
		jtfNombre.setText("");

	}
}