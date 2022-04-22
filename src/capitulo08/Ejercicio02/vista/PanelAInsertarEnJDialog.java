package capitulo08.Ejercicio02.vista;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JToolBar;

import capitulo08.Ejercicio01.Coche;
import capitulo08.Ejercicio01.ControladorCoche;
import capitulo08.Ejercicio01.ControladorFabricante;
import capitulo08.Ejercicio01.Fabricante;
import capitulo08.Ejercicio02.controladores.ControladorCurso;
import capitulo08.Ejercicio02.controladores.ControladorMateria;
import capitulo08.Ejercicio02.entidades.Curso;
import capitulo08.Ejercicio02.entidades.Materia;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PanelAInsertarEnJDialog extends JPanel {
	public static JButton btnNewButton;
	public static JButton btnNewButton_1;
	public static JButton btnNewButton_2;
	public static JButton btnNewButton_3;
	public static JButton btnNewButton_4;
	public static JButton btnNewButton_5;
	public static JButton btnNewButton_6;

	/**
	 * Create the panel.
	 */
	public PanelAInsertarEnJDialog(int ent) {
		setLayout(new BorderLayout(0, 0));

		JToolBar toolBar = new JToolBar();
		add(toolBar, BorderLayout.NORTH);

		btnNewButton = new JButton("");
		btnNewButton.setIcon(
				new ImageIcon(PanelAInsertarEnJDialog.class.getResource("/capitulo08/Ejercicio02/res/gotostart.png")));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (ent == 0) {
					GestionCurso.mostrarCurso(ControladorCurso.findPrimerCurso());
				}
				if (ent == 1) {
					GestionMateria.mostrarMateria(ControladorMateria.findPrimerMateria());
				}
			}
		});
		toolBar.add(btnNewButton);

		btnNewButton_1 = new JButton("");
		btnNewButton_1.setIcon(
				new ImageIcon(PanelAInsertarEnJDialog.class.getResource("/capitulo08/Ejercicio02/res/previous.png")));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (ent == 0) {
					GestionCurso.mostrarCurso(
							ControladorCurso.findAnteriorCurso(Integer.parseInt(GestionCurso.jtfId.getText())));
				}
				if (ent == 1) {
					GestionMateria.mostrarMateria(
							ControladorMateria.findAnteriorMateria(Integer.parseInt(GestionMateria.jtfId.getText())));
				}
			}
		});
		// btnNewButton_1.setIcon(new
		// ImageIcon(PanelAInsertarEnJDialog.class.getResource("/tutorialJava/capitulo8_AWT_SWING/res/previous.png")));
		toolBar.add(btnNewButton_1);

		btnNewButton_2 = new JButton("");
		btnNewButton_2.setIcon(
				new ImageIcon(PanelAInsertarEnJDialog.class.getResource("/capitulo08/Ejercicio02/res/next.png")));
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (ent == 0) {
					GestionCurso.mostrarCurso(
							ControladorCurso.findSiguienteCurso(Integer.parseInt(GestionCurso.jtfId.getText())));
				}
				if (ent == 1) {
					GestionMateria.mostrarMateria(
							ControladorMateria.findSiguienteMateria(Integer.parseInt(GestionMateria.jtfId.getText())));
				}
			}
		});
		// btnNewButton_2.setIcon(new
		// ImageIcon(PanelAInsertarEnJDialog.class.getResource("/tutorialJava/capitulo8_AWT_SWING/res/next.png")));
		toolBar.add(btnNewButton_2);

		btnNewButton_3 = new JButton("");
		btnNewButton_3.setIcon(
				new ImageIcon(PanelAInsertarEnJDialog.class.getResource("/capitulo08/Ejercicio02/res/gotoend.png")));
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (ent == 0) {
					GestionCurso.mostrarCurso(ControladorCurso.findUltimoCurso());
				}
				if (ent == 1) {
					GestionMateria.mostrarMateria(ControladorMateria.findUltimoMateria());
				}
			}
		});
		// btnNewButton_3.setIcon(new
		// ImageIcon(PanelAInsertarEnJDialog.class.getResource("/tutorialJava/capitulo8_AWT_SWING/res/gotoend.png")));
		toolBar.add(btnNewButton_3);

		btnNewButton_4 = new JButton("");
		btnNewButton_4.setIcon(
				new ImageIcon(PanelAInsertarEnJDialog.class.getResource("/capitulo08/Ejercicio02/res/nuevo.png")));
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (ent == 0) {
					GestionCurso.jtfId.setText("0");
					GestionCurso.jtfDesc.setText("");
				}
				if (ent == 1) {
					GestionMateria.jtfId.setText("0");
					GestionMateria.jtfNombre.setText("");
					GestionMateria.jtfAcronimo.setText("");
				}
			}
		});
		// btnNewButton_4.setIcon(new
		// ImageIcon(PanelAInsertarEnJDialog.class.getResource("/tutorialJava/capitulo8_AWT_SWING/res/nuevo.png")));
		toolBar.add(btnNewButton_4);

		btnNewButton_5 = new JButton("");
		btnNewButton_5.setIcon(
				new ImageIcon(PanelAInsertarEnJDialog.class.getResource("/capitulo08/Ejercicio02/res/guardar.png")));
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (ent == 0) {
					Curso c = new Curso(Integer.parseInt(GestionCurso.jtfId.getText()), GestionCurso.jtfDesc.getText());
					if (ControladorCurso.actualizarCurso(c) == 1) {
						JOptionPane.showMessageDialog(null, "Actualización o inserción correcta",
								"Gestion de fabricantes", JOptionPane.INFORMATION_MESSAGE);
					}
					GestionCurso.mostrarCurso(ControladorCurso.findUltimoCurso());
				}
				if (ent == 1) {
					Materia m = new Materia(Integer.parseInt(GestionMateria.jtfId.getText()),
							GestionMateria.jtfNombre.getText(), GestionMateria.jtfAcronimo.getText(),
							((Curso) GestionMateria.comboBox.getSelectedItem()).getId());
					if (ControladorMateria.actualizarMateria(m) == 1) {
						JOptionPane.showMessageDialog(null, "Actualización o inserción correcta", "Gestion de materias",
								JOptionPane.INFORMATION_MESSAGE);
					}
					GestionMateria.mostrarMateria(ControladorMateria.findUltimoMateria());
				}
			}
		});
		// btnNewButton_5.setIcon(new
		// ImageIcon(PanelAInsertarEnJDialog.class.getResource("/tutorialJava/capitulo8_AWT_SWING/res/guardar.png")));
		toolBar.add(btnNewButton_5);

		btnNewButton_6 = new JButton("");
		btnNewButton_6.setIcon(
				new ImageIcon(PanelAInsertarEnJDialog.class.getResource("/capitulo08/Ejercicio02/res/eliminar.png")));
		btnNewButton_6.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				// yes = 0 no = 1
				if (ent == 0) {
					if (JOptionPane.showConfirmDialog(null, "¿Desea eliminar el registro?", "Gestión de cursos",
							JOptionPane.YES_NO_OPTION) == 0) {
						if (ControladorCurso.borrarCurso(Integer.parseInt(GestionCurso.jtfId.getText())) == 1) {
							JOptionPane.showMessageDialog(null, "Borrado correcto", "Gestion de cursos",
									JOptionPane.INFORMATION_MESSAGE);
						}
					}

				}

				if (ent == 1) {
					// yes = 0 no = 1
					if (JOptionPane.showConfirmDialog(null, "¿Desea eliminar el registro?", "Gestión de materias",
							JOptionPane.YES_NO_OPTION) == 0) {
						if (ControladorMateria.borrarMateria(Integer.parseInt(GestionMateria.jtfId.getText())) == 1) {
							JOptionPane.showMessageDialog(null, "Borrado correcto", "Gestion de materias",
									JOptionPane.INFORMATION_MESSAGE);
						}
					}
				}
			}
		});
// btnNewButton_6.setIcon(new
// ImageIcon(PanelAInsertarEnJDialog.class.getResource("/tutorialJava/capitulo8_AWT_SWING/res/eliminar.png")));
		toolBar.add(btnNewButton_6);

		if (ent == 0) {
			add(GestionCurso.getInstance(), BorderLayout.CENTER);
		}
		if (ent == 1) {
			add(GestionMateria.getInstance(), BorderLayout.CENTER);
		}

	}

}
