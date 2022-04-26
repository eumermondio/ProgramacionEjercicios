package capitulo08.Ejercicio02.vista;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JToolBar;

import capitulo08.Ejercicio02.controladores.ControladorCurso;
import capitulo08.Ejercicio02.controladores.ControladorProfesor;
import capitulo08.Ejercicio02.controladores.ControladorProfesor;
import capitulo08.Ejercicio02.entidades.Curso;
import capitulo08.Ejercicio02.entidades.Profesor;
import capitulo08.Ejercicio02.entidades.Profesor;

import javax.swing.JButton;

import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.Insets;

public class GestionProfesor extends JPanel {
	public JButton btnPrimer;
	public JButton btnAnt;
	public JButton btnSig;
	public JButton btnUlt;
	public JButton btnNuevo;
	public JButton btnGuardar;
	public JButton btnBorrar;
	public PanelCompartido panel;
	private JLabel lblNewLabel;
	private static GestionProfesor instance = null;

	public static GestionProfesor getInstance() {
		if (instance == null) {
			instance = new GestionProfesor();
		}
		return instance;
	}

	/**
	 * Create the panel.
	 */
	public GestionProfesor() {
		setLayout(new BorderLayout(0, 0));

		JToolBar toolBar = new JToolBar();
		add(toolBar, BorderLayout.NORTH);

		btnPrimer = new JButton("");
		btnPrimer
				.setIcon(new ImageIcon(GestionProfesor.class.getResource("/capitulo08/Ejercicio02/res/gotostart.png")));
		btnPrimer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mostrarProfesor(ControladorProfesor.findPrimer());
			}
		});
		toolBar.add(btnPrimer);

		btnAnt = new JButton("");
		btnAnt.setIcon(new ImageIcon(GestionProfesor.class.getResource("/capitulo08/Ejercicio02/res/previous.png")));
		btnAnt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mostrarProfesor(ControladorProfesor.findAnterior(Integer.parseInt(panel.getJtfId())));
			}
		});

		toolBar.add(btnAnt);

		btnSig = new JButton("");
		btnSig.setIcon(new ImageIcon(GestionProfesor.class.getResource("/capitulo08/Ejercicio02/res/next.png")));
		btnSig.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mostrarProfesor(ControladorProfesor.findSiguiente(Integer.parseInt(panel.getJtfId())));
			}
		});

		toolBar.add(btnSig);

		btnUlt = new JButton("");
		btnUlt.setIcon(new ImageIcon(GestionProfesor.class.getResource("/capitulo08/Ejercicio02/res/gotoend.png")));
		btnUlt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mostrarProfesor(ControladorProfesor.findUltimo());
			}
		});

		toolBar.add(btnUlt);

		btnNuevo = new JButton("");
		btnNuevo.setIcon(new ImageIcon(GestionProfesor.class.getResource("/capitulo08/Ejercicio02/res/nuevo.png")));
		btnNuevo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				nuevo();
			}
		});

		toolBar.add(btnNuevo);

		btnGuardar = new JButton("");
		btnGuardar.setIcon(new ImageIcon(GestionProfesor.class.getResource("/capitulo08/Ejercicio02/res/guardar.png")));
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Profesor es = new Profesor(Integer.parseInt(panel.getJtfId()), panel.getJtfNombre(),
						panel.getJtfApellido1(), panel.getJtfApellido2(), panel.getJtfDni(), panel.getJtfDireccion(),
						panel.getJtfEmail(), panel.getJtfTlf());
				if (ControladorProfesor.actualizar(es) == 1) {
					JOptionPane.showMessageDialog(null, "Actualización o inserción correcta", "Gestion de profesores",
							JOptionPane.INFORMATION_MESSAGE);
				}
				mostrarProfesor(ControladorProfesor.findUltimo());
			}
		});

		toolBar.add(btnGuardar);

		btnBorrar = new JButton("");
		btnBorrar.setIcon(new ImageIcon(GestionProfesor.class.getResource("/capitulo08/Ejercicio02/res/eliminar.png")));
		btnBorrar.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				// yes = 0 no = 1
				if (JOptionPane.showConfirmDialog(null, "¿Desea eliminar el registro?", "Gestión de profesores",
						JOptionPane.YES_NO_OPTION) == 0) {
					if (ControladorProfesor.borrar(Integer.parseInt(panel.getJtfId())) == 1) {
						JOptionPane.showMessageDialog(null, "Borrado correcto", "Gestion de profesores",
								JOptionPane.INFORMATION_MESSAGE);
					}
				}
			}
		});

		toolBar.add(btnBorrar);

		panel = new PanelCompartido();
		add(panel, BorderLayout.CENTER);

		lblNewLabel = new JLabel("GESTIÓN DE PROFESORES");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 1;
		gbc_lblNewLabel.gridy = 8;
		panel.add(lblNewLabel, gbc_lblNewLabel);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
		mostrarProfesor(ControladorProfesor.findPrimer());
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
	public void mostrarProfesor(Profesor p) {
		if (p != null) {
			panel.setJtfId("" + p.getId());
			panel.setJtfNombre(p.getNombre());
			panel.setJtfApellido1(p.getApellido1());
			panel.setJtfApellido2(p.getApellido2());
			panel.setJtfDni(p.getDni());
			panel.setJtfDireccion(p.getDireccion());
			panel.setJtfEmail(p.getEmail());
			panel.setJtfTlf(p.getTlf());
		}
		if (ControladorProfesor.findAnterior(Integer.parseInt(panel.getJtfId())) == null) {
			btnPrimer.setEnabled(false);
			btnAnt.setEnabled(false);
		} else {
			btnPrimer.setEnabled(true);
			btnAnt.setEnabled(true);
		}
		if (ControladorProfesor.findSiguiente(Integer.parseInt(panel.getJtfId())) == null) {
			btnSig.setEnabled(false);
			btnUlt.setEnabled(false);
		} else {
			btnSig.setEnabled(true);
			btnUlt.setEnabled(true);
		}
	}

}
