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

public class GestionFabricante extends JPanel {

	private static JTextField jtfId;
	private JLabel lblGestionDeFabricantes;
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
	private static GestionFabricante instance = null;

	// Método que devuelve el singleton
	public static GestionFabricante getInstance() {
		if (instance == null) {
			instance = new GestionFabricante();
		}
		return instance;
	}

	public GestionFabricante() {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 0, 0, 0, 0 };
		gridBagLayout.rowHeights = new int[] { 0, 0, 0, 0, 0, 0 };
		gridBagLayout.columnWeights = new double[] { 0.0, 1.0, 0.0, Double.MIN_VALUE };
		gridBagLayout.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE };
		this.setLayout(gridBagLayout);

		lblGestionDeFabricantes = new JLabel("GESTION DE FABRICANTES");
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
		gbc_lblNewLabel.gridx = 2;
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

		panel = new JPanel();
		panel.setBackground(Color.LIGHT_GRAY);
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.insets = new Insets(5, 0, 0, 0);
		gbc_panel.gridwidth = 3;
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 0;
		gbc_panel.gridy = 4;
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