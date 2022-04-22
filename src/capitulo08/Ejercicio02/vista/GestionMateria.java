package capitulo08.Ejercicio02.vista;

import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridBagConstraints;
import javax.swing.JTextField;

import capitulo07.ejercicioCRUDCompleto.ConnectionManager;
import capitulo08.Ejercicio02.controladores.ControladorCurso;
import capitulo08.Ejercicio02.controladores.ControladorMateria;
import capitulo08.Ejercicio02.entidades.Curso;
import capitulo08.Ejercicio02.entidades.Materia;
import capitulo08.ejercicio01.Coche;
import capitulo08.ejercicio01.ControladorCoche;
import capitulo08.ejercicio01.Fabricante;

import java.awt.Insets;
import java.sql.Connection;
import java.sql.ResultSet;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
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
import javax.swing.JComboBox;

public class GestionMateria extends JPanel {

	public static JTextField jtfId;
	private JLabel lblGestionDeFabricantes;
	private JLabel lblNewLabel;
	private JLabel lblCif;
	public static JTextField jtfNombre;

	// Variable que actúa como Singleton
	private static GestionMateria instance = null;
	private JLabel lblNewLabel_1;
	public static JTextField jtfAcronimo;
	private JLabel lblNewLabel_2;
	public static JComboBox<Curso> comboBox;

	// Método que devuelve el singleton
	public static GestionMateria getInstance() {
		if (instance == null) {
			instance = new GestionMateria();
		}
		return instance;
	}

	public GestionMateria() {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 0, 0, 0, 0 };
		gridBagLayout.rowHeights = new int[] { 0, 0, 0, 0, 0, 0 };
		gridBagLayout.columnWeights = new double[] { 0.0, 1.0, 0.0, Double.MIN_VALUE };
		gridBagLayout.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		this.setLayout(gridBagLayout);

		lblGestionDeFabricantes = new JLabel("GESTION DE MATERIAS");
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

		lblCif = new JLabel("Nombre:");
		GridBagConstraints gbc_lblCif = new GridBagConstraints();
		gbc_lblCif.anchor = GridBagConstraints.EAST;
		gbc_lblCif.insets = new Insets(0, 0, 5, 5);
		gbc_lblCif.gridx = 0;
		gbc_lblCif.gridy = 2;
		this.add(lblCif, gbc_lblCif);

		jtfNombre = new JTextField();
		GridBagConstraints gbc_jtfNombre = new GridBagConstraints();
		gbc_jtfNombre.insets = new Insets(5, 0, 5, 5);
		gbc_jtfNombre.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfNombre.gridx = 1;
		gbc_jtfNombre.gridy = 2;
		this.add(jtfNombre, gbc_jtfNombre);
		jtfNombre.setColumns(40);

		lblNewLabel_1 = new JLabel("Acrónimo:");
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 0;
		gbc_lblNewLabel_1.gridy = 3;
		add(lblNewLabel_1, gbc_lblNewLabel_1);

		jtfAcronimo = new JTextField();
		GridBagConstraints gbc_jtfAcronimo = new GridBagConstraints();
		gbc_jtfAcronimo.insets = new Insets(0, 0, 5, 5);
		gbc_jtfAcronimo.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfAcronimo.gridx = 1;
		gbc_jtfAcronimo.gridy = 3;
		add(jtfAcronimo, gbc_jtfAcronimo);
		jtfAcronimo.setColumns(10);

		lblNewLabel_2 = new JLabel("Curso:");
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 0, 5);
		gbc_lblNewLabel_2.gridx = 0;
		gbc_lblNewLabel_2.gridy = 4;
		add(lblNewLabel_2, gbc_lblNewLabel_2);

		comboBox = new JComboBox<Curso>();
		GridBagConstraints gbc_comboBox = new GridBagConstraints();
		gbc_comboBox.insets = new Insets(0, 0, 0, 5);
		gbc_comboBox.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox.gridx = 1;
		gbc_comboBox.gridy = 4;
		add(comboBox, gbc_comboBox);
		mostrarComboBox();
		mostrarMateria(ControladorMateria.findPrimerMateria());
	}

	/**
	 * 
	 * @param c
	 */
	public void mostrarComboBox() {
		List<Curso> cursos = new ArrayList<Curso>();
		ControladorMateria.listadoCursos(cursos);
		for (Curso c : cursos) {
			comboBox.addItem(c);
		}
	}

	/**
	 * 
	 */
	public static void mostrarNombreCurso(Materia m) {
		for (int i = 0; i < comboBox.getItemCount(); i++) {
			if (comboBox.getItemAt(i).getId() == m.getIdCurso()) {
				comboBox.setSelectedIndex(i);
			}
		}
	}

	/**
	 * 
	 * @param f
	 */
	public static void mostrarMateria(Materia m) {
		if (m != null) {
			jtfId.setText("" + m.getId());
			jtfNombre.setText(m.getNombre());
			jtfAcronimo.setText(m.getAcronimo());
			mostrarNombreCurso(m);
		}
		if (ControladorMateria.findAnteriorMateria(Integer.parseInt(jtfId.getText())) == null) {
			PanelAInsertarEnJDialog.btnNewButton.setEnabled(false);
			PanelAInsertarEnJDialog.btnNewButton_1.setEnabled(false);
		} else {
			PanelAInsertarEnJDialog.btnNewButton.setEnabled(true);
			PanelAInsertarEnJDialog.btnNewButton_1.setEnabled(true);
		}
		if (ControladorMateria.findSiguienteMateria(Integer.parseInt(jtfId.getText())) == null) {
			PanelAInsertarEnJDialog.btnNewButton_2.setEnabled(false);
			PanelAInsertarEnJDialog.btnNewButton_3.setEnabled(false);
		} else {
			PanelAInsertarEnJDialog.btnNewButton_2.setEnabled(true);
			PanelAInsertarEnJDialog.btnNewButton_3.setEnabled(true);
		}
	}
}