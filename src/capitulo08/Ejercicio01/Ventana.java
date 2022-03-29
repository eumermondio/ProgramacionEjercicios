package capitulo08.Ejercicio01;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import javax.swing.JTextField;

import capitulo07.EjercicioCRUDCompleto.ConnectionManager;

import java.awt.Insets;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JDialog;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.FlowLayout;

public class Ventana {

	private JFrame frame;
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

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ventana window = new Ventana();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Ventana() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 499, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 0, 0, 0, 0 };
		gridBagLayout.rowHeights = new int[] { 0, 0, 0, 0, 0, 0 };
		gridBagLayout.columnWeights = new double[] { 0.0, 1.0, 0.0, Double.MIN_VALUE };
		gridBagLayout.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE };
		frame.getContentPane().setLayout(gridBagLayout);

		lblGestionDeFabricantes = new JLabel("GESTION DE FABRICANTES");
		GridBagConstraints gbc_lblGestionDeFabricantes = new GridBagConstraints();
		gbc_lblGestionDeFabricantes.gridwidth = 2;
		gbc_lblGestionDeFabricantes.insets = new Insets(0, 0, 5, 5);
		gbc_lblGestionDeFabricantes.gridx = 0;
		gbc_lblGestionDeFabricantes.gridy = 0;
		frame.getContentPane().add(lblGestionDeFabricantes, gbc_lblGestionDeFabricantes);

		JLabel lblId = new JLabel("Id:");
		GridBagConstraints gbc_lblId = new GridBagConstraints();
		gbc_lblId.insets = new Insets(0, 0, 5, 5);
		gbc_lblId.anchor = GridBagConstraints.EAST;
		gbc_lblId.gridx = 0;
		gbc_lblId.gridy = 1;
		frame.getContentPane().add(lblId, gbc_lblId);

		jtfId = new JTextField();
		jtfId.setEnabled(false);
		GridBagConstraints gbc_jtfId = new GridBagConstraints();
		gbc_jtfId.insets = new Insets(0, 0, 5, 5);
		gbc_jtfId.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfId.gridx = 1;
		gbc_jtfId.gridy = 1;
		frame.getContentPane().add(jtfId, gbc_jtfId);
		jtfId.setColumns(10);

		lblNewLabel = new JLabel("      ");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel.gridx = 2;
		gbc_lblNewLabel.gridy = 0;
		frame.getContentPane().add(lblNewLabel, gbc_lblNewLabel);

		lblCif = new JLabel("Cif:");
		GridBagConstraints gbc_lblCif = new GridBagConstraints();
		gbc_lblCif.anchor = GridBagConstraints.EAST;
		gbc_lblCif.insets = new Insets(0, 0, 5, 5);
		gbc_lblCif.gridx = 0;
		gbc_lblCif.gridy = 2;
		frame.getContentPane().add(lblCif, gbc_lblCif);

		jtfCif = new JTextField();
		GridBagConstraints gbc_jtfCif = new GridBagConstraints();
		gbc_jtfCif.insets = new Insets(0, 0, 5, 5);
		gbc_jtfCif.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfCif.gridx = 1;
		gbc_jtfCif.gridy = 2;
		frame.getContentPane().add(jtfCif, gbc_jtfCif);
		jtfCif.setColumns(10);

		lblNombre = new JLabel("Nombre:");
		GridBagConstraints gbc_lblNombre = new GridBagConstraints();
		gbc_lblNombre.anchor = GridBagConstraints.EAST;
		gbc_lblNombre.insets = new Insets(0, 0, 5, 5);
		gbc_lblNombre.gridx = 0;
		gbc_lblNombre.gridy = 3;
		frame.getContentPane().add(lblNombre, gbc_lblNombre);

		jtfNombre = new JTextField();
		GridBagConstraints gbc_jtfNombre = new GridBagConstraints();
		gbc_jtfNombre.insets = new Insets(0, 0, 5, 5);
		gbc_jtfNombre.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfNombre.gridx = 1;
		gbc_jtfNombre.gridy = 3;
		frame.getContentPane().add(jtfNombre, gbc_jtfNombre);
		jtfNombre.setColumns(10);

		panel = new JPanel();
		panel.setBackground(Color.LIGHT_GRAY);
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.insets = new Insets(5, 0, 0, 0);
		gbc_panel.gridwidth = 3;
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 0;
		gbc_panel.gridy = 4;
		frame.getContentPane().add(panel, gbc_panel);

		button_1 = new JButton("<");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				listarAnteriorFabricante();
			}
		});

		button = new JButton("<<");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				listarPrimerFabricante();
			}
		});
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		panel.add(button);
		panel.add(button_1);

		button_2 = new JButton(">");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				listarSiguienteFabricante();
			}
		});
		panel.add(button_2);

		button_3 = new JButton(">>");
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				listarUltimoFabricante();
			}
		});
		panel.add(button_3);

		btnNuevo = new JButton("Nuevo");
		btnNuevo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				nuevoFabricante();
			}
		});
		panel.add(btnNuevo);

		btnGuardar = new JButton("Guardar");
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actualizarFabricantes();
			}
		});
		panel.add(btnGuardar);

		listarPrimerFabricante();

		btnBorrar = new JButton("Borrar");
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
	public void actualizarFabricantes() {
		int id = 0;
		int rowAffected;
		try {
			Connection con = ConnectionManager.getConexion();
			Statement s = con.createStatement();
			rowAffected = s.executeUpdate("update fabricante set nombre = " + "'" + jtfNombre.getText() + "'" + ","
					+ "cif = " + "'" + jtfCif.getText() + "'" + " where id = " + jtfId.getText() + ";");
		} catch (SQLException e) {
			e.printStackTrace();
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
			rowAffected = s.executeUpdate("delete from fabricante where id = " + id + ";");
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
	public void nuevoFabricante() {
		int id = 0;
		int rowAffected;
		String cif = "", nombre = "";

		cif = jtfCif.getText();
		nombre = jtfNombre.getText();
		try {
			Connection con = ConnectionManager.getConexion();
			Statement s;
			s = con.createStatement();
			ResultSet rs = s.executeQuery("select max(id) from fabricante;");
			if (rs.next()) {
				id = (rs.getInt(1) + 1);
			}
			Statement s2 = con.createStatement();
			rowAffected = s.executeUpdate(
					"insert into fabricante values(" + id + "," + "'" + cif + "'" + "," + "'" + nombre + "'" + ");");
			listarUltimoFabricante();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
}