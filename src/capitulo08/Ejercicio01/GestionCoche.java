package capitulo08.Ejercicio01;

import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridBagConstraints;
import javax.swing.JTextField;

import java.awt.Insets;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;
import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.FlowLayout;
import javax.swing.JComboBox;
import javax.swing.JToggleButton;

public class GestionCoche extends JPanel {

	private static JTextField jtfId;
	private JLabel lblGestionDeCoches;
	private JLabel lblNewLabel;
	private JLabel lblFabricante;
	private JLabel lblBastidor;
	private static JTextField jtfFabricante;
	private static JTextField jtfBastidor;
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
	private JComboBox<Fabricante> comboBox;
	private JButton btnNewButton_1;
	private JToggleButton tglbtnNewToggleButton;

	// Método que devuelve el singleton
	public static GestionCoche getInstance() {
		if (instance == null) {
			instance = new GestionCoche();
		}
		return instance;
	}

	public GestionCoche() {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 0, 0, 0, 0, 0 };
		gridBagLayout.rowHeights = new int[] { 0, 0, 0, 0, 0, 0, 0, 0 };
		gridBagLayout.columnWeights = new double[] { 0.0, 1.0, 1.0, 0.0, Double.MIN_VALUE };
		gridBagLayout.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE };
		this.setLayout(gridBagLayout);

		lblGestionDeCoches = new JLabel("GESTION DE COCHES");
		GridBagConstraints gbc_lblGestionDeCoches = new GridBagConstraints();
		gbc_lblGestionDeCoches.gridwidth = 3;
		gbc_lblGestionDeCoches.insets = new Insets(0, 0, 5, 5);
		gbc_lblGestionDeCoches.gridx = 0;
		gbc_lblGestionDeCoches.gridy = 0;
		this.add(lblGestionDeCoches, gbc_lblGestionDeCoches);

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
		gbc_lblNewLabel.gridx = 3;
		gbc_lblNewLabel.gridy = 0;
		this.add(lblNewLabel, gbc_lblNewLabel);

		lblFabricante = new JLabel("Fabricante:");
		GridBagConstraints gbc_lblFabricante = new GridBagConstraints();
		gbc_lblFabricante.anchor = GridBagConstraints.EAST;
		gbc_lblFabricante.insets = new Insets(0, 0, 5, 5);
		gbc_lblFabricante.gridx = 0;
		gbc_lblFabricante.gridy = 2;
		this.add(lblFabricante, gbc_lblFabricante);

		jtfFabricante = new JTextField();
		GridBagConstraints gbc_jtfFabricante = new GridBagConstraints();
		gbc_jtfFabricante.insets = new Insets(5, 0, 5, 5);
		gbc_jtfFabricante.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfFabricante.gridx = 1;
		gbc_jtfFabricante.gridy = 2;
		jtfFabricante.setEnabled(false);
		this.add(jtfFabricante, gbc_jtfFabricante);
		jtfFabricante.setColumns(10);

		comboBox = new JComboBox<Fabricante>();
		GridBagConstraints gbc_comboBox = new GridBagConstraints();
		gbc_comboBox.insets = new Insets(5, 0, 5, 5);
		gbc_comboBox.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox.gridx = 2;
		gbc_comboBox.gridy = 2;
		add(comboBox, gbc_comboBox);

		lblBastidor = new JLabel("Bastidor:");
		GridBagConstraints gbc_lblBastidor = new GridBagConstraints();
		gbc_lblBastidor.anchor = GridBagConstraints.EAST;
		gbc_lblBastidor.insets = new Insets(0, 0, 5, 5);
		gbc_lblBastidor.gridx = 0;
		gbc_lblBastidor.gridy = 3;
		this.add(lblBastidor, gbc_lblBastidor);

		jtfBastidor = new JTextField();
		GridBagConstraints gbc_jtfBastidor = new GridBagConstraints();
		gbc_jtfBastidor.gridwidth = 2;
		gbc_jtfBastidor.insets = new Insets(5, 0, 5, 5);
		gbc_jtfBastidor.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfBastidor.gridx = 1;
		gbc_jtfBastidor.gridy = 3;
		this.add(jtfBastidor, gbc_jtfBastidor);
		jtfBastidor.setColumns(10);

		lblModelo = new JLabel("Modelo:");
		GridBagConstraints gbc_lblModelo = new GridBagConstraints();
		gbc_lblModelo.anchor = GridBagConstraints.EAST;
		gbc_lblModelo.insets = new Insets(0, 0, 5, 5);
		gbc_lblModelo.gridx = 0;
		gbc_lblModelo.gridy = 4;
		add(lblModelo, gbc_lblModelo);

		jtfModelo = new JTextField();
		GridBagConstraints gbc_jtfModelo = new GridBagConstraints();
		gbc_jtfModelo.gridwidth = 2;
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
		gbc_jtfColor.gridwidth = 2;
		gbc_jtfColor.insets = new Insets(5, 0, 5, 5);
		gbc_jtfColor.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfColor.gridx = 1;
		gbc_jtfColor.gridy = 5;
		add(jtfColor, gbc_jtfColor);
		jtfColor.setColumns(10);

		panel = new JPanel();
		panel.setBackground(Color.LIGHT_GRAY);
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.insets = new Insets(5, 0, 0, 0);
		gbc_panel.gridwidth = 4;
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 0;
		gbc_panel.gridy = 6;
		this.add(panel, gbc_panel);

		button_1 = new JButton("<");
		button_1.setToolTipText("Cargar anterior coche");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mostrarCoche(ControladorCoche.findAnteriorCoche(Integer.parseInt(jtfId.getText())));
				button_1.setFocusPainted(false);
			}
		});

		button = new JButton("<<");
		button.setToolTipText("Cargar primer coche");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mostrarCoche(ControladorCoche.findPrimerCoche());
				button.setFocusPainted(false);
			}
		});
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		panel.add(button);
		panel.add(button_1);

		button_2 = new JButton(">");
		button_2.setToolTipText("Cargar siguiente coche");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mostrarCoche(ControladorCoche.findSiguienteCoche(Integer.parseInt(jtfId.getText())));
				button_2.setFocusPainted(false);
			}
		});
		panel.add(button_2);

		button_3 = new JButton(">>");
		button_3.setToolTipText("Cargar último coche");
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mostrarCoche(ControladorCoche.findUltimoCoche());
				button_3.setFocusPainted(false);
			}
		});
		panel.add(button_3);

		btnNuevo = new JButton("Nuevo");
		btnNuevo.setToolTipText("Crear nuevo coche");
		btnNuevo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				nuevoCoche();
				jtfFabricante.setEnabled(false);
				comboBox.setEnabled(true);
				btnNuevo.setFocusPainted(false);
			}
		});
		panel.add(btnNuevo);
		btnGuardar = new JButton("Guardar");
		btnGuardar.setToolTipText("Guardar nuevo coche o actualizar coche");
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Coche c = new Coche(Integer.parseInt(jtfId.getText()),
						((Fabricante) comboBox.getSelectedItem()).getId(), jtfBastidor.getText(), jtfModelo.getText(),
						jtfColor.getText());
				if (ControladorCoche.actualizarCoche(c) == 1) {
					ImageIcon icono = new ImageIcon("./src/capitulo08/Ejercicio01/res/check.png");
					JOptionPane.showMessageDialog(null, "Actualización o inserción correcta", "Gestion de coches",
							JOptionPane.INFORMATION_MESSAGE, icono);
				}
				mostrarCoche(ControladorCoche.findUltimoCoche());
				btnGuardar.setFocusPainted(false);
			}
		});
		mostrarCoche(ControladorCoche.findPrimerCoche());
		panel.add(btnGuardar);

		btnBorrar = new JButton("Borrar");
		btnBorrar.setToolTipText("Eliminar coche");
		btnBorrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// yes = 0 no = 1
				if (JOptionPane.showConfirmDialog(null, "¿Desea eliminar el registro?", "Gestión de coches",
						JOptionPane.YES_NO_OPTION) == 0) {
					if (ControladorCoche.borrarCoche(Integer.parseInt(jtfId.getText())) == 1) {
						ImageIcon icono = new ImageIcon("./src/capitulo08/Ejercicio01/res/check.png");
						JOptionPane.showMessageDialog(null, "Borrado correcto", "Gestion de coches",
								JOptionPane.INFORMATION_MESSAGE, icono);
					}
				}
				btnBorrar.setFocusPainted(false);
			}
		});
		panel.add(btnBorrar);

		btnNewButton_1 = new JButton("Recargar lista de fabricantes");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				comboBox.removeAllItems();
				mostrarComboBox();
				btnNewButton_1.setFocusPainted(false);
			}
		});

		tglbtnNewToggleButton = new JToggleButton("Desactivar desplegable");
		tglbtnNewToggleButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				comboBox.setEnabled(!comboBox.isEnabled());
				tglbtnNewToggleButton.setFocusPainted(false);
				if (tglbtnNewToggleButton.getText().equalsIgnoreCase("Desactivar desplegable")) {
					tglbtnNewToggleButton.setText("Activar desplegable");
				} else {
					tglbtnNewToggleButton.setText("Desactivar desplegable");

				}
			}
		});
		tglbtnNewToggleButton.setSelected(true);
		panel.add(tglbtnNewToggleButton);
		panel.add(btnNewButton_1);
		mostrarCoche(ControladorCoche.findPrimerCoche());
		mostrarComboBox();
	}

	/**
	 * 
	 * @param c
	 */
	public void mostrarComboBox() {
		List<Fabricante> fabricantes = new ArrayList<Fabricante>();
		ControladorCoche.listadoFabricantes(fabricantes);
		for (Fabricante f : fabricantes) {
			comboBox.addItem(f);
		}
	}

	/**
	 * 
	 * @param f
	 */
	public void mostrarCoche(Coche c) {
		if (c != null) {
			jtfId.setText("" + c.getId());
			mostrarNombreFabricante(c);
			jtfBastidor.setText(c.getBastidor());
			jtfModelo.setText(c.getModelo());
			jtfColor.setText(c.getColor());
		}

		if (ControladorCoche.findAnteriorCoche(Integer.parseInt(jtfId.getText())) == null) {
			button.setEnabled(false);
			button_1.setEnabled(false);
		} else {
			button.setEnabled(true);
			button_1.setEnabled(true);
		}
		if (ControladorCoche.findSiguienteCoche(Integer.parseInt(jtfId.getText())) == null) {
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
	public void mostrarNombreFabricante(Coche c) {
		jtfFabricante.setText(ControladorCoche.findNombreFabricante(c.getIdFab()));
	}

	/**
	 * 
	 */
	public void nuevoCoche() {
		jtfId.setText("0");
		jtfFabricante.setText("");
		jtfBastidor.setText("");
		jtfModelo.setText("");
		jtfColor.setText("");

	}
}