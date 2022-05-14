package capitulo08.Ejercicio02.parte2;

import java.awt.EventQueue;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;

import javax.swing.JPanel;

import capitulo08.Ejercicio02.controladores.ControladorEstudiante;
import capitulo08.Ejercicio02.controladores.ControladorGeneral;
import capitulo08.Ejercicio02.entidades.Estudiante;
import capitulo08.Ejercicio02.entidades.Materia;
import capitulo08.Ejercicio02.entidades.Nota;
import capitulo08.Ejercicio02.entidades.Profesor;
import capitulo08.Ejercicio02.entidades.Sexo;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.border.Border;
import javax.swing.JRadioButton;

public class Principal {

	private JFrame frmGestionDeNotas;
	private JPanel panel;
	private JComboBox<Materia> comboBoxMateria;
	private JComboBox<Profesor> comboBoxProfesor;
	private JButton btnRefrescarAlumnos;
	private JButton btnGuardarLasNotas;
	private JScrollPane scrollPane;
	private JPanel panel_1;
	List<Estudiante> estudiantes;
	private List<PanelNotas> paneles = new ArrayList<PanelNotas>();
	private JRadioButton rdbtnNewRadioButton;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Principal window = new Principal();
					window.frmGestionDeNotas.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Principal() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmGestionDeNotas = new JFrame();
		frmGestionDeNotas.setTitle("Gestion de notas");
		frmGestionDeNotas.setBounds(100, 100, 450, 300);
		frmGestionDeNotas.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmGestionDeNotas.getContentPane().setLayout(new BorderLayout(0, 0));

