package capitulo08.Ejercicio02.vista;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JToolBar;

import capitulo08.Ejercicio02.controladores.ControladorCurso;
import capitulo08.Ejercicio02.controladores.ControladorEstudiante;
import capitulo08.Ejercicio02.controladores.ControladorMateria;
import capitulo08.Ejercicio02.entidades.Curso;
import capitulo08.Ejercicio02.entidades.Estudiante;
import capitulo08.Ejercicio02.entidades.Materia;
import capitulo08.Ejercicio02.entidades.Sexo;

import javax.swing.JButton;

import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.Insets;

public class GestionEstudiante extends JPanel {
	public JButton btnPrimer;
	public JButton btnAnt;
	public JButton btnSig;
	public JButton btnUlt;
	public JButton btnNuevo;
	public JButton btnGuardar;
	public JButton btnBorrar;
	public PanelCompartido panel;
	private JLabel lblNewLabel;
	private static GestionEstudiante instance = null;

	public static GestionEstudiante getInstance() {
		if (instance == null) {
			instance = new GestionEstudiante();
		}
		return instance;
	}

	/**
	 * Create the panel.
	 */
	public GestionEstudiante() {
		setLayout(new BorderLayout(0, 0));

		JToolBar toolBar = new JToolBar();
		add(toolBar, BorderLayout.NORTH);

		btnPrimer = new JButton("");
		btnPrimer.setIcon(
				new ImageIcon(GestionEstudiante.class.getResource("/capitulo08/Ejercicio02/res/gotostart.png")));
		btnPrimer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mostrarEstudiante(ControladorEstudiante.findPrimer());
			}
		});
		toolBar.add(btnPrimer);

		btnAnt = new JButton("");
		btnAnt.setIcon(new ImageIcon(GestionEstudiante.class.getResource("/capitulo08/Ejercicio02/res/previous.png")));
		btnAnt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mostrarEstudiante(ControladorEstudiante.findAnterior(Integer.parseInt(panel.getJtfId())));
			}
		});

		toolBar.add(btnAnt);

		btnSig = new JButton("");
		btnSig.setIcon(new ImageIcon(GestionEstudiante.class.getResource("/capitulo08/Ejercicio02/res/next.png")));
		btnSig.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mostrarEstudiante(ControladorEstudiante.findSiguiente(Integer.parseInt(panel.getJtfId())));
			}
		});

		toolBar.add(btnSig);

		btnUlt = new JButton("");
		btnUlt.setIcon(new ImageIcon(GestionEstudiante.class.getResource("/capitulo08/Ejercicio02/res/gotoend.png")));
		btnUlt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mostrarEstudiante(ControladorEstudiante.findUltimo());
			}
		});

		toolBar.add(btnUlt);

		btnNuevo = new JButton("");
		btnNuevo.setIcon(new ImageIcon(GestionEstudiante.class.getResource("/capitulo08/Ejercicio02/res/nuevo.png")));
		btnNuevo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				nuevo();
			}
		});

		toolBar.add(btnNuevo);

		btnGuardar = new JButton("");
		btnGuardar
				.setIcon(new ImageIcon(GestionEstudiante.class.getResource("/capitulo08/Ejercicio02/res/guardar.png")));
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Estudiante es = new Estudiante(Integer.parseInt(panel.getJtfId()), panel.getJtfNombre(),
						panel.getJtfApellido1(), panel.getJtfApellido2(), panel.getJtfDni(), panel.getJtfDireccion(),
						panel.getJtfEmail(), panel.getJtfTlf(), panel.getSexo().getId(),
						panel.getPanel().getImagenEnArrayDeBytes(), panel.getJtfColor());
				if (ControladorEstudiante.actualizar(es) == 1) {
					JOptionPane.showMessageDialog(null, "Actualización o inserción correcta", "Gestion de estudiantes",
							JOptionPane.INFORMATION_MESSAGE);
				}
				mostrarEstudiante(ControladorEstudiante.findUltimo());
			}
		});

		toolBar.add(btnGuardar);

		btnBorrar = new JButton("");
		btnBorrar.setIcon(
				new ImageIcon(GestionEstudiante.class.getResource("/capitulo08/Ejercicio02/res/eliminar.png")));
		btnBorrar.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				// yes = 0 no = 1
				if (JOptionPane.showConfirmDialog(null, "¿Desea eliminar el registro?", "Gestión de estudiantes",
						JOptionPane.YES_NO_OPTION) == 0) {
					if (ControladorEstudiante.borrar(Integer.parseInt(panel.getJtfId())) == 1) {
						JOptionPane.showMessageDialog(null, "Borrado correcto", "Gestion de estudiantes",
								JOptionPane.INFORMATION_MESSAGE);
					}
				}
			}
		});

		toolBar.add(btnBorrar);

		panel = new PanelCompartido();
		add(panel, BorderLayout.CENTER);

		lblNewLabel = new JLabel("GESTIÓN DE ESTUDIANTES");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 1;
		gbc_lblNewLabel.gridy = 8;
		panel.add(lblNewLabel, gbc_lblNewLabel);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
		mostrarEstudiante(ControladorEstudiante.findPrimer());
	}

	/**
	 * 
	 */
	public void nuevo() {
		panel.setJtfId("0");
		panel.setJtfNombre("");
		panel.setJtfApellido1("");
		panel.setJtfApellido2("");
		panel.setJtfDni("");
		panel.setJtfDireccion("");
		panel.setJtfEmail("");
		panel.setJtfTlf("");
	}

	/**
	 * 
	 * @param f
	 */
	public void mostrarEstudiante(Estudiante e) {
		if (e != null) {
			panel.setJtfId("" + e.getId());
			panel.setJtfNombre(e.getNombre());
			panel.setJtfApellido1(e.getApellido1());
			panel.setJtfApellido2(e.getApellido2());
			panel.setJtfDni(e.getDni());
			panel.setJtfDireccion(e.getDireccion());
			panel.setJtfEmail(e.getEmail());
			panel.setJtfTlf(e.getTlf());
			panel.mostrarSexoEstudiante(e);
			panel.mostrarImagen(e);
			panel.setJtfColor(e.getColor());
			if (!panel.getJtfColor().equalsIgnoreCase("")) {
				panel.setBackground(Color.decode(panel.getJtfColor()));
			} else {
				panel.setBackground(Color.WHITE);
			}

		}
		if (ControladorEstudiante.findAnterior(Integer.parseInt(panel.getJtfId())) == null) {
			btnPrimer.setEnabled(false);
			btnAnt.setEnabled(false);
		} else {
			btnPrimer.setEnabled(true);
			btnAnt.setEnabled(true);
		}
		if (ControladorEstudiante.findSiguiente(Integer.parseInt(panel.getJtfId())) == null) {
			btnSig.setEnabled(false);
			btnUlt.setEnabled(false);
		} else {
			btnSig.setEnabled(true);
			btnUlt.setEnabled(true);
		}
	}

}
