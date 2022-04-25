package capitulo08.Ejercicio02.vista;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JToolBar;

import capitulo08.Ejercicio02.controladores.ControladorCurso;
import capitulo08.Ejercicio02.entidades.Curso;
import capitulo08.Ejercicio02.entidades.Estudiante;

import javax.swing.JButton;

import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
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

			}
		});
		toolBar.add(btnPrimer);

		btnAnt = new JButton("");
		btnAnt.setIcon(new ImageIcon(GestionEstudiante.class.getResource("/capitulo08/Ejercicio02/res/previous.png")));
		btnAnt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

			}
		});

		toolBar.add(btnAnt);

		btnSig = new JButton("");
		btnSig.setIcon(new ImageIcon(GestionEstudiante.class.getResource("/capitulo08/Ejercicio02/res/next.png")));
		btnSig.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

			}
		});

		toolBar.add(btnSig);

		btnUlt = new JButton("");
		btnUlt.setIcon(new ImageIcon(GestionEstudiante.class.getResource("/capitulo08/Ejercicio02/res/gotoend.png")));
		btnUlt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

			}
		});

		toolBar.add(btnUlt);

		btnNuevo = new JButton("");
		btnNuevo.setIcon(new ImageIcon(GestionEstudiante.class.getResource("/capitulo08/Ejercicio02/res/nuevo.png")));
		btnNuevo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

			}
		});

		toolBar.add(btnNuevo);

		btnGuardar = new JButton("");
		btnGuardar
				.setIcon(new ImageIcon(GestionEstudiante.class.getResource("/capitulo08/Ejercicio02/res/guardar.png")));
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

			}
		});

		toolBar.add(btnGuardar);

		btnBorrar = new JButton("");
		btnBorrar.setIcon(
				new ImageIcon(GestionEstudiante.class.getResource("/capitulo08/Ejercicio02/res/eliminar.png")));
		btnBorrar.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
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
			panel.setJtfApellido1(e.getApellido2());
			panel.setJtfDni(e.getDni());
			panel.setJtfDireccion(e.getDireccion());
			panel.setJtfEmail(e.getEmail());
			panel.setJtfTlf(e.getTlf());
		}
		if (ControladorCurso.findAnteriorCurso(Integer.parseInt(jtfId.getText())) == null) {
			PanelAInsertarEnJDialog.btnNewButton.setEnabled(false);
			PanelAInsertarEnJDialog.btnNewButton_1.setEnabled(false);
		} else {
			PanelAInsertarEnJDialog.btnNewButton.setEnabled(true);
			PanelAInsertarEnJDialog.btnNewButton_1.setEnabled(true);
		}
		if (ControladorCurso.findSiguienteCurso(Integer.parseInt(jtfId.getText())) == null) {
			PanelAInsertarEnJDialog.btnNewButton_2.setEnabled(false);
			PanelAInsertarEnJDialog.btnNewButton_3.setEnabled(false);
		} else {
			PanelAInsertarEnJDialog.btnNewButton_2.setEnabled(true);
			PanelAInsertarEnJDialog.btnNewButton_3.setEnabled(true);
		}
	}

}