		panel = new JPanel();
		panel.setBackground(Color.CYAN);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 0, 0, 0, 0 };
		gridBagLayout.rowHeights = new int[] { 0, 0, 0, 0 };
		gridBagLayout.columnWeights = new double[] { 0.0, 1.0, 0.0, Double.MIN_VALUE };
		gridBagLayout.rowWeights = new double[] { 0.0, 0.0, 0.0, Double.MIN_VALUE };
		panel.setLayout(gridBagLayout);

		JLabel lblMateria = new JLabel("Materia:");
		GridBagConstraints gbc_lblMateria = new GridBagConstraints();
		gbc_lblMateria.anchor = GridBagConstraints.EAST;
		gbc_lblMateria.insets = new Insets(0, 0, 5, 5);
		gbc_lblMateria.gridx = 0;
		gbc_lblMateria.gridy = 0;
		panel.add(lblMateria, gbc_lblMateria);

		comboBoxMateria = new JComboBox<Materia>();
		GridBagConstraints gbc_comboBoxMateria = new GridBagConstraints();
		gbc_comboBoxMateria.insets = new Insets(0, 0, 5, 5);
		gbc_comboBoxMateria.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBoxMateria.gridx = 1;
		gbc_comboBoxMateria.gridy = 0;
		panel.add(comboBoxMateria, gbc_comboBoxMateria);

		JLabel lblProfesor = new JLabel("Profesor:");
		GridBagConstraints gbc_lblProfesor = new GridBagConstraints();
		gbc_lblProfesor.anchor = GridBagConstraints.EAST;
		gbc_lblProfesor.insets = new Insets(0, 0, 5, 5);
		gbc_lblProfesor.gridx = 0;
		gbc_lblProfesor.gridy = 1;
		panel.add(lblProfesor, gbc_lblProfesor);

		comboBoxProfesor = new JComboBox<Profesor>();
		comboBoxProfesor.setFont(new Font("Dialog", Font.BOLD, 10));
		comboBoxProfesor.setMaximumRowCount(30);
		GridBagConstraints gbc_comboBoxProfesor = new GridBagConstraints();
		gbc_comboBoxProfesor.insets = new Insets(0, 0, 5, 5);
		gbc_comboBoxProfesor.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBoxProfesor.gridx = 1;
		gbc_comboBoxProfesor.gridy = 1;
		panel.add(comboBoxProfesor, gbc_comboBoxProfesor);

		btnRefrescarAlumnos = new JButton("Refrescar alumnos");
		btnRefrescarAlumnos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cargarEstudiantes();
			}
		});
		GridBagConstraints gbc_btnRefrescarAlumnos = new GridBagConstraints();
		gbc_btnRefrescarAlumnos.insets = new Insets(0, 0, 5, 0);
		gbc_btnRefrescarAlumnos.gridx = 2;
		gbc_btnRefrescarAlumnos.gridy = 1;
		panel.add(btnRefrescarAlumnos, gbc_btnRefrescarAlumnos);
		frmGestionDeNotas.getContentPane().add(panel, BorderLayout.NORTH);

		btnGuardarLasNotas = new JButton("Guardar las notas de los alumnos");
		btnGuardarLasNotas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				for (PanelNotas p : paneles) {
					if (ControladorGeneral.guardarNota(new Nota(ControladorGeneral.maxId("valoracionmateria"),
							((Profesor) comboBoxProfesor.getSelectedItem()).getId(), p.getIdEstudiante(),
							((Materia) comboBoxMateria.getSelectedItem()).getId(),
							Integer.parseInt(p.getNota()))) != 0) {
						JOptionPane.showMessageDialog(null, "Guardado correcto");
					}
				}
			}
		});
		GridBagConstraints gbc_btnGuardarLasNotas = new GridBagConstraints();
		gbc_btnGuardarLasNotas.insets = new Insets(0, 0, 0, 5);
		gbc_btnGuardarLasNotas.gridx = 6;
		gbc_btnGuardarLasNotas.gridy = 4;
		frmGestionDeNotas.getContentPane().add(btnGuardarLasNotas, BorderLayout.SOUTH);

		scrollPane = new JScrollPane();
		frmGestionDeNotas.getContentPane().add(scrollPane, BorderLayout.CENTER);

		panel_1 = new JPanel();
		scrollPane.setViewportView(panel_1);
		GridBagLayout gbl_panel_1 = new GridBagLayout();
		gbl_panel_1.columnWidths = new int[] { 0, 0 };
		gbl_panel_1.rowHeights = new int[] { 0, 0, 0 };
		gbl_panel_1.columnWeights = new double[] { 0.0, Double.MIN_VALUE };
		gbl_panel_1.rowWeights = new double[] { 0.0, 0.0, Double.MIN_VALUE };
		panel_1.setLayout(gbl_panel_1);
		panel_1.setBackground(Color.YELLOW);

		mostrarComboBoxMateria();
		mostrarComboBoxProfesor();
	}

	/**
	 * 
	 * @param c
	 */
	public void mostrarComboBoxMateria() {
		List<Materia> materias = new ArrayList<Materia>();
		ControladorGeneral.listadoMaterias(materias);
		for (Materia m : materias) {
			comboBoxMateria.addItem(m);
		}
	}

	/**
	 * 
	 * @param c
	 */
	public void cargarEstudiantes() {
		estudiantes = new ArrayList<Estudiante>();
		List<Sexo> sexos = new ArrayList<Sexo>();
		ControladorGeneral.listadoSexos(sexos);
		ControladorEstudiante.findAllEstudiantes(estudiantes);
		panel_1.removeAll();
		panel_1.repaint();
//		if (estudiantes.size() < 1) {
//			JLabel lblNewLabel = new JLabel("No hay estudiantes asociados");
//			GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
//			gbc_lblNewLabel.insets = new Insets(0, 0, 0, 10);
//			gbc_lblNewLabel.anchor = GridBagConstraints.CENTER;
//			gbc_lblNewLabel.gridx = 0;
//			gbc_lblNewLabel.gridy = 0;
//			panel_1.add(lblNewLabel, gbc_lblNewLabel);
//		}
		for (int i = 0; i < estudiantes.size(); i++) {
			int c = 0;
			PanelNotas p = new PanelNotas(estudiantes.get(i));

			estudiantes.get(i).getSexo();

			paneles.add(p);
			p.setBackground(Color.YELLOW);
			GridBagConstraints gbc_panelesDinamicosNotas = new GridBagConstraints();
			gbc_panelesDinamicosNotas.insets = new Insets(0, 5, 0, 0);
			gbc_panelesDinamicosNotas.anchor = GridBagConstraints.NORTHWEST;
			gbc_panelesDinamicosNotas.gridx = 0;
			gbc_panelesDinamicosNotas.gridy = i;

			// Ver sexo del estudiante
			c = 1;
			ButtonGroup buttonGroup = new ButtonGroup();
			for (Sexo s : sexos) {
				rdbtnNewRadioButton = new JRadioButton(s.getDescripcion());
				if (s.getId() == estudiantes.get(i).getSexo()) {
					rdbtnNewRadioButton.setSelected(true);
				}
				buttonGroup.add(rdbtnNewRadioButton);
				GridBagConstraints gbc_rdbtnNewRadioButton = new GridBagConstraints();
				gbc_rdbtnNewRadioButton.anchor = GridBagConstraints.CENTER;
				gbc_rdbtnNewRadioButton.insets = new Insets(5, 5, 5, 5);
				gbc_rdbtnNewRadioButton.gridx = 1 + c;
				gbc_rdbtnNewRadioButton.gridy = i;
				panel_1.add(rdbtnNewRadioButton, gbc_rdbtnNewRadioButton);
				c++;
			}

			if (i == (estudiantes.size() - 1)) {
				gbc_panelesDinamicosNotas.weighty = 1;
			}
			panel_1.add(p, gbc_panelesDinamicosNotas);
			p.setNota(ControladorGeneral.findNota(((Profesor) comboBoxProfesor.getSelectedItem()).getId(),
					estudiantes.get(i).getId(), ((Materia) comboBoxMateria.getSelectedItem()).getId()));
		}
		frmGestionDeNotas.revalidate();
	}

	/**
	 * 
	 * @param c
	 */
	public void mostrarComboBoxProfesor() {
		List<Profesor> profes = new ArrayList<Profesor>();
		ControladorGeneral.listadoProfes(profes);
		for (Profesor p : profes) {
			comboBoxProfesor.addItem(p);
		}
	}
}
